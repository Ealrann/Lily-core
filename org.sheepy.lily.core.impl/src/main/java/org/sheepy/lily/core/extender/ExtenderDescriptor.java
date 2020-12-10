package org.sheepy.lily.core.extender;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.reflect.ConstructorHandle;
import org.sheepy.lily.core.extender.util.ExtenderBuilder;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.reflect.util.AnnotationHandlesBuilder;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ExtenderDescriptor<Extender extends IExtender> implements IExtenderDescriptor<Extender>
{
	private final ModelExtender annotation;
	private final Class<Extender> extenderClass;
	private final ExtenderBuilder<Extender> extenderBuilder;
	private final List<AnnotationHandlesBuilder<?>> executionHandleBuilders;

	public ExtenderDescriptor(final ConstructorHandle<Extender> constructorHandle,
							  final ModelExtender annotation,
							  final Class<Extender> extenderClass,
							  final List<AnnotationHandlesBuilder<?>> executionHandleBuilders)
	{
		this.annotation = annotation;
		this.extenderClass = extenderClass;
		this.extenderBuilder = new ExtenderBuilder<>(constructorHandle, extenderClass);
		this.executionHandleBuilders = List.copyOf(executionHandleBuilders);
	}

	@Override
	public ExtenderContext<Extender> newExtender(final ILilyEObject target,
												 final IObservatoryBuilder observatory,
												 final List<? extends IParameterResolver> resolvers) throws ReflectiveOperationException
	{
		final var extender = extenderBuilder.build(target, observatory, resolvers);
		final var annotationHandles = executionHandleBuilders.stream()
															 .map(builder -> builder.build(extender))
															 .collect(Collectors.toUnmodifiableList());
		return new ExtenderContext<>(extender, annotationHandles);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <A extends Annotation> Stream<A> streamMethodAnnotations(final Class<A> annotationClass)
	{
		return executionHandleBuilders.stream()
									  .filter(builder -> builder.annotationClass() == annotationClass)
									  .map(builder -> (AnnotationHandlesBuilder<A>) builder)
									  .flatMap(AnnotationHandlesBuilder::streamAnnotations);
	}

	@Override
	public boolean match(final Class<? extends IExtender> type)
	{
		return type.isAssignableFrom(extenderClass);
	}

	@Override
	public boolean match(final Class<? extends IExtender> type, final String identifier)
	{
		return match(type) && Objects.equals(annotation.identifier(), identifier);
	}

	@Override
	public boolean isApplicable(final Object target)
	{
		final boolean res = isClassApplicable(target.getClass());

		if (res && annotation.name()
							 .isEmpty() == false)
		{
			return target instanceof LNamedElement named && annotation.name()
																	  .equals(named.getName());
		}

		return res;
	}

	private boolean isClassApplicable(final Class<?> classifier)
	{
		final var scope = annotation.scope();
		if (annotation.inherited())
		{
			return scope.isAssignableFrom(classifier);
		}
		else if (scope.isInterface())
		{
			return isDirectInterfaceOf(classifier, scope);
		}
		else
		{
			return scope.equals(classifier);
		}
	}

	private static boolean isDirectInterfaceOf(final Class<?> rootClass, final Class<?> _interface)
	{
		return Arrays.stream(rootClass.getInterfaces())
					 .anyMatch(i -> i == _interface);
	}

	@Override
	public boolean containsMethodAnnotation(final Class<? extends Annotation> annotationClass)
	{
		return executionHandleBuilders.stream()
									  .map(AnnotationHandlesBuilder::annotationClass)
									  .anyMatch(bAnnotationClass -> bAnnotationClass == annotationClass);
	}

	@Override
	public boolean containsClassAnnotation(final Class<? extends Annotation> annotationClass)
	{
		return extenderClass.isAnnotationPresent(annotationClass);
	}

	@Override
	public boolean equals(final Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ExtenderDescriptor<?> that = (ExtenderDescriptor<?>) o;
		return extenderClass.equals(that.extenderClass);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(extenderClass);
	}

	@Override
	public Class<Extender> extenderClass()
	{
		return extenderClass;
	}

	@Override
	public String toString()
	{
		return "ExtenderDescriptor{" + "extenderClass=" + extenderClass + '}';
	}
}
