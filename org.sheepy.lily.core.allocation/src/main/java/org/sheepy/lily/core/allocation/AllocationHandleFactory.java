package org.sheepy.lily.core.allocation;

import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.IAdapterDescriptor;
import org.logoce.extender.api.IAdapterExtension;
import org.logoce.extender.ext.IAdapterHandleFactory;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;

import java.lang.annotation.Annotation;
import java.util.List;

public final class AllocationHandleFactory implements IAdapterHandleFactory
{
	@Override
	public <E extends IAdapter> AllocationHandleBuilder<E> newBuilder(final IAdapterDescriptor<E> descriptor,
																	  final List<IAdapterExtension.Descriptor> extensionDescriptors)
	{
		return new AllocationHandleBuilder<>(descriptor);
	}

	@Override
	public Class<? extends Annotation> describedBy()
	{
		return Allocation.class;
	}
}
