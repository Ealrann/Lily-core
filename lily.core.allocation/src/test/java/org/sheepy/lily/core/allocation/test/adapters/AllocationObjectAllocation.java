package org.sheepy.lily.core.allocation.test.adapters;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.sheepy.lily.core.allocation.test.testallocation.AllocationObject;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Free;

public class AllocationObjectAllocation implements IAdapter
{
	protected final AllocationObject object;
	protected final IAllocationState allocationState;

	protected AllocationObjectAllocation(final AllocationObject object, final IAllocationState allocationState)
	{
		this.object = object;
		this.allocationState = allocationState;
		object.totalAllocationCount(object.totalAllocationCount() + 1);
		object.currentAllocationCount(object.currentAllocationCount() + 1);
	}

	public void requestUpdate()
	{
		allocationState.requestUpdate();
	}

	@Free
	private void free()
	{
		object.currentAllocationCount(object.currentAllocationCount() - 1);
	}

	public void lockAllocation()
	{
		allocationState.lockAllocation();
	}

	public IAllocationState.Lock newLock()
	{
		return allocationState.lockUntil();
	}

	public void unlockAllocation()
	{
		allocationState.unlockAllocation();
	}

	public void markObsolete()
	{
		allocationState.setAllocationObsolete();
	}
}
