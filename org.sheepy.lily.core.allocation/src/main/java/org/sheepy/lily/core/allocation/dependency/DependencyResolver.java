package org.sheepy.lily.core.allocation.dependency;

import org.sheepy.lily.core.allocation.dependency.container.IDependencyContainer;
import org.sheepy.lily.core.allocation.util.StructureObserverBuilder;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.notification.util.ListenerList;
import org.sheepy.lily.core.api.util.IModelExplorer;
import org.sheepy.lily.core.api.util.ModelUtil;

import java.util.Optional;
import java.util.stream.Stream;

public final class DependencyResolver
{
	private final AllocationDependency annotation;
	private final int index;
	private final IModelExplorer modelExplorer;
	private final IDependencyContainer.Builder dependencyBuilder;
	private final ListenerList<Runnable> listeners = new ListenerList<>();

	private DependencyResolver(AllocationDependency annotation, int index, StructureObserverBuilder observationBuilder)
	{
		this.annotation = annotation;
		this.index = index;
		observationBuilder.installListeners(this::dependencyChanged, this::dependencyChanged);
		modelExplorer = observationBuilder.buildExplorer();
		dependencyBuilder = new IDependencyContainer.Builder(annotation.type());
	}

	private void dependencyChanged(Object change)
	{
		notifyStructureChange();
	}

	public Stream<IDependencyContainer> resolveDependencies(ILilyEObject source)
	{
		return modelExplorer.stream(source, ILilyEObject.class)
							.map(dependencyBuilder::build)
							.filter(Optional::isPresent)
							.map(Optional::get);
	}

	public int getIndex()
	{
		return index;
	}

	private void notifyStructureChange()
	{
		listeners.notify(Runnable::run);
	}

	public void listen(Runnable structureListener)
	{
		listeners.listen(structureListener);
	}

	public void sulk(Runnable structureListener)
	{
		listeners.sulk(structureListener);
	}

	@Override
	public String toString()
	{
		return "Dependency{" + annotation.type().getSimpleName() + '}';
	}

	public static final class Builder
	{
		private final AllocationDependency annotation;
		private final int index;

		public Builder(AllocationDependency annotation, int index)
		{
			this.annotation = annotation;
			this.index = index;
		}

		public DependencyResolver build(IObservatoryBuilder observatoryBuilder, ILilyEObject source)
		{
			final var observationBuilder = buildObservatory(observatoryBuilder, source);
			return new DependencyResolver(annotation, index, observationBuilder);
		}

		private StructureObserverBuilder buildObservatory(IObservatoryBuilder observatoryBuilder, ILilyEObject source)
		{
			final var parentDistance = ModelUtil.parentDistance(source, annotation.parent());
			final int[] features = annotation.features();
			final var builder = new StructureObserverBuilder(observatoryBuilder, parentDistance, features);
			return builder;
		}
	}
}
