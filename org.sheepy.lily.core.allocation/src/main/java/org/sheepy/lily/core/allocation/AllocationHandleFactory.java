package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandleFactory;

import java.lang.annotation.Annotation;

public final class AllocationHandleFactory implements IExtenderHandleFactory
{
	@Override
	public <E extends IExtender> AllocationHandleBuilder<E> newBuilder(final IExtenderDescriptor<E> descriptor)
	{
		return new AllocationHandleBuilder<>(descriptor);
	}

	@Override
	public Class<? extends Annotation> describedBy()
	{
		return Allocation.class;
	}
}
