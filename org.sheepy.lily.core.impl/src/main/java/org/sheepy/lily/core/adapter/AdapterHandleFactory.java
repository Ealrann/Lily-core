package org.sheepy.lily.core.adapter;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandleBuilder;
import org.sheepy.lily.core.api.extender.IExtenderHandleFactory;

import java.lang.annotation.Annotation;

public final class AdapterHandleFactory implements IExtenderHandleFactory
{
	@Override
	public <E extends IExtender> IExtenderHandleBuilder<E> newBuilder(final IExtenderDescriptor<E> descriptor)
	{
		return new AdapterHandleBuilder<>(descriptor);
	}

	@Override
	public Class<? extends Annotation> describedBy()
	{
		return Adapter.class;
	}
}
