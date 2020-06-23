package org.sheepy.lily.core.cadence.common;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderDescriptorRegistry;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.cadence.tick.TickHandle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Cadencer
{
	private static final String CADENCER_TICK = "Tickers";

	private final CadenceContentAdater cadenceContentAdapter;
	private final List<AbstractTickerWrapper> course = new ArrayList<>();
	private final IStatistics statistics = IStatistics.INSTANCE;

	public Cadencer(ILilyEObject root)
	{
		cadenceContentAdapter = new CadenceContentAdater(root);
	}

	public void free()
	{
		cadenceContentAdapter.free();
	}

	public void tick(long stepNs, long appStepNs)
	{
		// =========
		// Compute tickers to execute
		// =========
		accumulateAndGather(stepNs, appStepNs);
		course.sort(AbstractTickerWrapper.COMPARATOR);

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
					removeTicker(ticker);
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
	}

	private void accumulateAndGather(final long stepNs, final long appStepNs)
	{
		final var tickers = cadenceContentAdapter.tickers;
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
	}

	public void removeTicker(AbstractTickerWrapper ticker)
	{
		cadenceContentAdapter.tickers.remove(ticker);
	}

	private static final class CadenceContentAdater extends EContentAdapter
	{
		private static final List<TickHandle.Builder> TICK_BUILDERS = createTickBuilders();

		private final Map<EObject, List<AbstractTickerWrapper>> tickerMap = new HashMap<>();
		private final List<AbstractTickerWrapper> tickers = new ArrayList<>();
		private final ILilyEObject root;

		public CadenceContentAdater(ILilyEObject root)
		{
			this.root = root;
			root.eAdapters().add(this);
		}

		public void free()
		{
			root.eAdapters().remove(this);
		}

		@Override
		protected void setTarget(EObject target)
		{
			final var lilyObject = (ILilyEObject) target;
			TICK_BUILDERS.stream()
						 .filter(builder -> builder.isApplicable(lilyObject))
						 .map(builder -> builder.build(lilyObject))
						 .forEach(tickHandle -> addTicker(target, new AdapterTickerWrapper(tickHandle)));
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
		}

		private void addTicker(EObject target, AdapterTickerWrapper wrapper)
		{
			tickers.add(wrapper);
			final var list = tickerMap.computeIfAbsent(target, k -> new ArrayList<>());
			list.add(wrapper);
		}

		private static List<TickHandle.Builder> createTickBuilders()
		{
			return IExtenderDescriptorRegistry.INSTANCE.streamDescriptors()
													   .filter(de -> de.containsMethodAnnotation(Tick.class))
													   .flatMap(CadenceContentAdater::createBuildersFromDescriptor)
													   .collect(Collectors.toUnmodifiableList());
		}

		private static Stream<TickHandle.Builder> createBuildersFromDescriptor(IExtenderDescriptor<?> descriptor)
		{
			return descriptor.streamMethodAnnotations(Tick.class)
							 .map(annotation -> new TickHandle.Builder(descriptor, annotation));
		}
	}
}
