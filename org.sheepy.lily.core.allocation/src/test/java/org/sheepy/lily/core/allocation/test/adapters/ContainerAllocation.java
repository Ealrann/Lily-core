package org.sheepy.lily.core.allocation.test.adapters;

import org.sheepy.lily.core.allocation.test.testallocation.AllocationObject;
import org.sheepy.lily.core.allocation.test.testallocation.Container;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.extender.ModelExtender;

@ModelExtender(scope = Container.class)
@Allocation
@AllocationChild(allocateBeforeParent = true, reportStateToParent = true, features = TestallocationPackage.CONTAINER__BOXES)
public class ContainerAllocation extends AllocationObjectAllocation
{
	protected ContainerAllocation(final AllocationObject object, final IAllocationState allocationState)
	{
		super(object, allocationState);
	}
}
