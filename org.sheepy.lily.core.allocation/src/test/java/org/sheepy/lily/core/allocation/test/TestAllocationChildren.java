package org.sheepy.lily.core.allocation.test;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.allocation.test.adapters.AllocationObjectAllocation;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationFactory;
import org.sheepy.lily.core.api.allocation.IAllocationService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class TestAllocationChildren
{
	@Test
	public void testChildren()
	{
		final var root = TestallocationFactory.eINSTANCE.createRoot();
		final var node = TestallocationFactory.eINSTANCE.createNode();
		final var leaf = TestallocationFactory.eINSTANCE.createLeaf();

		root.getNodes().add(node);
		node.getLeaves().add(leaf);

		final var rootAllocation = IAllocationService.INSTANCE.allocate(root, null, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, node.getCurrentAllocationCount());
		assertEquals(1, leaf.getCurrentAllocationCount());

		node.adapt(AllocationObjectAllocation.class).markObsolete();

		rootAllocation.cleanup(null);
		rootAllocation.update(null);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, node.getCurrentAllocationCount());
		assertEquals(1, leaf.getCurrentAllocationCount());
		assertEquals(1, root.getTotalAllocationCount());
		assertEquals(2, node.getTotalAllocationCount());
		assertEquals(2, leaf.getTotalAllocationCount());

		final var nodeAllocation2 = node.adapt(AllocationObjectAllocation.class);
		nodeAllocation2.lockAllocation();
		leaf.adapt(AllocationObjectAllocation.class).markObsolete();

		rootAllocation.cleanup(null);
		rootAllocation.update(null);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(2, node.getCurrentAllocationCount());
		assertEquals(2, leaf.getCurrentAllocationCount());
		assertEquals(1, root.getTotalAllocationCount());
		assertEquals(3, node.getTotalAllocationCount());
		assertEquals(3, leaf.getTotalAllocationCount());

		nodeAllocation2.unlockAllocation();

		rootAllocation.cleanup(null);
		rootAllocation.update(null);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(2, node.getCurrentAllocationCount());
		assertEquals(2, leaf.getCurrentAllocationCount());
		assertEquals(1, root.getTotalAllocationCount());
		assertEquals(3, node.getTotalAllocationCount());
		assertEquals(3, leaf.getTotalAllocationCount());

		nodeAllocation2.markObsolete();
		rootAllocation.cleanup(null);
		rootAllocation.update(null);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, node.getCurrentAllocationCount());
		assertEquals(1, leaf.getCurrentAllocationCount());
		assertEquals(1, root.getTotalAllocationCount());
		assertEquals(3, node.getTotalAllocationCount());
		assertEquals(3, leaf.getTotalAllocationCount());

		rootAllocation.free(null);

		assertEquals(0, root.getCurrentAllocationCount());
		assertEquals(0, node.getCurrentAllocationCount());
		assertEquals(0, leaf.getCurrentAllocationCount());
		assertEquals(1, root.getTotalAllocationCount());
		assertEquals(3, node.getTotalAllocationCount());
		assertEquals(3, leaf.getTotalAllocationCount());
	}

	@Test
	public void testAddChildren()
	{
		final var root = TestallocationFactory.eINSTANCE.createRoot();
		final var node = TestallocationFactory.eINSTANCE.createNode();
		final var leaf1 = TestallocationFactory.eINSTANCE.createLeaf();
		final var leaf2 = TestallocationFactory.eINSTANCE.createLeaf();
		final var leaf3 = TestallocationFactory.eINSTANCE.createLeaf();

		root.getNodes().add(node);
		node.getLeaves().add(leaf1);

		final var rootAllocation = IAllocationService.INSTANCE.allocate(root, null, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, node.getCurrentAllocationCount());
		assertEquals(1, leaf1.getCurrentAllocationCount());
		assertEquals(0, leaf2.getCurrentAllocationCount());
		assertEquals(0, leaf3.getCurrentAllocationCount());

		node.getLeaves().add(leaf2);
		node.getLeaves().add(leaf3);

		rootAllocation.cleanup(null);
		rootAllocation.update(null);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, node.getCurrentAllocationCount());
		assertEquals(1, leaf1.getCurrentAllocationCount());
		assertEquals(1, leaf2.getCurrentAllocationCount());
		assertEquals(1, leaf3.getCurrentAllocationCount());

		node.getLeaves().remove(leaf2);

		rootAllocation.cleanup(null);
		rootAllocation.update(null);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, node.getCurrentAllocationCount());
		assertEquals(1, leaf1.getCurrentAllocationCount());
		assertEquals(0, leaf2.getCurrentAllocationCount());
		assertEquals(1, leaf3.getCurrentAllocationCount());
	}
}
