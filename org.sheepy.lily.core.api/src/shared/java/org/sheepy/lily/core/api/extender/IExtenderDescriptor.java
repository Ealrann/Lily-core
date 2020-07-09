package org.sheepy.lily.core.api.extender;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;
import org.sheepy.lily.core.api.util.AnnotationHandles;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;

public interface IExtenderDescriptor<T extends IExtender>
{
	Class<T> extenderClass();
	EClass targetEClass();
	boolean isExtenderForType(Class<?> allocationAdapterType);
	boolean isApplicable(EObject target);
	boolean containsMethodAnnotation(Class<? extends Annotation> annotationClass);
	boolean containsClassAnnotation(Class<? extends Annotation> annotationClass);
	<A extends Annotation> Stream<A> streamMethodAnnotations(Class<A> annotationClass);
	ExtenderContext<T> newExtender(ILilyEObject target,
								   IObservatoryBuilder observatory,
								   List<? extends IParameterResolver> resolvers) throws ReflectiveOperationException;

	record ExtenderContext<T extends IExtender>(T extender, List<? extends AnnotationHandles<?>>annotationHandles)
	{
		public Stream<ConsumerHandle> annotatedConsumer(Class<? extends Annotation> annotationClass)
		{
			return annotatedHandles(annotationClass).map(IExtenderHandle.AnnotatedHandle::executionHandle)
													.filter(ConsumerHandle.class::isInstance)
													.map(ConsumerHandle.class::cast);
		}

		@SuppressWarnings("unchecked")
		public <A extends Annotation> Stream<IExtenderHandle.AnnotatedHandle<A>> annotatedHandles(Class<A> annotationClass)
		{
			return annotationHandles.stream()
									.filter(h -> h.annotationClass().equals(annotationClass))
									.flatMap(h -> ((AnnotationHandles<A>) h).handles().stream());
		}
	}
}
