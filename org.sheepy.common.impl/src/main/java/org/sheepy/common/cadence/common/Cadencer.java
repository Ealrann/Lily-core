package org.sheepy.common.cadence.common;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.cadence.ICadencer;
import org.sheepy.common.api.cadence.IMainLoop;
import org.sheepy.common.api.cadence.IStatistics;
import org.sheepy.common.api.cadence.ITicker;
import org.sheepy.common.api.resource.IModelExtension;
import org.sheepy.common.api.service.ServiceManager;
import org.sheepy.common.model.application.Application;

public class Cadencer implements ICadencer
{
	protected Application application;
	protected List<TickerWrapper> tickers = new ArrayList<>();

	protected CommandStack commandStack = new CommandStack();
	protected IServiceAdapterFactory adapterFactory = IServiceAdapterFactory.INSTANCE;
	protected ECrossReferenceAdapter crossReferencer = new ECrossReferenceAdapter();

	private Deque<AbstractCadencedWrapper> course = new ArrayDeque<>();
	private Deque<AbstractCadencedWrapper> nextCourse = new ArrayDeque<>();
	private Long mainThread = null;
	private ExecutorService mainExecutor = null;

	private final AtomicBoolean stop = new AtomicBoolean(false);

	private final IStatistics statistics = ServiceManager.getService(IStatistics.class);

	@Override
	@SuppressWarnings("unchecked")
	public void deleteObject(EObject eo)
	{
		for (Setting seting : crossReferencer.getInverseReferences(eo))
		{
			EObject referencer = seting.getEObject();
			EStructuralFeature feature = seting.getEStructuralFeature();

			if (feature.isMany())
			{
				List<EObject> list = (List<EObject>) referencer.eGet(feature);
				list.remove(eo);
			}
			else
			{
				referencer.eSet(feature, null);
			}
		}

		EcoreUtil.remove(eo);
	}

	@Override
	public void start(Application application)
	{
		stop.set(false);
		loadEPackages();
		IServiceAdapterFactory.INSTANCE.setupAutoAdapters(application);
		this.application = application;
		try
		{
			IMainLoop mainloop = IMainLoop.INSTANCE;
			mainExecutor = Executors.newSingleThreadExecutor();
			mainExecutor.submit(new Runnable()
			{
				@Override
				public void run()
				{
					try
					{
						mainThread = Thread.currentThread().getId();
						run(application);
					} catch (Exception e)
					{
						e.printStackTrace();
					}

				}

				private void run(Application application)
				{

					if (mainloop != null)
					{
						mainloop.load(application);
					}
					while (stop.get() == false)
					{
						tick(application.getCadenceInHz());

						if (mainloop != null)
						{
							mainloop.step(application);
							if (mainloop.shouldClose())
							{
								stop.set(true);
							}
						}
					}

					if (mainloop != null)
					{
						mainloop.dispose(application);
					}

					IServiceAdapterFactory.INSTANCE.disposeAutoAdapters(application);
				}
			});
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		System.out.println("[Cadencer] start");
	}

	@Override
	public void stop()
	{
		stop.set(true);
		if (mainExecutor != null)
		{
			try
			{
				mainExecutor.shutdown();
				mainExecutor.awaitTermination(2, TimeUnit.SECONDS);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
				mainExecutor.shutdownNow();
			}
		}

		statistics.printTickersTime();
		getCommandStack().printStats();

		mainThread = null;
	}

	public void tick(long stepNano)
	{
		long duration = System.nanoTime();

		// =========
		// Compute tickers to execute
		// =========
		for (int i = 0; i < tickers.size(); i++)
		{
			AbstractCadencedWrapper ticker = tickers.get(i);
			ticker.accumulate(stepNano);

			if (ticker.shouldTick())
			{
				nextCourse.add(ticker);
			}
		}

		// =========
		// Compute processors to execute
		// =========

		// for (int i = 0; i < cadencedProcessors.size(); i++)
		// {
		// ProcessorTickerWrapper wrapper = cadencedProcessors.get(i);
		// wrapper.accumulate(stepNano);
		//
		// if (wrapper.shouldTick())
		// {
		// nextCourse.add(wrapper);
		// }
		// }

		long blockingDuration = System.nanoTime();
		commandStack.execute();
		blockingDuration = System.nanoTime() - blockingDuration;

		statistics.addAccumulatedDuration("Model Commands", blockingDuration);

		// =========
		// Execute tickers
		// =========
		while (nextCourse.isEmpty() == false)
		{
			Deque<AbstractCadencedWrapper> temp = course;
			course = nextCourse;
			nextCourse = temp;

			while (course.isEmpty() == false)
			{
				AbstractCadencedWrapper ticker = course.poll();

				try
				{
					if (ticker.stop.get())
					{
						tickers.remove(ticker);
					}
					else
					{
						long d = System.nanoTime();

						ticker.tick();

						statistics.addTickerTime(ticker.getLabel(), System.nanoTime() - d);
					}

				} catch (Exception e)
				{
					e.printStackTrace();
				}

				if (ticker.shouldTick())
				{
					nextCourse.add(ticker);
				}
			}

			// =========
			// Execute Models Commands
			// =========

			blockingDuration = System.nanoTime();
			commandStack.execute();
			blockingDuration = System.nanoTime() - blockingDuration;

			statistics.addAccumulatedDuration("Model Commands", blockingDuration);
		}

		statistics.addAccumulatedDuration("Cadencer Tick", System.nanoTime() - duration);
		statistics.update();
	}

	private void loadEPackages()
	{
		for (IModelExtension extension : IModelExtension.EXTENSIONS)
		{
			for (EPackage ePackage : extension.getEPackages())
			{
				// Load factories
				ePackage.eClass();
				System.out.println("\tLoad EPackage: " + ePackage.getName());
			}
		}
	}

	@Override
	public void addTicker(ITicker ticker, int frequency)
	{
		TickerWrapper tw = new TickerWrapper(ticker, frequency);

		tickers.add(tw);
	}

	@Override
	public void removeTicker(ITicker ticker, int frequency)
	{
		for (TickerWrapper tickerWrapper : tickers)
		{
			if (tickerWrapper.getFrequency() == frequency && tickerWrapper.ticker == ticker)
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
}
