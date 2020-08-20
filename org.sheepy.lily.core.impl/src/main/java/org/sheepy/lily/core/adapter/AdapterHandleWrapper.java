package org.sheepy.lily.core.adapter;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.IEMFNotifier;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;

public final class AdapterHandleWrapper<Extender extends IExtender> implements IExtenderHandle<Extender>
{
	private final Extender extender;

	public AdapterHandleWrapper(final Extender extender)
	{
		this.extender = extender;
	}

	@Override
	public void load(ILilyEObject target, IEMFNotifier notifier)
	{
	}

	@Override
	public void dispose(ILilyEObject target, IEMFNotifier notifier)
	{
	}

	@Override
	public <A extends Annotation> Stream<AnnotatedHandle<A>> annotatedHandles(Class<A> annotationClass)
	{
		return Stream.empty();
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
