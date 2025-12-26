package org.sheepy.lily.core.allocation.test;

import org.junit.jupiter.api.Test;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.sheepy.lily.core.allocation.test.adapters.*;
import org.sheepy.lily.core.allocation.test.testallocation.Box;
import org.sheepy.lily.core.allocation.test.testallocation.Container;
import org.sheepy.lily.core.allocation.test.testallocation.Leaf;
import org.sheepy.lily.core.allocation.test.testallocation.Node;
import org.sheepy.lily.core.allocation.test.testallocation.Root;
import org.sheepy.lily.core.api.allocation.IAllocationService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class TestLock
{
	@Test
	public void testLockLeaf()
	{
		final var context = new TestContext(0);
		final var root = Root.builder().build();
		final var node = Node.builder().build();
		final var leaf = Leaf.builder().build();
		final var container = Container.builder().build();
		final var box1 = Box.builder().build();
		final var box2 = Box.builder().build();

		root.nodes().add(node);
		root.containers().add(container);
		node.leaves().add(leaf);
		container.boxes().add(box1);
		container.boxes().add(box2);
		leaf.boxes().add(box1);

		((FeaturedObject<?>) root).loadExtenderManager();
		final var allocator = IAllocationService.INSTANCE.buildAllocator(root,
																		 context,
																		 AllocationObjectAllocation.class);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, box1.currentAllocationCount());
		assertEquals(1, box2.currentAllocationCount());

		final var lock1 = leaf.adapt(LeafAllocation.class).newLock();
		final var lock2 = leaf.adapt(LeafAllocation.class).newLock();
		leaf.boxes().clear();
		leaf.boxes().add(box2);

		allocator.updateAllocation();
		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(2, leaf.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, box1.currentAllocationCount());
		assertEquals(1, box2.currentAllocationCount());

		lock1.unlock();
		allocator.updateAllocation();

		lock2.unlock();
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, box1.currentAllocationCount());
		assertEquals(1, box2.currentAllocationCount());
	}

	@Test
	public void testLockContainer()
	{
		final var context = new TestContext(0);
		final var root = Root.builder().build();
		final var node = Node.builder().build();
		final var leaf = Leaf.builder().build();
		final var container = Container.builder().build();
		final var box1 = Box.builder().build();
		final var box2 = Box.builder().build();

		root.nodes().add(node);
		root.containers().add(container);
		node.leaves().add(leaf);
		container.boxes().add(box1);
		leaf.boxes().add(box1);

		((FeaturedObject<?>) root).loadExtenderManager();
		final var allocator = IAllocationService.INSTANCE.buildAllocator(root,
																		 context,
																		 AllocationObjectAllocation.class);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, box1.currentAllocationCount());
		assertEquals(0, box2.currentAllocationCount());

		final var lock1 = container.adapt(ContainerAllocation.class).newLock();
		final var lock2 = container.adapt(ContainerAllocation.class).newLock();
		container.boxes().clear();
		container.boxes().add(box2);
		leaf.boxes().clear();
		leaf.boxes().add(box2);

		allocator.updateAllocation();
		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(2, container.currentAllocationCount());
		assertEquals(1, box1.currentAllocationCount());
		assertEquals(1, box2.currentAllocationCount());

		lock1.unlock();
		allocator.updateAllocation();

		lock2.unlock();
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(0, box1.currentAllocationCount());
		assertEquals(1, box2.currentAllocationCount());
	}

	@Test
	public void testFreeReusableAllocations()
	{
		final var context = new TestContext(0);
		final var root = Root.builder().build();
		final var node = Node.builder().build();

		root.nodes().add(node);

		((FeaturedObject<?>) root).loadExtenderManager();
		final var allocator = IAllocationService.INSTANCE.buildAllocator(root,
																		 context,
																		 AllocationObjectAllocation.class);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, root.totalAllocationCount());
		assertEquals(1, node.totalAllocationCount());

		final var lock1 = node.adapt(NodeAllocation.class).newLock();
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, root.totalAllocationCount());
		assertEquals(1, node.totalAllocationCount());

		node.adapt(NodeAllocation.class).requestUpdate();
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(2, node.currentAllocationCount());
		assertEquals(1, root.totalAllocationCount());
		assertEquals(2, node.totalAllocationCount());

		final var lock2 = node.adapt(NodeAllocation.class).newLock();
		node.adapt(NodeAllocation.class).requestUpdate();
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(3, node.currentAllocationCount());
		assertEquals(1, root.totalAllocationCount());
		assertEquals(3, node.totalAllocationCount());

		lock1.unlock();
		final var lock3 = node.adapt(NodeAllocation.class).newLock();
		node.adapt(NodeAllocation.class).requestUpdate();
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(3, node.currentAllocationCount());
		assertEquals(1, root.totalAllocationCount());
		assertEquals(3, node.totalAllocationCount());

		lock2.unlock();
		lock3.unlock();
		allocator.free();

		assertEquals(0, root.currentAllocationCount());
		assertEquals(0, node.currentAllocationCount());
	}
}
