package org.sheepy.lily.core.allocation.test.adapters;

import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.core.allocation.test.testallocation.AllocationObject;
import org.sheepy.lily.core.allocation.test.testallocation.Container;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;

@ModelExtender(scope = Container.class)
@Allocation(context = TestContext.class)
@AllocationChild(allocateBeforeParent = true, features = Container.FeatureIDs.BOXES)
public class ContainerAllocation extends AllocationObjectAllocation
{
	protected ContainerAllocation(final AllocationObject object,
								  final TestContext context,
								  final IAllocationState allocationState)
	{
		super(object, allocationState);

		assert context.level == 0;
		assert context.isPrepared();
	}
}

