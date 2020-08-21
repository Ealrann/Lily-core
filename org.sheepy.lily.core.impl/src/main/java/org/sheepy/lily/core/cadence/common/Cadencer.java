package org.sheepy.lily.core.cadence.common;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderDescriptorRegistry;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.cadence.tick.TickHandle;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Cadencer
{
	private static final String CADENCER_TICK = "Tickers";

	private final CadenceContentAdater cadenceContentAdapter;

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
		cadenceContentAdapter.accumulate(stepNs, appStepNs);

		// =========
		// Execute tickers
		// =========
		cadenceContentAdapter.tick();
	}

	private static final class CadenceContentAdater extends EContentAdapter
	{
		private static final List<TickHandle.Builder> TICK_BUILDERS = createTickBuilders();
		private static final IStatistics statistics = IStatistics.INSTANCE;

		private final NavigableMap<Integer, List<AdapterTickerWrapper>> tickerMap = new TreeMap<>();
		private final Deque<AdapterTickerWrapper> stoppedTickers = new ArrayDeque<>();
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
						 .map(AdapterTickerWrapper::new)
						 .forEach(this::addTicker);
			super.setTarget(target);
		}

		@Override
		protected void unsetTarget(EObject target)
		{
			for (final var tickers : tickerMap.values())
			{
				tickers.removeIf(wrapper -> checkAndStop(wrapper, target));
			}
			super.unsetTarget(target);
		}

		private void accumulate(final long stepNs, final long appStepNs)
		{
			for (final var tickers : tickerMap.values())
			{
				for (final var ticker : tickers)
				{
					ticker.accumulate(stepNs, appStepNs);
				}
			}
		}

		private void tick()
		{
			tickerMap.values()
					 .stream()
					 .flatMap(List::stream)
					 .filter(AbstractTickerWrapper::shouldTick)
					 .forEach(this::tick);

			stoppedTickers.forEach(this::removeTicker);
			stoppedTickers.clear();
		}

		private void tick(final AdapterTickerWrapper ticker)
		{
			final long start = System.nanoTime();
			while (!ticker.stop.get() && ticker.shouldTick())
			{
				ticker.tick();
			}
			statistics.addTime(CADENCER_TICK, ticker.getLabel(), System.nanoTime() - start);

			if (ticker.stop.get()) stoppedTickers.add(ticker);
		}

		private void addTicker(final AdapterTickerWrapper ticker)
		{
			final var list = tickerMap.computeIfAbsent(ticker.getPriority(), p -> new ArrayList<>());
			list.add(ticker);
		}

		private void removeTicker(final AdapterTickerWrapper ticker)
		{
			final var list = tickerMap.get(ticker.getPriority());
			if (list != null) list.remove(ticker);
		}

		private static boolean checkAndStop(AdapterTickerWrapper wrapper, EObject target)
		{
			if (wrapper.getTarget() == target)
			{
				wrapper.stop.set(true);
				return true;
			}
			else
			{
				return false;
			}
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
