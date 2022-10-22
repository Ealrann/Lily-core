package org.sheepy.lily.core.allocation.dependency;

import org.logoce.extender.api.IAdapterDescriptor;
import org.logoce.extender.api.IAdapterHandle;
import org.sheepy.lily.core.api.allocation.annotation.UpdateDependency;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.DebugUtil;

import java.util.List;

public final class DependencyManager
{
	private final List<DependencyUpdater> updatableDependencies;
	private final List<DependencyWatcher> criticalDependencies;
	private final Runnable onCriticalChange;
	private final CriticalChange criticalDependencyChangeDebug = this::criticalDependencyChangeDebug;

	public DependencyManager(final IObservatoryBuilder observatoryBuilder,
							 final List<DependencyUpdater.Builder> updatableDependencies,
							 final List<DependencyWatcher.Builder> criticalDependencies,
							 final Runnable onUpdatableChange,
							 final Runnable onCriticalChange)
	{
		this.onCriticalChange = onCriticalChange;
		this.updatableDependencies = updatableDependencies.stream()
														  .map(builder -> builder.build(observatoryBuilder,
																						onUpdatableChange))
														  .toList();
		this.criticalDependencies = criticalDependencies.stream()
														.map(builder -> buildCriticalDependencyResolution(
																observatoryBuilder,
																builder))
														.toList();
	}

	private DependencyWatcher buildCriticalDependencyResolution(final IObservatoryBuilder observatoryBuilder,
																final DependencyWatcher.Builder builder)
	{
		if (DebugUtil.DEBUG_ALLOCATION)
		{
			final int index = builder.index();
			final Runnable statusConsumer = () -> criticalDependencyChangeDebug.onChange(index);
			return builder.build(observatoryBuilder, statusConsumer);
		}
		else
		{
			return builder.build(observatoryBuilder, onCriticalChange);
		}
	}

	public void update(ILilyEObject target)
	{
		for (final var dep : updatableDependencies)
		{
			if (dep.isDirty())
			{
				dep.update(target);
			}
		}
	}

	public void free()
	{
		for (final var dep : updatableDependencies)
		{
			dep.free();
		}
		for (final var dep : criticalDependencies)
		{
			dep.free();
		}
	}

	private void criticalDependencyChangeDebug(int index)
	{
		logCriticalChange(index);
		onCriticalChange.run();
	}

	private static void logCriticalChange(final int index)
	{
		System.out.println("Critical dependency changed, index = " + index);
	}

	public static final class Builder
	{
		private final List<DependencyResolver> resolvers;

		public Builder(final List<DependencyResolver> resolvers)
		{
			this.resolvers = resolvers;
		}

		public DependencyManager build(final ILilyEObject target,
									   final IObservatoryBuilder observatoryBuilder,
									   final IAdapterDescriptor.ExtenderContext<?> extenderContext,
									   final Runnable onDirty,
									   final Runnable onObsolete)
		{
			final var updatableDependencies = gatherUpdatableDependencies(target, extenderContext);
			final var criticalDependencies = filterCriticalDependencies(target, updatableDependencies);
			return new DependencyManager(observatoryBuilder,
										 updatableDependencies,
										 criticalDependencies,
										 onDirty,
										 onObsolete);
		}

		private List<DependencyWatcher.Builder> filterCriticalDependencies(final ILilyEObject target,
																		   final List<DependencyUpdater.Builder> updatableDependencies)
		{
			return resolvers.stream()
							.filter(resolver -> updatableDependencies.stream()
																	 .map(DependencyUpdater.Builder::resolutionBuilder)
																	 .map(DependencyWatcher.Builder::resolver)
																	 .noneMatch(res -> res == resolver))
							.map(r -> newDependencyResolutionBuilder(r, target))
							.toList();
		}

		private static DependencyWatcher.Builder newDependencyResolutionBuilder(final DependencyResolver resolver,
																				final ILilyEObject target)
		{
			return new DependencyWatcher.Builder(resolver, target);
		}

		private List<DependencyUpdater.Builder> gatherUpdatableDependencies(final ILilyEObject target,
																			final IAdapterDescriptor.ExtenderContext<?> extenderContext)
		{
			final var updatableDependencies = extenderContext.annotationHandles()
															 .stream(UpdateDependency.class)
															 .map(h -> newDependencyUpdater(target, h))
															 .toList();
			return updatableDependencies;
		}

		private DependencyUpdater.Builder newDependencyUpdater(final ILilyEObject target,
															   final IAdapterHandle.AnnotatedHandle<UpdateDependency> handle)
		{
			final var resolver = resolvers.get(handle.annotation()
													 .index());
			final var resolutionBuilder = new DependencyWatcher.Builder(resolver, target);
			return new DependencyUpdater.Builder(resolutionBuilder, handle);
		}
	}

	@FunctionalInterface
	interface CriticalChange
	{
		void onChange(int index);
	}
}
