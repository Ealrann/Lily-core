package org.sheepy.lily.core.allocation.dependency;

import org.sheepy.lily.core.allocation.dependency.container.IDependencyContainer;
import org.sheepy.lily.core.allocation.util.GatherObservatoryBuilder;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.util.ModelUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class DependencyResolver
{
	private final AllocationDependency annotation;
	private final int index;
	private final IObservatory observatory;
	private final List<IDependencyContainer> dependencies = new ArrayList<>();

	private boolean dependencyChanged;

	private DependencyResolver(AllocationDependency annotation, int index, GatherObservatoryBuilder observatoryBuilder)
	{
		this.annotation = annotation;
		this.index = index;
		this.observatory = observatoryBuilder.build(this::addDependency, this::removeDependency);
	}

	public void start(final ILilyEObject source)
	{
		final var parent = ModelUtil.findParent(source, annotation.parent());
		observatory.observe(parent);
		dependencyChanged = false;
	}

	public void stop(final ILilyEObject source)
	{
		final var parent = ModelUtil.findParent(source, annotation.parent());
		observatory.shut(parent);
		dependencies.clear();
	}

	private void addDependency(ILilyEObject target)
	{
		dependencies.addAll(buildDependencyContainers(target));
		dependencyChanged = true;
	}

	private void removeDependency(ILilyEObject target)
	{
		dependencies.removeIf(dep -> dep.getTarget() == target);
		dependencyChanged = true;
	}

	private List<IDependencyContainer> buildDependencyContainers(final ILilyEObject target)
	{
		return new IDependencyContainer.Builder(target).build(annotation.type());
	}

	public void resolve()
	{
		for (final var dep : dependencies)
		{
			dep.resolve();
		}
		dependencyChanged = false;
	}

	public Stream<IDependencyContainer> streamDependencies()
	{
		return dependencies.stream();
	}

	@Deprecated
	public boolean isLastResolveDirty()
	{
		return dependencyChanged || dependencies.stream().anyMatch(IDependencyContainer::isAllocationDirty);
	}

	@Override
	public String toString()
	{
		return "Dependency{" + annotation.type().getSimpleName() + '}';
	}

	public int getIndex()
	{
		return index;
	}

	public static final class Builder
	{
		private final AllocationDependency annotation;
		private final int index;
		private final GatherObservatoryBuilder observatoryBuilder;

		public Builder(AllocationDependency annotation, int index)
		{
			this.annotation = annotation;
			this.index = index;
			observatoryBuilder = buildObservatory(annotation);
		}

		private static GatherObservatoryBuilder buildObservatory(AllocationDependency annotation)
		{
			final int[] features = annotation.features();
			final var builder = new GatherObservatoryBuilder();
			builder.explore(0, features);
			return builder;
		}

		public DependencyResolver build()
		{
			return new DependencyResolver(annotation, index, observatoryBuilder);
		}
	}
}
