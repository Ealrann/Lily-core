package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.allocation.description.AllocationDescriptor;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.extender.IExtenderHandleBuilder;
import org.sheepy.lily.core.api.model.ILilyEObject;

public final class AllocationHandleBuilder<E extends IExtender> implements IExtenderHandleBuilder<E>
{
	private final AllocationDescriptor<E> allocationDescriptor;

	public AllocationHandleBuilder(IExtenderDescriptor<E> descriptor)
	{
		allocationDescriptor = new AllocationDescriptor.Builder<>(descriptor).build();
	}

	@Override
	public IExtenderHandle<E> build(final ILilyEObject target)
	{
		return new AllocationHandle<>(target, allocationDescriptor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<AllocationHandle<E>> getHandleClass()
	{
		return (Class<AllocationHandle<E>>) (Class<?>) AllocationHandle.class;
	}

	@Override
	public boolean isAuto()
	{
		return false;
	}
}
