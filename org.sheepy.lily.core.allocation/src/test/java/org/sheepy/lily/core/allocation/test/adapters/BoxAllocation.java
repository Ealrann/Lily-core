package org.sheepy.lily.core.allocation.test.adapters;

import org.sheepy.lily.core.allocation.test.testallocation.AllocationObject;
import org.sheepy.lily.core.allocation.test.testallocation.Box;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.logoce.extender.api.ModelExtender;

@ModelExtender(scope = Box.class)
@Allocation(context = TestContext.class, activator = TestallocationPackage.BOX__ACTIVATED)
public class BoxAllocation extends AllocationObjectAllocation
{
	protected BoxAllocation(final AllocationObject object,
							final TestContext context,
							final IAllocationState allocationState)
	{
		super(object, allocationState);

		assert context.level == 0;
		assert context.isPrepared();
	}
}
