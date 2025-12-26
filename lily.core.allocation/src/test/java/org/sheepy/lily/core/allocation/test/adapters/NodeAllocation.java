package org.sheepy.lily.core.allocation.test.adapters;

import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.core.allocation.test.testallocation.AllocationObject;
import org.sheepy.lily.core.allocation.test.testallocation.Node;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.ProvideContext;
import org.sheepy.lily.core.api.allocation.annotation.UpdateDependency;

import java.util.List;

@ModelExtender(scope = Node.class)
@Allocation(reuseDirtyAllocations = true, context = TestContext.class)
@AllocationChild(features = Node.FeatureIDs.LEAVES)
@AllocationDependency(features = Node.FeatureIDs.CONTAINER, type = AllocationObjectAllocation.class)
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
	private void updateContainers(final List<AllocationObjectAllocation> containerAllocations)
	{
		object.dependencyUpdateCount(object.dependencyUpdateCount() + 1);
	}
}

