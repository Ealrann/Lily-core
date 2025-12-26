package org.sheepy.lily.core.allocation;

import org.logoce.lmf.core.api.extender.IAdaptable;
import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.extender.IAdapterDescriptor;
import org.logoce.lmf.core.api.extender.IAdapterHandle;
import org.logoce.lmf.core.api.extender.ext.IAdapterHandleBuilder;
import org.sheepy.lily.core.allocation.description.AllocationDescriptor;

public final class AllocationHandleBuilder<E extends IAdapter> implements IAdapterHandleBuilder<E>
{
	private final AllocationDescriptor<E> allocationDescriptor;

	public AllocationHandleBuilder(IAdapterDescriptor<E> descriptor)
	{
		allocationDescriptor = new AllocationDescriptor.Builder<>(descriptor).build();
	}

	@Override
	public IAdapterHandle<E> build(final IAdaptable target)
	{
		return new AllocationHandle<>(target, allocationDescriptor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<AllocationHandle<E>> getHandleClass()
	{
		return (Class<AllocationHandle<E>>) (Class<?>) AllocationHandle.class;
	}
}
