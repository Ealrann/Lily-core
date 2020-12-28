package org.sheepy.lily.core.cadence.common;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderDescriptorRegistry;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.cadence.tick.TickHandle;
import org.sheepy.lily.core.cadence.tick.wrapper.ITickerWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
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

		private final NavigableMap<Integer, List<ITickerWrapper>> tickerMap = new TreeMap<>();
		private final ILilyEObject root;

		public CadenceContentAdater(ILilyEObject root)
		{
			this.root = root;
			root.eAdapters()
				.add(this);
		}

		public void free()
		{
			root.eAdapters()
				.remove(this);
		}

		@Override
		protected void setTarget(final EObject target)
		{
			final var lilyObject = (ILilyEObject) target;
			TICK_BUILDERS.stream()
						 .filter(builder -> builder.isApplicable(lilyObject))
						 .map(builder -> builder.build(lilyObject))
						 .map(ITickerWrapper::build)
						 .forEach(this::addTicker);

			lilyObject.adapterManager()
					  .availableDescriptors()
					  .filter(descriptor -> descriptor.containsClassAnnotation(AutoLoad.class))
					  .forEach(descriptor -> lilyObject.adapterManager()
													   .adaptHandle(descriptor));

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
			final var iterator = tickerMap.values()
										  .stream()
										  .flatMap(List::stream)
										  .filter(ITickerWrapper::shouldTick)
										  .iterator();
			// Iterator to flatten the call stack
			while (iterator.hasNext())
			{
				final var ticker = iterator.next();
				if (DebugUtil.DEBUG_ENABLED) tickDebug(ticker);
				else tick(ticker);
			}

			tickerMap.values()
					 .forEach(tickers -> tickers.removeIf(ITickerWrapper::isStopped));
		}

		private static void tickDebug(final ITickerWrapper ticker)
		{
			final long start = System.nanoTime();
			tick(ticker);
			statistics.addTime(CADENCER_TICK, ticker.getLabel(), System.nanoTime() - start);
		}

		private static void tick(final ITickerWrapper ticker)
		{
			final var tickOperations = ticker.getTickHandle()
											 .prepareTickOperations()
											 .collect(Collectors.toUnmodifiableList());

			while (!ticker.isStopped() && ticker.shouldTick())
			{
				final var stepNs = ticker.discharge();
				for (final var operation : tickOperations)
				{
					operation.accept(stepNs);
				}
			}
		}

		private void addTicker(final ITickerWrapper ticker)
		{
			final var list = tickerMap.computeIfAbsent(ticker.getPriority(), p -> new ArrayList<>());
			list.add(ticker);
		}

		private static boolean checkAndStop(ITickerWrapper wrapper, EObject target)
		{
			if (wrapper.getTarget() == target)
			{
				wrapper.stop();
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
