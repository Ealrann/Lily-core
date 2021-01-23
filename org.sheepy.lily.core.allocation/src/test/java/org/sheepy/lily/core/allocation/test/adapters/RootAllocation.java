package org.sheepy.lily.core.allocation.test.adapters;

import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.allocation.test.testallocation.AllocationObject;
import org.sheepy.lily.core.allocation.test.testallocation.Root;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;

@ModelExtender(scope = Root.class)
@Allocation(context = TestContext.class)
@AllocationChild(features = TestallocationPackage.ROOT__CONTAINERS)
@AllocationChild(features = TestallocationPackage.ROOT__NODES)
public class RootAllocation extends AllocationObjectAllocation
{
	protected RootAllocation(final AllocationObject object,
							 final TestContext context,
							 final IAllocationState allocationState)
	{
		super(object, allocationState);

		assert context.level == 0;
		assert context.isPrepared();
	}
}
