package org.sheepy.lily.core.cadence.common;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.adapter.impl.AdapterManager;
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.core.api.cadence.ETickerClock;
import org.sheepy.lily.core.api.cadence.ICadencer;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.cadence.ITicker;
import org.sheepy.lily.core.api.engine.IEngineAdapter;
import org.sheepy.lily.core.api.engine.IInputEngineAdapter;
import org.sheepy.lily.core.api.input.IInputManager;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.api.util.TimeUtil;
import org.sheepy.lily.core.cadence.execution.CommandStack;
import org.sheepy.lily.core.model.application.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Cadencer implements ICadencer
{
	private static final String MAIN_LOOP = "Main Loop";
	private static final String CADENCE = "Cadence";
	private static final String CADENCER_TICK = "Tickers";
	private static final String MODEL_COMMANDS = "Model Commands";

	private final Application application;
	private final Runnable stepper;
	private final List<AbstractTickerWrapper> tickers = new ArrayList<>();
	private final List<AbstractTickerWrapper> course = new ArrayList<>();
	private final Map<EObject, List<AbstractTickerWrapper>> tickerMap = new HashMap<>();
	private final CommandStack commandStack = new CommandStack();
	private final ECrossReferenceAdapter crossReferencer = new ECrossReferenceAdapter();
	private final IStatistics statistics = IStatistics.INSTANCE;
	private final AtomicBoolean stop = new AtomicBoolean(false);

	private IInputManager inputManager = null;
	private Long mainThread = null;
	private CadenceContentAdater cadenceContentAdapter;

	public Cadencer(Application application)
	{
		this(application, null);
	}

	public Cadencer(Application application, Runnable stepper)
	{
		this.application = application;
		this.stepper = stepper;
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

		((LilyEObject) application).setupAdapterManager();
		((LilyEObject) application).loadAdapterManager();

		for (final var engine : application.getEngines())
		{
			final var engineAdapter = engine.adapt(IEngineAdapter.class);
			if (engineAdapter != null) engineAdapter.start();
		}

		for (final var engine : application.getEngines())
		{
			final var adapter = engine.adapt(IInputEngineAdapter.class);
			if (adapter != null)
			{
				inputManager = adapter.getInputManager();
				if (inputManager != null)
				{
					break;
				}
			}
		}

		cadenceContentAdapter = new CadenceContentAdater();
		application.eAdapters().add(cadenceContentAdapter);
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

			final long d = System.nanoTime();
			for (final var engine : application.getEngines())
			{
				final var engineAdapter = engine.adapt(IEngineAdapter.class);
				if (engineAdapter != null) engineAdapter.step();
			}

			if (stepper != null)
			{
				stepper.run();
			}

			statistics.addTime(CADENCE, MAIN_LOOP, System.nanoTime() - d);
			statistics.addTime(CADENCE, System.nanoTime() - start);
		}

		dispose();
	}

	private void dispose()
	{
		application.eAdapters().remove(cadenceContentAdapter);
		cadenceContentAdapter = null;

		for (final var engine : application.getEngines())
		{
			final var engineAdapter = engine.adapt(IEngineAdapter.class);
			if (engineAdapter != null) engineAdapter.stop();
		}

		((LilyEObject) application).disposeAdapterManager();

		if (DebugUtil.DEBUG_ENABLED)
		{
			statistics.printTimes();
		}
		statistics.clear();

		mainThread = null;
	}

	public void stop()
	{
		stop.set(true);
	}

	public void tick(long stepNs)
	{
		final long appStepNs = computeStepNs();

		// =========
		// Compute tickers to execute
		// =========
		for (int i = 0; i < tickers.size(); i++)
		{
			final var ticker = tickers.get(i);
			final var accumulation = switch (ticker.clock)
											 {
												 case RealWorld -> stepNs;
												 case ApplicationWorld -> appStepNs;
											 };

			ticker.accumulate(accumulation);

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
			final boolean stopped = ticker.stop.get();

			do
			{
				if (stopped)
				{
					tickers.remove(ticker);
				}
				else
				{
					final long d = System.nanoTime();

					ticker.tick();

					statistics.addTime(CADENCER_TICK, ticker.getLabel(), System.nanoTime() - d);
				}
			} while (!stopped && ticker.shouldTick());
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

	private long computeStepNs()
	{
		final var timeConfig = application.getTimeConfiguration();
		if (timeConfig != null)
		{
			final var unit = TimeUtil.resolveUnit(timeConfig.getUnit());
			final long step = (long) (timeConfig.getTimeStep() * timeConfig.getTimeFactor());
			assert unit != null;
			return unit.toNanos(step);
		}
		else
		{
			return TimeUnit.SECONDS.toNanos(1);
		}
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

				tickerMap.remove(target);
				tickers.removeAll(objectTickers);
			}

			super.unsetTarget(target);
		}

		private void addTicker(EObject target, AdapterTickerWrapper wrapper)
		{
			tickers.add(wrapper);
			final var list = tickerMap.computeIfAbsent(target, k -> new ArrayList<>());
			list.add(wrapper);
		}
	}
}
