package org.sheepy.lily.core.cadence.common;

import org.logoce.lmf.core.api.extender.IAdapterDescriptor;
import org.logoce.lmf.core.api.extender.IAdapterDescriptorRegistry;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.lang.LMObject;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.cadence.tick.TickHandle;
import org.sheepy.lily.core.cadence.tick.wrapper.ITickerWrapper;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.Stream;

public final class Cadencer
{
	private static final String CADENCER_TICK = "Tickers";

	private final CadenceContentObserver observer;

	public Cadencer(final LMObject root)
	{
		observer = new CadenceContentObserver(root);
	}

	public void free()
	{
		observer.free();
	}

	public void tick(final long stepNs, final long appStepNs)
	{
		observer.accumulate(stepNs, appStepNs);
		observer.tick();
	}

	private static final class CadenceContentObserver
	{
		private static final List<TickHandle.Builder> TICK_BUILDERS = createTickBuilders();
		private static final IStatistics STATISTICS = IStatistics.INSTANCE;

		private final NavigableMap<Integer, List<ITickerWrapper>> tickerMap = new TreeMap<>();
		private final IdentityHashMap<LMObject, Boolean> observed = new IdentityHashMap<>();

		private final LMObject root;
		private final java.util.function.Consumer<Notification> structureListener = this::onStructureChanged;

		private CadenceContentObserver(final LMObject root)
		{
			this.root = root;
			attachSubtree(root);
		}

		public void free()
		{
			detachSubtree(root);
			tickerMap.clear();
		}

		private void attachSubtree(final LMObject target)
		{
			if (!(target instanceof IFeaturedObject featuredObject)) return;
			if (observed.put(target, Boolean.TRUE) != null) return;

			register(featuredObject);
			featuredObject.notifier().listenStructure(structureListener);

			featuredObject.streamChildren()
						  .filter(LMObject.class::isInstance)
						  .map(LMObject.class::cast)
						  .forEach(this::attachSubtree);
		}

		private void detachSubtree(final LMObject target)
		{
			if (!(target instanceof IFeaturedObject featuredObject)) return;
			if (observed.remove(target) == null) return;

			featuredObject.notifier().sulkStructure(structureListener);
			unregister(featuredObject);

			featuredObject.streamChildren()
						  .filter(LMObject.class::isInstance)
						  .map(LMObject.class::cast)
						  .forEach(this::detachSubtree);
		}

		private void onStructureChanged(final Notification notification)
		{
			switch (notification.type())
			{
				case ADD ->
				{
					attachIfObject(notification.newValue());
				}
				case ADD_MANY ->
				{
					for (final var element : notification.newValues())
					{
						attachIfObject(element);
					}
				}
				case SET ->
				{
					detachIfObject(notification.oldValue());
					attachIfObject(notification.newValue());
				}
				case UNSET, REMOVE ->
				{
					detachIfObject(notification.oldValue());
				}
				case REMOVE_MANY ->
				{
					for (final var element : notification.oldValues())
					{
						detachIfObject(element);
					}
				}
				default ->
				{
				}
			}
		}

		private void attachIfObject(final Object value)
		{
			if (value instanceof LMObject object)
			{
				attachSubtree(object);
			}
		}

		private void detachIfObject(final Object value)
		{
			if (value instanceof LMObject object)
			{
				detachSubtree(object);
			}
		}

		private void register(final IFeaturedObject target)
		{
			TICK_BUILDERS.stream()
						 .filter(builder -> builder.isApplicable((LMObject) target))
						 .map(builder -> builder.build((LMObject) target))
						 .map(ITickerWrapper::build)
						 .forEach(this::addTicker);

			target.adapterManager()
				  .availableDescriptors()
				  .filter(descriptor -> descriptor.containsClassAnnotation(AutoLoad.class))
				  .forEach(descriptor -> target.adapterManager().adaptHandle(descriptor));
		}

		private void unregister(final IFeaturedObject target)
		{
			for (final var tickers : tickerMap.values())
			{
				tickers.removeIf(wrapper -> checkAndStop(wrapper, (LMObject) target));
			}
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
			STATISTICS.addTime(CADENCER_TICK, ticker.getLabel(), System.nanoTime() - start);
		}

		private static void tick(final ITickerWrapper ticker)
		{
			final var tickOperations = ticker.getTickHandle()
											 .prepareTickOperations()
											 .toList();

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

		private static boolean checkAndStop(final ITickerWrapper wrapper, final LMObject target)
		{
			if (wrapper.getTarget() == target)
			{
				wrapper.stop();
				return true;
			}
			return false;
		}

		private static List<TickHandle.Builder> createTickBuilders()
		{
			return IAdapterDescriptorRegistry.INSTANCE.streamDescriptors()
													  .filter(de -> de.containsMethodAnnotation(Tick.class))
													  .flatMap(CadenceContentObserver::createBuildersFromDescriptor)
													  .toList();
		}

		private static Stream<TickHandle.Builder> createBuildersFromDescriptor(final IAdapterDescriptor<?> descriptor)
		{
			return descriptor.streamMethodAnnotations(Tick.class)
							 .map(annotation -> new TickHandle.Builder(descriptor, annotation));
		}
	}
}
