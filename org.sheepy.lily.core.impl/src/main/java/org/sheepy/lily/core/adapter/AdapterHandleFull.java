package org.sheepy.lily.core.adapter;

import org.sheepy.lily.core.adapter.util.AnnotationHandleManager;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.IEMFNotifier;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.util.AnnotationHandles;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;

public final class AdapterHandleFull<Extender extends IExtender> implements IExtenderHandle<Extender>
{
	private final Extender extender;
	private final AnnotationHandleManager annotationHandleManager;
	private final IObservatory observatory;

	public AdapterHandleFull(final Extender extender,
							 final List<? extends AnnotationHandles<?>> annotationHandles,
							 final IObservatory observatory)
	{
		this.extender = extender;
		this.annotationHandleManager = new AnnotationHandleManager(annotationHandles);
		this.observatory = observatory;
	}

	@Override
	public void load(ILilyEObject target, IEMFNotifier notifier)
	{
		if (observatory != null)
		{
			try
			{
				observatory.observe(target);
			}
			catch (Throwable e)
			{
				throwObserveError(e);
			}
		}
		annotationHandleManager.registerHandleListeners(notifier);
		annotationHandleManager.callHandles(Load.class, target);
	}

	@Override
	public void dispose(ILilyEObject target, IEMFNotifier notifier)
	{
		if (observatory != null) observatory.shut(target);
		annotationHandleManager.unregisterHandleListeners(notifier);
		annotationHandleManager.callHandles(Dispose.class, target);
	}

	@Override
	public <A extends Annotation> Stream<IExtenderHandle.AnnotatedHandle<A>> annotatedHandles(Class<A> annotationClass)
	{
		return annotationHandleManager.annotatedHandles(annotationClass);
	}

	private void throwObserveError(final Throwable e)
	{
		final var extenderName = extender.getClass().getSimpleName();
		final var error = new AssertionError("Failed to start observatory of " + extenderName, e);
		error.printStackTrace();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Class<Extender> getExtenderClass()
	{
		return (Class<Extender>) extender.getClass();
	}

	@Override
	public Extender getExtender()
	{
		return extender;
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