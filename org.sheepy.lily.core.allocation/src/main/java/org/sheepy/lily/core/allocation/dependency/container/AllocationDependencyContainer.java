package org.sheepy.lily.core.allocation.dependency.container;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.AllocationInstance;
import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.api.extender.IExtender;

import java.util.function.Consumer;

public final class AllocationDependencyContainer implements IDependencyContainer
{
	private final AllocationInstance<?> resolvedAllocation;
	private Consumer<EAllocationStatus> statusListener;

	public AllocationDependencyContainer(AllocationHandle<?> handle)
	{
		resolvedAllocation = handle.getMainAllocation();
	}

	@Override
	public boolean isAllocationDirty()
	{
		return resolvedAllocation.getStatus() != EAllocationStatus.Allocated;
	}

	@Override
	public IExtender get()
	{
		return resolvedAllocation.getAllocation();
	}

	@Override
	public void listen(Consumer<EAllocationStatus> statusListener)
	{
		this.statusListener = statusListener;
		if (resolvedAllocation != null)
		{
			resolvedAllocation.listen(statusListener);
		}
	}

	@Override
	public void sulk(Consumer<EAllocationStatus> statusListener)
	{
		if (resolvedAllocation != null)
		{
			resolvedAllocation.sulk(this.statusListener);
		}
		this.statusListener = null;
	}
}
