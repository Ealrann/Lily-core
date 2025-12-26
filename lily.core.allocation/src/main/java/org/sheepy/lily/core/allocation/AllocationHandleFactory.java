package org.sheepy.lily.core.allocation;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.extender.IAdapterDescriptor;
import org.logoce.lmf.core.api.extender.IAdapterExtension;
import org.logoce.lmf.core.api.extender.ext.IAdapterHandleFactory;
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
