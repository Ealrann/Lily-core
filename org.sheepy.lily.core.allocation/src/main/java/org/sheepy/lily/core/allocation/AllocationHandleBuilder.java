package org.sheepy.lily.core.allocation;

import org.logoce.extender.api.IAdaptable;
import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.IAdapterDescriptor;
import org.logoce.extender.api.IAdapterHandle;
import org.logoce.extender.ext.IAdapterHandleBuilder;
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
