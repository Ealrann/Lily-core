package org.sheepy.lily.core.allocation.test.adapters;

import org.sheepy.lily.core.allocation.test.testallocation.AllocationObject;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.extender.IExtender;

public class AllocationObjectAllocation implements IExtender
{
	protected final AllocationObject object;
	protected final IAllocationState allocationState;

	protected AllocationObjectAllocation(AllocationObject object, IAllocationState allocationState)
	{
		this.object = object;
		this.allocationState = allocationState;
		object.setTotalAllocationCount(object.getTotalAllocationCount() + 1);
		object.setCurrentAllocationCount(object.getCurrentAllocationCount() + 1);
	}

	public void requestUpdate()
	{
		allocationState.requestUpdate();
	}

	@Free
	private void free()
	{
		object.setCurrentAllocationCount(object.getCurrentAllocationCount() - 1);
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
