package org.sheepy.lily.core.cadence.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.action.ActionDispatcherThread;
import org.sheepy.lily.core.adapter.impl.AdapterManager;
import org.sheepy.lily.core.api.action.context.ActionExecutionContext;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.core.api.cadence.ETickerClock;
import org.sheepy.lily.core.api.cadence.ICadenceAdapter;
import org.sheepy.lily.core.api.cadence.ICadencer;
import org.sheepy.lily.core.api.cadence.IMainLoop;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.cadence.ITicker;
import org.sheepy.lily.core.api.engine.IEngineAdapter;
import org.sheepy.lily.core.api.input.IInputManager;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.cadence.execution.CommandStack;
import org.sheepy.lily.core.model.application.Application;

public class Cadencer implements ICadencer
{
	private static final String MAIN_LOOP = "Main Loop";
	private static final String CADENCE = "Cadence";
	private static final String CADENCER_TICK = "Tickers";
	private static final String MODEL_COMMANDS = "Model Commands";

	private final Application application;
	private final List<AbstractTickerWrapper> tickers = new ArrayList<>();
	private final List<AbstractTickerWrapper> course = new ArrayList<>();
	private final Map<EObject, List<AbstractTickerWrapper>> tickerMap = new HashMap<>();

	protected final CommandStack commandStack = new CommandStack();
	protected final ECrossReferenceAdapter crossReferencer = new ECrossReferenceAdapter();

	protected final IAdapterFactoryService adapterFactory = IAdapterFactoryService.INSTANCE;
	protected final IMainLoop mainloop;
	protected final ICadenceAdapter cadenceAdapter;

	protected IInputManager inputManager = null;
	private Long mainThread = null;

	private final AtomicBoolean stop = new AtomicBoolean(false);

	private final IStatistics statistics = IStatistics.INSTANCE;

	private ActionDispatcherThread dispatcher;
	private CadenceContentAdater cadenceContentAdapter;

	public Cadencer(Application application, IMainLoop mainloop)
	{
		this.application = application;
		this.mainloop = mainloop;
		this.cadenceAdapter = null;
	}

	public Cadencer(Application application)
	{
		this.application = application;
		this.mainloop = null;
		this.cadenceAdapter = application.getCadence().adapt(ICadenceAdapter.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void deleteObject(EObject eo)
	{
		for (final Setting seting : crossReferencer.getInverseReferences(eo))
		{
			final EObject referencer = seting.getEObject();
			final EStructuralFeature feature = seting.getEStructuralFeature();

			if (feature.isMany())
			{
				final List<EObject> list = (List<EObject>) referencer.eGet(feature);
				list.remove(eo);
			}
			else
			{
				referencer.eSet(feature, null);
			}
		}

		EcoreUtil.remove(eo);
	}

	public void load()
	{
		stop.set(false);
		mainThread = Thread.currentThread().getId();

		dispatcher = new ActionDispatcherThread(commandStack, mainThread);
		addTicker(dispatcher, ETickerClock.RealWorld, -1);

		((LilyEObject) application).setupAdapterManager();

		for (final var engine : application.getEngines())
		{
			final var engineAdapter = IEngineAdapter.adapt(engine);
			engineAdapter.start();
		}

		for (final var engine : application.getEngines())
		{
			inputManager = IEngineAdapter.adapt(engine).getInputManager();
			if (inputManager != null)
			{
				break;
			}
		}

		cadenceContentAdapter = new CadenceContentAdater();
		application.eAdapters().add(cadenceContentAdapter);

		if (mainloop != null)
		{
			mainloop.load(application);
		}
	}

	private void dispose()
	{
		if (mainloop != null)
		{
			mainloop.free(application);
		}

		application.eAdapters().remove(cadenceContentAdapter);
		cadenceContentAdapter = null;

		for (final var engine : application.getEngines())
		{
			final var engineAdapter = IEngineAdapter.adapt(engine);
			engineAdapter.stop();
		}

		((LilyEObject) application).uninstallAdapterManager();

		removeTicker(dispatcher, -1);

		if (DebugUtil.DEBUG_ENABLED)
		{
			statistics.printTimes();
		}
		statistics.clear();

		mainThread = null;
	}

	public void run()
	{
		long lastUpdate = System.nanoTime();

		while (stop.get() == false)
		{
			final long start = System.nanoTime();
			if (inputManager != null)
			{
				inputManager.pollInputs();
			}

			final long duration = System.nanoTime();
			final long stepNs = System.nanoTime() - lastUpdate;
			lastUpdate = System.nanoTime();
			tick(stepNs);
			statistics.addTime(CADENCE, CADENCER_TICK, System.nanoTime() - duration);

			if (mainloop != null)
			{
				final long d = System.nanoTime();
				mainloop.step(application);
				statistics.addTime(CADENCE, MAIN_LOOP, System.nanoTime() - d);
			}
			if (cadenceAdapter != null)
			{
				final long d = System.nanoTime();
				cadenceAdapter.run();
				statistics.addTime(CADENCE, MAIN_LOOP, System.nanoTime() - d);
			}
			statistics.addTime(CADENCE, System.nanoTime() - start);
		}

		dispose();
	}

	public void stop()
	{
		stop.set(true);
	}

	public void tick(long stepNs)
	{
		final long appStepNs = (long) (application.getTimeFactor() * stepNs);

		// =========
		// Compute tickers to execute
		// =========
		for (int i = 0; i < tickers.size(); i++)
		{
			final var ticker = tickers.get(i);
			switch (ticker.clock)
			{
			case RealWorld:
				ticker.accumulate(stepNs);
				break;
			case ApplicationWorld:
				ticker.accumulate(appStepNs);
				break;
			}

			if (ticker.shouldTick())
			{
				course.add(ticker);
			}
		}

		course.sort(AbstractTickerWrapper.COMPARATOR);

		long blockingDuration = System.nanoTime();
		commandStack.execute();
		blockingDuration = System.nanoTime() - blockingDuration;
		statistics.addTime(CADENCER_TICK, MODEL_COMMANDS, blockingDuration);

		// =========
		// Execute tickers
		// =========
		int index = 0;
		while (index < course.size())
		{
			final AbstractTickerWrapper ticker = course.get(index++);

			do
			{
				if (ticker.stop.get())
				{
					tickers.remove(ticker);
				}
				else
				{
					final long d = System.nanoTime();

					ticker.tick();

					statistics.addTime(CADENCER_TICK, ticker.getLabel(), System.nanoTime() - d);
				}
			} while (ticker.shouldTick());
		}
		course.clear();

		// =========
		// Execute Models Commands
		// =========

		blockingDuration = System.nanoTime();
		commandStack.execute();
		blockingDuration = System.nanoTime() - blockingDuration;
		statistics.addTime(CADENCE, MODEL_COMMANDS, blockingDuration);
	}

	@Override
	public void postAction(ActionExecutionContext ec)
	{
		if (dispatcher == null)
		{
			new AssertionError("No action dispatcher. Is cadencer running?");
		}

		dispatcher.postAction(ec);
	}

	@Override
	public void addTicker(ITicker ticker, ETickerClock clock, int frequency)
	{
		final TickerWrapper tw = new TickerWrapper(ticker, clock, frequency);

		tickers.add(tw);
	}

	@Override
	public void removeTicker(ITicker ticker, int frequency)
	{
		for (final AbstractTickerWrapper tickerWrapper : tickers)
		{
			if (tickerWrapper.getFrequency() == frequency && tickerWrapper.getTicker() == ticker)
			{
				tickerWrapper.stop.set(true);
			}
		}
	}

	@Override
	public CommandStack getCommandStack()
	{
		return commandStack;
	}

	@Override
	public long getThreadId()
	{
		return mainThread;
	}

	@Override
	public IInputManager getInputManager()
	{
		return inputManager;
	}

	private final class CadenceContentAdater extends EContentAdapter
	{
		@Override
		protected void setTarget(EObject target)
		{
			final var lilyObject = (LilyEObject) target;

			final var tickDescriptors = ((AdapterManager) lilyObject.getAdapterManager()).tickers;
			for (int i = 0; i < tickDescriptors.size(); i++)
			{
				final var ticker = tickDescriptors.get(i);
				final var wrapper = new AdapterTickerWrapper(ticker);
				addTicker(target, wrapper);
			}

			super.setTarget(target);
		}

		@Override
		protected void unsetTarget(EObject target)
		{
			final var objectTickers = tickerMap.get(target);

			if (objectTickers != null)
			{
				for (int i = 0; i < objectTickers.size(); i++)
				{
					final var next = objectTickers.get(i);
					next.stop.set(true);
				}

				tickerMap.put(target, null);
				tickers.removeAll(objectTickers);
			}

			super.unsetTarget(target);
		}

		private void addTicker(EObject target, AdapterTickerWrapper wrapper)
		{
			tickers.add(wrapper);

			var list = tickerMap.get(target);
			if (list == null)
			{
				list = new ArrayList<>();
			}

			list.add(wrapper);
		}
	};

}
