package org.sheepy.lily.core.api.extender;

import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;

public interface IExtenderDescriptor<T extends IExtender>
{
	Class<T> extenderClass();
	boolean match(Class<? extends IExtender> classifier);
	boolean match(Class<? extends IExtender> classifier, String identifier);
	boolean isApplicable(Object target);
	boolean containsMethodAnnotation(Class<? extends Annotation> annotationClass);
	boolean containsClassAnnotation(Class<? extends Annotation> annotationClass);
	<A extends Annotation> Stream<A> streamMethodAnnotations(Class<A> annotationClass);

	ExtenderContext<T> newExtender(IAdaptable target,
								   Stream<? extends IParameterResolver> resolvers) throws ReflectiveOperationException;

	default IExtenderHandle<T> adapHandle(final IAdaptable object)
	{
		return object.adapterManager()
					 .adaptHandle(this);
	}

	record ExtenderContext<T extends IExtender>(T extender, AnnotationHandles annotationHandles)
	{
		public Stream<ConsumerHandle> annotatedConsumer(Class<? extends Annotation> annotationClass)
		{
			return annotationHandles.stream(annotationClass)
									.map(IExtenderHandle.AnnotatedHandle::executionHandle)
									.filter(ConsumerHandle.class::isInstance)
									.map(ConsumerHandle.class::cast);
		}
	}
}
