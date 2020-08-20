package org.sheepy.lily.core.adapter.util;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.notification.IEMFNotifier;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;
import org.sheepy.lily.core.api.util.AnnotationHandles;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public final class AnnotationHandleManager
{
	private final List<AnnotationHandles<?>> annotationHandles;

	public AnnotationHandleManager(final List<? extends AnnotationHandles<?>> annotationHandles)
	{
		this.annotationHandles = List.copyOf(annotationHandles);
	}

	public void registerHandleListeners(IEMFNotifier notifier)
	{
		final var notifyHandles = annotatedHandles(NotifyChanged.class);
		notifyHandles.forEach(notifyHandle -> {
			final var featureIds = notifyHandle.annotation().featureIds();
			final var executionHandle = (ConsumerHandle) notifyHandle.executionHandle();
			final var lambda = executionHandle.getLambdaFunction();
			if (lambda instanceof Runnable)
			{
				notifier.listenNoParam((Runnable) lambda, featureIds);
			}
			else if (lambda instanceof Consumer)
			{
				@SuppressWarnings("unchecked") final var consumer = (Consumer<Notification>) lambda;
				notifier.listen(consumer, featureIds);
			}
		});
	}

	public void unregisterHandleListeners(IEMFNotifier notifier)
	{
		final var notifyHandles = annotatedHandles(NotifyChanged.class);
		notifyHandles.forEach(notifyHandle -> {
			final var featureIds = notifyHandle.annotation().featureIds();
			final var executionHandle = (ConsumerHandle) notifyHandle.executionHandle();
			final var lambda = executionHandle.getLambdaFunction();
			if (lambda instanceof Runnable)
			{
				notifier.listenNoParam((Runnable) lambda, featureIds);
			}
			else if (lambda instanceof Consumer)
			{
				@SuppressWarnings("unchecked") final var consumer = (Consumer<Notification>) lambda;
				notifier.listen(consumer, featureIds);
			}
		});
	}

	public <A extends Annotation> void callHandles(final Class<A> annotationClass, Object... parameters)
	{
		annotatedHandles(annotationClass).map(IExtenderHandle.AnnotatedHandle::executionHandle)
										 .map(ConsumerHandle.class::cast)
										 .forEach(handle -> handle.invoke(parameters));
	}

	@SuppressWarnings("unchecked")
	public <A extends Annotation> Stream<IExtenderHandle.AnnotatedHandle<A>> annotatedHandles(Class<A> annotationClass)
	{
		return annotationHandles.stream()
								.filter(h -> h.annotationClass().equals(annotationClass))
								.flatMap(h -> ((AnnotationHandles<A>) h).handles().stream());
	}
}
