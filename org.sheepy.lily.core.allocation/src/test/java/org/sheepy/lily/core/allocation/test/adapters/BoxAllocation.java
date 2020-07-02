package org.sheepy.lily.core.allocation.test.adapters;

import org.sheepy.lily.core.allocation.test.testallocation.AllocationObject;
import org.sheepy.lily.core.allocation.test.testallocation.Box;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.extender.ModelExtender;

@ModelExtender(scope = Box.class)
@Allocation
public class BoxAllocation extends AllocationObjectAllocation
{
	protected BoxAllocation(final AllocationObject object, final IAllocationState allocationState)
	{
		super(object, allocationState);
	}
}
