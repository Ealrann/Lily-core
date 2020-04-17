package org.sheepy.lily.core.allocation.test.adapters;

import org.sheepy.lily.core.allocation.test.testallocation.AllocationObject;
import org.sheepy.lily.core.allocation.test.testallocation.Leaf;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;

@ModelExtender(scope = Leaf.class)
@Allocation
@AllocationDependency(features = TestallocationPackage.LEAF__BOXES, type = AllocationObjectAllocation.class)
public class LeafAllocation extends AllocationObjectAllocation
{
	protected LeafAllocation(final AllocationObject object, final IAllocationState allocationState)
	{
		super(object, allocationState);
	}
}
