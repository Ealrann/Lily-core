package org.sheepy.lily.core.adapter.handle;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.IEMFNotifier;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;
import org.sheepy.lily.core.api.util.AnnotationHandles;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public final class AdapterHandle<Extender extends IExtender> implements IExtenderHandle<Extender>
{
	private final Extender extender;
	private final List<AnnotationHandles<?>> annotationHandles;
	private final IObservatory observatory;

	public AdapterHandle(final IExtenderDescriptor.ExtenderContext<Extender> extenderContext,
						 final IObservatory observatory)
	{
		this.extender = extenderContext.extender();
		this.annotationHandles = List.copyOf(extenderContext.annotationHandles());
		this.observatory = observatory;
	}

	@Override
	public void load(ILilyEObject target, IEMFNotifier notifier)
	{
		if (observatory != null) observatory.observe(target);
		registerHandleListeners(notifier);
		callHandles(Load.class, target);
	}

	@Override
	public void dispose(ILilyEObject target, IEMFNotifier notifier)
	{
		if (observatory != null) observatory.shut(target);
		unregisterHandleListeners(notifier);
		callHandles(Dispose.class, target);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Class<Extender> getExtenderClass()
	{
		return (Class<Extender>) extender.getClass();
	}

	private <A extends Annotation> void callHandles(final Class<A> annotationClass, Object... parameters)
	{
		annotatedHandles(annotationClass).map(point -> ((ConsumerHandle) point.executionHandle()))
										 .forEach(handle -> handle.invoke(parameters));
	}

	@Override
	@SuppressWarnings("unchecked")
	public <A extends Annotation> Stream<IExtenderHandle.AnnotatedHandle<A>> annotatedHandles(Class<A> annotationClass)
	{
		return annotationHandles.stream()
								.filter(h -> h.annotationClass().equals(annotationClass))
								.flatMap(h -> ((AnnotationHandles<A>) h).handles().stream());
	}

	private void registerHandleListeners(IEMFNotifier notifier)
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

	private void unregisterHandleListeners(IEMFNotifier notifier)
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

	@Override
	public Extender getExtender()
	{
		return extender;
	}

	@Override
	public boolean isExtenderChangeable()
	{
		return false;
	}

	@Override
	public void listen(final ExtenderListener<Extender> listener)
	{
		// Not changeable, nothing to listen
	}

	@Override
	public void listenNoParam(final Runnable listener)
	{
		// Not changeable, nothing to listen
	}

	@Override
	public void sulk(final ExtenderListener<Extender> listener)
	{
		// Not changeable, nothing to listen
	}

	@Override
	public void sulkNoParam(final Runnable listener)
	{
		// Not changeable, nothing to listen
	}
}
