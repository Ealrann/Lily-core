package org.sheepy.lily.core.adapter;

import org.sheepy.lily.core.adapter.util.AnnotationHandleManager;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.extender.AnnotationHandles;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;

public final class AdapterHandleFull<Extender extends IExtender> implements IExtenderHandle<Extender>
{
	private final IExtenderDescriptor<Extender> descriptor;
	private final Extender extender;
	private final AnnotationHandleManager annotationHandleManager;
	private final IObservatory observatory;

	public AdapterHandleFull(final IExtenderDescriptor<Extender> descriptor,
							 final Extender extender,
							 final List<? extends AnnotationHandles<?>> annotationHandles,
							 final IObservatory observatory)
	{
		this.descriptor = descriptor;
		this.extender = extender;
		this.annotationHandleManager = new AnnotationHandleManager(annotationHandles);
		this.observatory = observatory;
	}

	@Override
	public void load(ILilyEObject target)
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
		annotationHandleManager.registerHandleListeners(target);
		handles(Load.class, target);
	}

	@Override
	public void dispose(ILilyEObject target)
	{
		if (observatory != null) observatory.shut(target);
		annotationHandleManager.unregisterHandleListeners(target);
		handles(Dispose.class, target);
	}

	private <A extends Annotation> void handles(final Class<A> annotationClass, Object... parameters)
	{
		annotationHandleManager.annotatedHandles(annotationClass)
							   .map(IExtenderHandle.AnnotatedHandle::executionHandle)
							   .map(ConsumerHandle.class::cast)
							   .iterator()
							   .forEachRemaining(handle -> handle.invoke(parameters));
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
	public IExtenderDescriptor<Extender> descriptor()
	{
		return descriptor;
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
