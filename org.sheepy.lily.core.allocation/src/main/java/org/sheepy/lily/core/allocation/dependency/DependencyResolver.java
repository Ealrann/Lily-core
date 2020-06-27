package org.sheepy.lily.core.allocation.dependency;

import org.sheepy.lily.core.allocation.dependency.container.IDependencyContainer;
import org.sheepy.lily.core.allocation.util.StructureObserver;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.notification.util.ListenerList;
import org.sheepy.lily.core.api.util.IModelExplorer;
import org.sheepy.lily.core.api.util.ModelUtil;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class DependencyResolver implements IParameterResolver
{
	private final int index;
	private final IModelExplorer modelExplorer;
	private final IDependencyContainer.Builder dependencyBuilder;
	private final ListenerList<Runnable> listeners = new ListenerList<>();

	private DependencyResolver(AllocationDependency annotation,
							   int index,
							   StructureObserver observationBuilder,
							   final IModelExplorer modelExplorer)
	{
		this.index = index;
		this.modelExplorer = modelExplorer;
		observationBuilder.installListeners(this::dependencyChanged, this::dependencyChanged);
		dependencyBuilder = new IDependencyContainer.Builder(annotation.type());
	}

	private void dependencyChanged(Object change)
	{
		notifyStructureChange();
	}

	@Override
	public boolean isApplicable(final Class<?> parameterClass, final Annotation parameterAnnotation)
	{
		return parameterAnnotation instanceof InjectDependency injectAnnotation && injectAnnotation.index() == index;
	}

	@Override
	public Object resolve(final ILilyEObject target, final Class<?> parameterClass)
	{
		final var stream = resolveDependencies(target).map(IDependencyContainer::get);
		if (parameterClass == List.class)
		{
			return stream.collect(Collectors.toUnmodifiableList());
		}
		else
		{
			return stream.findAny().orElse(null);
		}
	}

	public Stream<IDependencyContainer> resolveDependencies(ILilyEObject source)
	{
		return modelExplorer.stream(source).map(this::buildContainer);
	}

	private IDependencyContainer buildContainer(ILilyEObject target)
	{
		try
		{
			final var res = dependencyBuilder.build(target);
			if (res.isPresent())
			{
				return res.get();
			}
			else
			{
				throw new RuntimeException("Cannot resolve dependency " + index);
			}
		}
		catch(RuntimeException e)
		{
			throw new RuntimeException("Cannot resolve dependency " + index, e);
		}
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

	public static record Builder(AllocationDependency annotation, int index)
	{
		public DependencyResolver build(IObservatoryBuilder observatoryBuilder, ILilyEObject source)
		{
			final var observationBuilder = buildObservatory(source);

			return new DependencyResolver(annotation,
										  index,
										  observationBuilder.build(observatoryBuilder),
										  observationBuilder.buildExplorer());
		}

		private StructureObserver.Builder buildObservatory(ILilyEObject source)
		{
			final var parentDistance = ModelUtil.parentDistance(source, annotation.parent());
			final int[] features = annotation.features();
			final var builder = new StructureObserver.Builder(parentDistance, features);
			return builder;
		}
	}
}
