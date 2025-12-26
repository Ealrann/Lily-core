package org.sheepy.lily.core.allocation.test;

import org.junit.jupiter.api.Test;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.sheepy.lily.core.allocation.test.adapters.AllocationObjectAllocation;
import org.sheepy.lily.core.allocation.test.adapters.BoxAllocation;
import org.sheepy.lily.core.allocation.test.adapters.ContainerAllocation;
import org.sheepy.lily.core.allocation.test.adapters.TestContext;
import org.sheepy.lily.core.allocation.test.testallocation.Box;
import org.sheepy.lily.core.allocation.test.testallocation.Container;
import org.sheepy.lily.core.allocation.test.testallocation.Leaf;
import org.sheepy.lily.core.allocation.test.testallocation.Node;
import org.sheepy.lily.core.allocation.test.testallocation.Root;
import org.sheepy.lily.core.api.allocation.IAllocationService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCompositeChildren
{
	@Test
	public void testComposite()
	{
		final var context = new TestContext(0);
		final var root = Root.builder().build();
		final var container = Container.builder().build();
		final var box = Box.builder().build();

		root.containers().add(container);
		container.boxes().add(box);

		((FeaturedObject<?>) root).loadExtenderManager();
		final var allocator = IAllocationService.INSTANCE.buildAllocator(root,
																		 context,
																		 AllocationObjectAllocation.class);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, box.currentAllocationCount());

		container.adapt(ContainerAllocation.class).markObsolete();
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, box.currentAllocationCount());
		assertEquals(2, container.totalAllocationCount());
		assertEquals(2, box.totalAllocationCount());

		box.adapt(BoxAllocation.class).markObsolete();
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, box.currentAllocationCount());
		assertEquals(2, container.totalAllocationCount());
		assertEquals(3, box.totalAllocationCount());
	}

	@Test
	public void testLockComposite()
	{
		final var context = new TestContext(0);
		final var root = Root.builder().build();
		final var container = Container.builder().build();
		final var box = Box.builder().build();

		root.containers().add(container);
		container.boxes().add(box);

		((FeaturedObject<?>) root).loadExtenderManager();
		final var allocator = IAllocationService.INSTANCE.buildAllocator(root,
																		 context,
																		 AllocationObjectAllocation.class);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, box.currentAllocationCount());

		final var containerAllocation = container.adapt(ContainerAllocation.class);
		containerAllocation.markObsolete();
		containerAllocation.lockAllocation();
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(2, container.currentAllocationCount());
		assertEquals(2, box.currentAllocationCount());
		assertEquals(2, container.totalAllocationCount());
		assertEquals(2, box.totalAllocationCount());

		containerAllocation.unlockAllocation();
		allocator.updateAllocation();
		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, box.currentAllocationCount());
		assertEquals(2, container.totalAllocationCount());
		assertEquals(2, box.totalAllocationCount());
	}

	@Test
	public void testLockParent()
	{
		final var context = new TestContext(0);
		final var root = Root.builder().build();
		final var container = Container.builder().build();
		final var box = Box.builder().build();

		root.containers().add(container);
		container.boxes().add(box);

		((FeaturedObject<?>) root).loadExtenderManager();
		final var allocator = IAllocationService.INSTANCE.buildAllocator(root,
																		 context,
																		 AllocationObjectAllocation.class);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, box.currentAllocationCount());

		final var containerAllocation = container.adapt(ContainerAllocation.class);
		final var boxAllocation = box.adapt(BoxAllocation.class);
		boxAllocation.markObsolete();
		containerAllocation.lockAllocation();
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(2, container.currentAllocationCount());
		assertEquals(2, box.currentAllocationCount());
		assertEquals(2, container.totalAllocationCount());
		assertEquals(2, box.totalAllocationCount());

		containerAllocation.unlockAllocation();
		allocator.updateAllocation();
		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, box.currentAllocationCount());
		assertEquals(2, container.totalAllocationCount());
		assertEquals(2, box.totalAllocationCount());
	}

	@Test
	public void tryLockBranch()
	{
		final var context = new TestContext(0);
		final var root = Root.builder().build();
		final var container = Container.builder().build();
		final var box1 = Box.builder().build();
		final var box2 = Box.builder().build();
		final var node = Node.builder().build();
		final var leaf = Leaf.builder().build();

		root.containers().add(container);
		root.nodes().add(node);
		container.boxes().add(box1);
		container.boxes().add(box2);
		node.leaves().add(leaf);
		leaf.boxes().add(box1);

		((FeaturedObject<?>) root).loadExtenderManager();
		final var allocator = IAllocationService.INSTANCE.buildAllocator(root,
																		 context,
																		 AllocationObjectAllocation.class);
		allocator.updateAllocation();

		container.adapt(ContainerAllocation.class).lockAllocation();
		box2.adapt(BoxAllocation.class).markObsolete();

		allocator.updateAllocation();
	}
}
