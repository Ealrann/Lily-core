package org.sheepy.lily.core.allocation.test.adapters;

import org.sheepy.lily.core.allocation.test.testallocation.AllocationObject;
import org.sheepy.lily.core.allocation.test.testallocation.Node;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.UpdateDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;

import java.util.List;

@ModelExtender(scope = Node.class)
@Allocation
@AllocationChild(features = TestallocationPackage.NODE__LEAVES)
@AllocationDependency(features = TestallocationPackage.NODE__CONTAINER, type = AllocationObjectAllocation.class)
public class NodeAllocation extends AllocationObjectAllocation
{
	protected NodeAllocation(final AllocationObject object, final IAllocationState allocationState)
	{
		super(object, allocationState);
	}

	@UpdateDependency(index = 0)
	private void updateContainers(List<AllocationObjectAllocation> containerAllocations)
	{
		object.setDependencyUpdateCount(object.getDependencyUpdateCount() + 1);
	}
}
