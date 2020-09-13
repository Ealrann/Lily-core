package org.sheepy.lily.core.api.extender;

import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;

public interface IExtenderDescriptor<T extends IExtender> extends IExtenderDescription<T>
{
	ExtenderContext<T> newExtender(ILilyEObject target,
								   IObservatoryBuilder observatory,
								   List<? extends IParameterResolver> resolvers) throws ReflectiveOperationException;

	default IExtenderHandle<T> adapHandle(final ILilyEObject object)
	{
		return object.extenders().adaptHandleFromDescriptor(this);
	}

	final class ExtenderContext<T extends IExtender>
	{
		private final T extender;
		private final List<? extends AnnotationHandles<?>> annotationHandles;

		public ExtenderContext(T extender, List<? extends AnnotationHandles<?>> annotationHandles)
		{
			this.extender = extender;
			this.annotationHandles = annotationHandles;
		}

		public T extender()
		{
			return extender;
		}

		public List<? extends AnnotationHandles<?>> annotationHandles()
		{
			return annotationHandles;
		}

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
									.flatMap(h -> ((AnnotationHandles<A>) h).stream());
		}
	}
}
