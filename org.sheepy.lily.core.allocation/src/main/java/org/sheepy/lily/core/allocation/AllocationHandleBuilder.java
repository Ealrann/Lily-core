package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.allocation.description.AllocationDescriptor;
import org.sheepy.lily.core.api.extender.*;

public final class AllocationHandleBuilder<E extends IExtender> implements IExtenderHandleBuilder<E>
{
	private final AllocationDescriptor<E> allocationDescriptor;

	public AllocationHandleBuilder(IExtenderDescriptor<E> descriptor)
	{
		allocationDescriptor = new AllocationDescriptor.Builder<>(descriptor).build();
	}

	@Override
	public IExtenderHandle<E> build(final IAdaptable target)
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
