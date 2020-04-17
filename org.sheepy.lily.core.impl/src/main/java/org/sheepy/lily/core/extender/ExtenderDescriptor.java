package org.sheepy.lily.core.extender;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolverBuilder;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.reflect.ConstructorHandle;
import org.sheepy.lily.core.api.util.ReflectUtils;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.reflect.util.AnnotationHandlesBuilder;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ExtenderDescriptor<Extender extends IExtender> implements IExtenderDescriptor<Extender>
{
	public final Class<Extender> extenderClass;
	private final EClass targetEClass;
	private final boolean inheritance;
	private final String targetName;
	private final ConstructorHandle<Extender> constructorHandle;
	public final List<AnnotationHandlesBuilder<?>> executionHandleBuilders;

	public ExtenderDescriptor(ConstructorHandle<Extender> constructorHandle,
							  Class<Extender> extenderClass,
							  EClass targetEClass,
							  boolean inheritance,
							  String targetName)
	{
		assert extenderClass != null;

		this.extenderClass = extenderClass;
		this.targetEClass = targetEClass;
		this.inheritance = inheritance;
		this.targetName = targetName;
		this.constructorHandle = constructorHandle;

		final var annotatedMethods = ReflectUtils.gatherAnnotatedMethods(extenderClass);
		this.executionHandleBuilders = List.copyOf(executionHandles(annotatedMethods));
	}

	private static List<AnnotationHandlesBuilder<?>> executionHandles(final List<ReflectUtils.AnnotatedMethod<?>> annotatedMethods)
	{
		final List<AnnotationHandlesBuilder<?>> handleBuilders = new ArrayList<>();
		for (var annotatedMethod : annotatedMethods)
		{
			if (handleBuilders.stream().noneMatch(builder -> builder.matchAddMethod(annotatedMethod)))
			{
				handleBuilders.add(new AnnotationHandlesBuilder<>(annotatedMethod));
			}
		}
		return handleBuilders;
	}

	@Override
	public ExtenderContext<Extender> newExtender(final ILilyEObject target,
												 final IObservatoryBuilder observatory,
												 final List<? extends IParameterResolverBuilder> resolvers) throws ReflectiveOperationException
	{
		final var extender = instantiateExtender(target, observatory, resolvers);
		final var annotationHandles = executionHandleBuilders.stream()
															 .map(builder -> builder.build(extender))
															 .collect(Collectors.toUnmodifiableList());
		return new ExtenderContext<>(extender, annotationHandles);
	}

	private Extender instantiateExtender(ILilyEObject target,
										 IObservatoryBuilder observatory,
										 List<? extends IParameterResolverBuilder> resolvers) throws ReflectiveOperationException
	{
		final var paramTypes = constructorHandle.getJavaConstructor().getParameterTypes();
		final var paramAnnotations = constructorHandle.getJavaConstructor().getParameterAnnotations();
		final int size = paramTypes.length;
		final Object[] parameters = new Object[size];

		for (int i = 0; i < size; i++)
		{
			final var paramType = paramTypes[i];
			final Annotation[] annotations = paramAnnotations[i];
			final var annotation = annotations.length > 0 ? annotations[0] : null;

			if (paramType.isInstance(target))
			{
				parameters[i] = target;
			}
			else if (paramType == IObservatoryBuilder.class)
			{
				parameters[i] = observatory;
			}
			else
			{
				try
				{
					final var resolver = findResolver(target, resolvers, paramType, annotation);
					parameters[i] = resolver.resolve();
				}
				catch (ReflectiveOperationException e)
				{
					throw new ReflectiveOperationException("Cannot resolve parameter " + i + " of constructor " + extenderClass
							.getSimpleName(), e);
				}
			}
		}

		return constructorHandle.newInstance(parameters);
	}

	private static IParameterResolver findResolver(final ILilyEObject target,
												   final List<? extends IParameterResolverBuilder> resolvers,
												   final Class<?> paramType,
												   final Annotation annotation) throws ReflectiveOperationException
	{
		return resolvers.stream()
						.map(resolver -> resolver.tryBuild(target, paramType, annotation))
						.filter(Optional::isPresent)
						.findAny()
						.map(Optional::get)
						.orElseThrow(ReflectiveOperationException::new);
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
	public boolean isExtenderForType(Class<?> type)
	{
		return type.isAssignableFrom(this.extenderClass);
	}

	@Override
	public boolean isApplicable(EObject target)
	{
		final boolean res = isClassApplicable(target.eClass());

		if (res && targetName.isEmpty() == false)
		{
			return target instanceof LNamedElement named && targetName.equals(named.getName());
		}

		return res;
	}

	public boolean isClassApplicable(EClass eClass)
	{
		if (inheritance)
		{
			return targetEClass == EcorePackage.Literals.EOBJECT || targetEClass.isSuperTypeOf(eClass);
		}
		else
		{
			return eClass == targetEClass;
		}
	}

	@Override
	public boolean containsMethodAnnotation(final Class<? extends Annotation> annotationClass)
	{
		return extenderClass.isAnnotationPresent(annotationClass);
	}

	@Override
	public boolean containsClassAnnotation(final Class<? extends Annotation> annotationClass)
	{
		return executionHandleBuilders.stream()
									  .map(AnnotationHandlesBuilder::annotationClass)
									  .anyMatch(bAnnotationClass -> bAnnotationClass == annotationClass);
	}

	@Override
	public Class<Extender> extenderClass()
	{
		return extenderClass;
	}

	@Override
	public EClass targetEClass()
	{
		return targetEClass;
	}

	@Override
	public String toString()
	{
		return "ExtenderDescriptor{" + "extenderClass=" + extenderClass + '}';
	}
}
