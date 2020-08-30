package org.sheepy.lily.core.allocation.test.adapters;

import org.sheepy.lily.core.allocation.test.testallocation.AllocationObject;
import org.sheepy.lily.core.allocation.test.testallocation.Node;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.extender.ModelExtender;

import java.util.List;

@ModelExtender(scope = Node.class)
@Allocation(reuseDirtyAllocations = true, context = TestContext.class)
@AllocationChild(features = TestallocationPackage.NODE__LEAVES)
@AllocationDependency(features = TestallocationPackage.NODE__CONTAINER, type = AllocationObjectAllocation.class)
public class NodeAllocation extends AllocationObjectAllocation
{
	private final TestContext providedContext = new TestContext(1);

	protected NodeAllocation(final AllocationObject object,
							 final TestContext context,
							 final IAllocationState allocationState)
	{
		super(object, allocationState);

		assert context.level == 0;
		assert context.isPrepared();
	}

	@ProvideContext
	private TestContext provideContext()
	{
		return providedContext;
	}

	@UpdateDependency(index = 0)
	private void updateContainers(List<AllocationObjectAllocation> containerAllocations)
	{
		object.setDependencyUpdateCount(object.getDependencyUpdateCount() + 1);
	}
}
