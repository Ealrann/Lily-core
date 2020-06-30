package org.sheepy.lily.core.allocation.dependency;

import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.api.allocation.annotation.UpdateDependency;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.util.AnnotationHandles;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public final class DependencyManager
{
	private final List<DependencyUpdater> updatableDependencies;
	private final List<DependencyResolution> criticalDependencies;
	private final Runnable onDirty;
	private final Runnable onObsolete;
	private final Consumer<EAllocationStatus> updatableDependencyChange = this::updatableDependencyChange;
	private final Consumer<EAllocationStatus> criticalDependencyChange = this::criticalDependencyChange;

	public DependencyManager(final List<DependencyUpdater.Builder> updatableDependencies,
							 final List<DependencyResolution.Builder> criticalDependencies,
							 final Runnable onDirty,
							 final Runnable onObsolete)
	{
		this.updatableDependencies = updatableDependencies.stream()
														  .map(builder -> builder.build(updatableDependencyChange))
														  .collect(Collectors.toUnmodifiableList());
		this.criticalDependencies = criticalDependencies.stream()
														.map(builder -> builder.build(criticalDependencyChange))
														.collect(Collectors.toUnmodifiableList());
		this.onDirty = onDirty;
		this.onObsolete = onObsolete;
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

	private void updatableDependencyChange(EAllocationStatus newStatus)
	{
		if (newStatus != EAllocationStatus.Allocated)
		{
			onDirty.run();
		}
	}

	private void criticalDependencyChange(EAllocationStatus newStatus)
	{
		switch (newStatus)
		{
			case Dirty -> onDirty.run();
			case Obsolete, Free -> onObsolete.run();
		}
	}

	public static final class Builder
	{
		private final List<DependencyResolver> resolvers;
		private final ILilyEObject target;

		public Builder(final List<DependencyResolver> resolvers, final ILilyEObject target)
		{
			this.resolvers = resolvers;
			this.target = target;
		}

		public DependencyManager build(final IExtenderDescriptor.ExtenderContext<?> extenderContext,
									   final Runnable onDirty,
									   final Runnable onObsolete)
		{
			final var updatableDependencies = gatherUpdatableDependencies(extenderContext);
			final var criticalDependencies = filterCriticalDependencies(updatableDependencies);
			return new DependencyManager(updatableDependencies, criticalDependencies, onDirty, onObsolete);
		}

		private List<DependencyResolution.Builder> filterCriticalDependencies(final List<DependencyUpdater.Builder> updatableDependencies)
		{
			return resolvers.stream()
							.filter(resolver -> updatableDependencies.stream()
																	 .map(DependencyUpdater.Builder::resolutionBuilder)
																	 .map(DependencyResolution.Builder::resolver)
																	 .noneMatch(res -> res == resolver))
							.map(this::newDependencyResolutionBuilder)
							.collect(Collectors.toUnmodifiableList());
		}

		private DependencyResolution.Builder newDependencyResolutionBuilder(DependencyResolver resolver)
		{
			return new DependencyResolution.Builder(resolver, target);
		}

		@SuppressWarnings("unchecked")
		private List<DependencyUpdater.Builder> gatherUpdatableDependencies(final IExtenderDescriptor.ExtenderContext<?> extenderContext)
		{
			final var updatableDependencies = extenderContext.annotationHandles()
															 .stream()
															 .filter(handle -> handle.annotationClass() == UpdateDependency.class)
															 .map(handle -> (AnnotationHandles<UpdateDependency>) handle)
															 .flatMap(handle -> handle.handles().stream())
															 .map(this::newDependencyUpdater)
															 .collect(Collectors.toUnmodifiableList());
			return updatableDependencies;
		}

		private DependencyUpdater.Builder newDependencyUpdater(final IExtenderHandle.AnnotatedHandle<UpdateDependency> handle)
		{
			final var resolver = resolvers.get(handle.annotation().index());
			final var resolutionBuilder = new DependencyResolution.Builder(resolver, target);
			return new DependencyUpdater.Builder(resolutionBuilder, handle);
		}
	}
}
