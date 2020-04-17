package org.sheepy.lily.core.allocation.dependency.container;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.extender.IExtender;

public final class AllocationDependencyContainer implements IDependencyContainer
{
	private final AllocationHandle<?> handle;
	private IExtender resolvedAllocation = null;

	public AllocationDependencyContainer(AllocationHandle<?> handle)
	{
		this.handle = handle;
	}

	@Override
	public void resolve()
	{
		resolvedAllocation = handle.getExtender();
	}

	@Override
	public boolean isAllocationDirty()
	{
		return handle.getExtender() != resolvedAllocation;
	}

	@Override
	public IExtender get()
	{
		return resolvedAllocation;
	}

	@Override
	public ILilyEObject getTarget()
	{
		return handle.getTarget();
	}
}