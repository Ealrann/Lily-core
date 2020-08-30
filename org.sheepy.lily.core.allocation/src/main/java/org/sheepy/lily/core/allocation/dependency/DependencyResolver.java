package org.sheepy.lily.core.allocation.dependency;

import org.sheepy.lily.core.allocation.dependency.container.DependencyContainer;
import org.sheepy.lily.core.allocation.util.StructureObserver;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	public Object resolve(final ILilyEObject source, final Class<?> parameterClass)
	{
		final var stream = structureObserver.getExplorer()
											.stream(source)
											.map(this::resolve)
											.flatMap(Optional::stream)
											.map(IExtenderHandle::getExtender);
		if (parameterClass == List.class)
		{
			return stream.collect(Collectors.toUnmodifiableList());
		}
		else
		{
			return stream.findAny().orElse(null);
		}
	}

	public Stream<DependencyContainer> resolveDependencies(final ILilyEObject source,
														   final Runnable whenResolutionObsolete)
	{
		return structureObserver.getExplorer()
								.stream(source)
								.map(target -> buildContainer(target, whenResolutionObsolete));
	}

	private DependencyContainer buildContainer(final ILilyEObject target, final Runnable whenResolutionObsolete)
	{
		try
		{
			final var res = resolve(target).map(h -> new DependencyContainer(h, whenResolutionObsolete));
			if (res.isPresent())
			{
				return res.get();
			}
			else
			{
				throw new RuntimeException("Cannot resolve dependency " + index + " " + target.eClass().getName());
			}
		}
		catch (RuntimeException e)
		{
			throw new RuntimeException("Cannot resolve dependency " + index, e);
		}
	}

	private Optional<? extends IExtenderHandle<?>> resolve(final ILilyEObject target)
	{
		return target.extenders().adaptHandles(type).findAny();
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
}
