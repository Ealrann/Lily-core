package org.sheepy.lily.core.api.extender;

import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;

public interface IExtenderDescriptor<T extends IExtender> extends IExtenderDescription<T>
{
	ExtenderContext<T> newExtender(IAdaptable target,
								   Stream<? extends IParameterResolver> resolvers) throws ReflectiveOperationException;

	default IExtenderHandle<T> adapHandle(final IAdaptable object)
	{
		return object.adapterManager()
					 .adaptHandleFromDescriptor(this);
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
