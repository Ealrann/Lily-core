package org.sheepy.lily.core.allocation.test;

import org.junit.jupiter.api.Test;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.sheepy.lily.core.allocation.test.adapters.AllocationObjectAllocation;
import org.sheepy.lily.core.allocation.test.adapters.TestContext;
import org.sheepy.lily.core.allocation.test.testallocation.Box;
import org.sheepy.lily.core.allocation.test.testallocation.Container;
import org.sheepy.lily.core.allocation.test.testallocation.Leaf;
import org.sheepy.lily.core.allocation.test.testallocation.Node;
import org.sheepy.lily.core.allocation.test.testallocation.Root;
import org.sheepy.lily.core.api.allocation.IAllocationService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class TestAllocationChildren
{
	@Test
	public void testChildren()
	{
		final var context = new TestContext(0);
		final var root = Root.builder().build();
		final var node = Node.builder().build();
		final var leaf = Leaf.builder().build();

		root.nodes().add(node);
		node.leaves().add(leaf);

		((FeaturedObject<?>) root).loadExtenderManager();
		final var allocator = IAllocationService.INSTANCE.buildAllocator(root,
																		 context,
																		 AllocationObjectAllocation.class);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, leaf.currentAllocationCount());

		node.adapt(AllocationObjectAllocation.class).markObsolete();

		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(1, root.totalAllocationCount());
		assertEquals(2, node.totalAllocationCount());
		assertEquals(2, leaf.totalAllocationCount());

		final var nodeAllocation2 = node.adapt(AllocationObjectAllocation.class);
		nodeAllocation2.lockAllocation();
		leaf.adapt(AllocationObjectAllocation.class).markObsolete();

		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(2, node.currentAllocationCount());
		assertEquals(2, leaf.currentAllocationCount());
		assertEquals(1, root.totalAllocationCount());
		assertEquals(3, node.totalAllocationCount());
		assertEquals(3, leaf.totalAllocationCount());

		nodeAllocation2.unlockAllocation();
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(2, node.currentAllocationCount());
		assertEquals(2, leaf.currentAllocationCount());
		assertEquals(1, root.totalAllocationCount());
		assertEquals(3, node.totalAllocationCount());
		assertEquals(3, leaf.totalAllocationCount());

		nodeAllocation2.markObsolete();
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(1, root.totalAllocationCount());
		assertEquals(3, node.totalAllocationCount());
		assertEquals(3, leaf.totalAllocationCount());

		allocator.free();

		assertEquals(0, root.currentAllocationCount());
		assertEquals(0, node.currentAllocationCount());
		assertEquals(0, leaf.currentAllocationCount());
		assertEquals(1, root.totalAllocationCount());
		assertEquals(3, node.totalAllocationCount());
		assertEquals(3, leaf.totalAllocationCount());
	}

	@Test
	public void testAddChildren()
	{
		final var context = new TestContext(0);
		final var root = Root.builder().build();
		final var node = Node.builder().build();
		final var leaf1 = Leaf.builder().build();
		final var leaf2 = Leaf.builder().build();
		final var leaf3 = Leaf.builder().build();

		root.nodes().add(node);
		node.leaves().add(leaf1);

		((FeaturedObject<?>) root).loadExtenderManager();
		final var allocator = IAllocationService.INSTANCE.buildAllocator(root,
																		 context,
																		 AllocationObjectAllocation.class);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, leaf1.currentAllocationCount());
		assertEquals(0, leaf2.currentAllocationCount());
		assertEquals(0, leaf3.currentAllocationCount());

		node.leaves().add(leaf2);
		node.leaves().add(leaf3);

		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, leaf1.currentAllocationCount());
		assertEquals(1, leaf2.currentAllocationCount());
		assertEquals(1, leaf3.currentAllocationCount());

		node.leaves().remove(leaf2);

		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, leaf1.currentAllocationCount());
		assertEquals(0, leaf2.currentAllocationCount());
		assertEquals(1, leaf3.currentAllocationCount());
	}

	@Test
	public void testChangeChildren()
	{
		final var context = new TestContext(0);
		final var root = Root.builder().build();
		final var container = Container.builder().build();
		final var box1 = Box.builder().build();
		final var box2 = Box.builder().build();

		root.containers().add(container);
		container.boxes().add(box1);

		((FeaturedObject<?>) root).loadExtenderManager();
		final var allocator = IAllocationService.INSTANCE.buildAllocator(root,
																		 context,
																		 AllocationObjectAllocation.class);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, box1.currentAllocationCount());
		assertEquals(0, box2.currentAllocationCount());

		container.boxes().clear();
		container.boxes().add(box2);

		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(0, box1.currentAllocationCount());
		assertEquals(1, box2.currentAllocationCount());
	}

	@Test
	public void testDeactivateChildren()
	{
		final var context = new TestContext(0);
		final var root = Root.builder().build();
		final var container = Container.builder().build();
		final var box1 = Box.builder().build();
		final var box2 = Box.builder().build();

		root.containers().add(container);
		container.boxes().add(box1);
		container.boxes().add(box2);

		box2.activated(false);

		((FeaturedObject<?>) root).loadExtenderManager();
		final var allocator = IAllocationService.INSTANCE.buildAllocator(root,
																		 context,
																		 AllocationObjectAllocation.class);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, box1.currentAllocationCount());
		assertEquals(0, box2.currentAllocationCount());
		assertEquals(1, box1.totalAllocationCount());
		assertEquals(0, box2.totalAllocationCount());

		box2.activated(true);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, box1.currentAllocationCount());
		assertEquals(1, box2.currentAllocationCount());
		assertEquals(1, box1.totalAllocationCount());
		assertEquals(1, box2.totalAllocationCount());

		box1.activated(false);
		box2.activated(false);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(0, box1.currentAllocationCount());
		assertEquals(0, box2.currentAllocationCount());
		assertEquals(1, box1.totalAllocationCount());
		assertEquals(1, box2.totalAllocationCount());
	}
}
