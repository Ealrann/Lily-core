package org.sheepy.lily.core.allocation.dependency;

import org.sheepy.lily.core.allocation.dependency.container.DependencyContainer;
import org.sheepy.lily.core.allocation.util.StructureObserver;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.IAdaptable;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.IModelExplorer;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public final class DependencyResolver implements IParameterResolver
{
	private final int index;
	private final StructureObserver structureObserver;
	private final Class<? extends IExtender> type;

	public DependencyResolver(AllocationDependency annotation, int index)
	{
		this.index = index;
		this.structureObserver = buildStructureObserver(annotation);
		this.type = annotation.type();
	}

	private static StructureObserver buildStructureObserver(final AllocationDependency annotation)
	{
		final int[] features = annotation.features();
		final var builder = new StructureObserver(annotation.parent(), features);
		return builder;
	}

	@Override
	public boolean isApplicable(final Class<?> parameterClass, final Annotation parameterAnnotation)
	{
		return parameterAnnotation instanceof InjectDependency injectAnnotation && injectAnnotation.index() == index;
	}

	@Override
	public Object resolve(final IAdaptable source, final Class<?> parameterClass)
	{
		final var stream = structureObserver.getExplorer()
											.stream((ILilyEObject) source)
											.map(this::resolveOptional)
											.flatMap(Optional::stream)
											.map(IExtenderHandle::getExtender)
											.filter(Objects::nonNull);
		if (parameterClass == List.class)
		{
			return stream.collect(Collectors.toUnmodifiableList());
		}
		else
		{
			return stream.findAny()
						 .orElse(null);
		}
	}

	public DependencyContainer buildContainer(final ILilyEObject target, final Runnable whenResolutionObsolete)
	{
		try
		{
			return new DependencyContainer(resolve(target), whenResolutionObsolete);
		}
		catch (RuntimeException e)
		{
			throw new RuntimeException("Cannot resolve dependency " + index, e);
		}
	}

	public IExtenderHandle<?> resolve(final ILilyEObject target)
	{
		final var resolution = resolveOptional(target);
		if (resolution.isPresent()) return resolution.get();
		else throw new RuntimeException("Cannot resolve dependency " + index + " " + target.eClass()
																						   .getName());
	}

	private Optional<? extends IExtenderHandle<?>> resolveOptional(final ILilyEObject target)
	{
		return target.adapterManager()
					 .adaptHandles(type)
					 .findAny();
	}

	public int getIndex()
	{
		return index;
	}

	public void installStructureListener(final ILilyEObject source,
										 final IObservatoryBuilder observatoryBuilder,
										 final Runnable structureChanged)
	{
		structureObserver.installListener(source, observatoryBuilder, structureChanged);
	}

	public IModelExplorer getModelExplorer()
	{
		return structureObserver.getExplorer();
	}
}
