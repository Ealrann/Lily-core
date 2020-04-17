package org.sheepy.lily.core.allocation.test.adapters;

import org.sheepy.lily.core.allocation.test.testallocation.AllocationObject;
import org.sheepy.lily.core.allocation.test.testallocation.Root;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.extender.ModelExtender;

@ModelExtender(scope = Root.class)
@Allocation
@AllocationChild(features = TestallocationPackage.ROOT__CONTAINERS)
@AllocationChild(features = TestallocationPackage.ROOT__NODES)
public class RootAllocation extends AllocationObjectAllocation
{
	protected RootAllocation(final AllocationObject object, final IAllocationState allocationState)
	{
		super(object, allocationState);
	}
}
