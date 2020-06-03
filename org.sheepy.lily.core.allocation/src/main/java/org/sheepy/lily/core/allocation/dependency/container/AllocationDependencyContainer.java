package org.sheepy.lily.core.allocation.dependency.container;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.AllocationInstance;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;

public final class AllocationDependencyContainer implements IDependencyContainer
{
	private final AllocationHandle<?> handle;
	private AllocationInstance<?> resolvedAllocation = null;

	public AllocationDependencyContainer(AllocationHandle<?> handle)
	{
		this.handle = handle;
	}

	@Override
	public void resolve()
	{
		resolvedAllocation = handle.getMainAllocation();
	}

	@Override
	public boolean isAllocationDirty()
	{
		return resolvedAllocation.getStatus() != AllocationInstance.EStatus.Allocated;
	}

	@Override
	public IExtender get()
	{
		return resolvedAllocation.getAllocation();
	}

	@Override
	public ILilyEObject getTarget()
	{
		return handle.getTarget();
	}
}