package org.sheepy.lily.core.adapter;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;

public final class AdapterHandleWrapper<Extender extends IExtender> implements IExtenderHandle<Extender>
{
	private final IExtenderDescriptor<Extender> descriptor;
	private final Extender extender;

	public AdapterHandleWrapper(final IExtenderDescriptor<Extender> descriptor, final Extender extender)
	{
		this.descriptor = descriptor;
		this.extender = extender;
	}

	@Override
	public void load(ILilyEObject target)
	{
	}

	@Override
	public void dispose(ILilyEObject target)
	{
	}

	@Override
	public <A extends Annotation> Stream<AnnotatedHandle<A>> annotatedHandles(Class<A> annotationClass)
	{
		return Stream.empty();
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
