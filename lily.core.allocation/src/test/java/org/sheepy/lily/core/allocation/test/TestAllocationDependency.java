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

public class TestAllocationDependency
{
	@Test
	public void testOptionalDependency()
	{
		final var context = new TestContext(0);
		final var root = Root.builder().build();
		final var node = Node.builder().build();
		final var leaf = Leaf.builder().build();
		final var container = Container.builder().build();
		final var box = Box.builder().build();

		root.nodes().add(node);
		root.containers().add(container);
		node.leaves().add(leaf);
		container.boxes().add(box);
		node.container(container);

		((FeaturedObject<?>) root).loadExtenderManager();
		final var allocator = IAllocationService.INSTANCE.buildAllocator(root,
																		 context,
																		 AllocationObjectAllocation.class);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(0, node.dependencyUpdateCount());
		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, box.currentAllocationCount());

		final var containerAllocation = container.adapt(ContainerAllocation.class);
		containerAllocation.lockAllocation();
		containerAllocation.markObsolete();
		allocator.updateAllocation();

		assertEquals(1, node.dependencyUpdateCount());
		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, node.dependencyUpdateCount());
		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(2, container.currentAllocationCount());
		assertEquals(2, container.totalAllocationCount());
		assertEquals(2, box.currentAllocationCount());

		containerAllocation.unlockAllocation();
		allocator.updateAllocation();

		assertEquals(1, node.dependencyUpdateCount());
		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, node.dependencyUpdateCount());
		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(2, container.totalAllocationCount());
		assertEquals(1, box.currentAllocationCount());
		assertEquals(2, box.totalAllocationCount());
	}

	@Test
	public void testMandatoryDependency()
	{
		final var context = new TestContext(0);
		final var root = Root.builder().build();
		final var node = Node.builder().build();
		final var leaf = Leaf.builder().build();
		final var container = Container.builder().build();
		final var box = Box.builder().build();

		root.nodes().add(node);
		root.containers().add(container);
		node.leaves().add(leaf);
		container.boxes().add(box);
		leaf.boxes().add(box);

		((FeaturedObject<?>) root).loadExtenderManager();
		final var allocator = IAllocationService.INSTANCE.buildAllocator(root,
																		 context,
																		 AllocationObjectAllocation.class);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(1, box.currentAllocationCount());
		assertEquals(1, leaf.totalAllocationCount());
		assertEquals(1, box.totalAllocationCount());

		box.adapt(BoxAllocation.class).markObsolete();
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(1, box.currentAllocationCount());
		assertEquals(2, leaf.totalAllocationCount());
		assertEquals(2, box.totalAllocationCount());

		leaf.adapt(LeafAllocation.class).lockAllocation();
		box.adapt(BoxAllocation.class).markObsolete();
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(2, leaf.currentAllocationCount());
		assertEquals(1, box.currentAllocationCount());
		assertEquals(3, leaf.totalAllocationCount());
		assertEquals(3, box.totalAllocationCount());
	}

	@Test
	public void testUpdateCriticalDependency()
	{
		final var context = new TestContext(0);
		final var root = Root.builder().build();
		final var node = Node.builder().build();
		final var leaf = Leaf.builder().build();
		final var container = Container.builder().build();
		final var box = Box.builder().build();

		root.nodes().add(node);
		root.containers().add(container);
		node.leaves().add(leaf);
		container.boxes().add(box);
		leaf.boxes().add(box);

		((FeaturedObject<?>) root).loadExtenderManager();
		final var allocator = IAllocationService.INSTANCE.buildAllocator(root,
																		 context,
																		 AllocationObjectAllocation.class);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(1, box.currentAllocationCount());
		assertEquals(1, leaf.totalAllocationCount());
		assertEquals(1, box.totalAllocationCount());

		allocator.updateAllocation();
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(1, box.currentAllocationCount());
		assertEquals(1, leaf.totalAllocationCount());
		assertEquals(1, box.totalAllocationCount());

		box.adapt(BoxAllocation.class).requestUpdate();
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(1, box.currentAllocationCount());
		assertEquals(1, leaf.totalAllocationCount());
		assertEquals(1, box.totalAllocationCount());

		box.adapt(BoxAllocation.class).requestUpdate();
		final var lock = box.adapt(BoxAllocation.class).newLock();

		allocator.updateAllocation();

		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(2, box.currentAllocationCount());
		assertEquals(2, leaf.totalAllocationCount());
		assertEquals(2, box.totalAllocationCount());

		lock.unlock();

		allocator.updateAllocation();

		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(1, box.currentAllocationCount());
		assertEquals(2, leaf.totalAllocationCount());
		assertEquals(2, box.totalAllocationCount());
	}

	@Test
	public void testTriageDependency()
	{
		final var context = new TestContext(0);
		final var root = Root.builder().build();
		final var node = Node.builder().build();
		final var leaf = Leaf.builder().build();
		final var container = Container.builder().build();
		final var box = Box.builder().build();

		root.nodes().add(node);
		root.containers().add(container);
		node.leaves().add(leaf);
		container.boxes().add(box);
		leaf.boxes().add(box);

		((FeaturedObject<?>) root).loadExtenderManager();
		final var allocator = IAllocationService.INSTANCE.buildAllocator(root,
																		 context,
																		 AllocationObjectAllocation.class);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(1, box.currentAllocationCount());
		assertEquals(1, leaf.totalAllocationCount());
		assertEquals(1, box.totalAllocationCount());

		container.adapt(AllocationObjectAllocation.class).requestUpdate();
		container.adapt(AllocationObjectAllocation.class).lockAllocation();
		allocator.updateAllocation();

		assertEquals(2, container.currentAllocationCount());
		assertEquals(2, box.currentAllocationCount());
		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(2, container.totalAllocationCount());
		assertEquals(2, box.totalAllocationCount());
		assertEquals(2, leaf.totalAllocationCount());
	}

	@Test
	public void testDeactivateDependency()
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
		leaf.boxes().add(box2);

		((FeaturedObject<?>) root).loadExtenderManager();
		final var allocator = IAllocationService.INSTANCE.buildAllocator(root,
																		 context,
																		 AllocationObjectAllocation.class);

		box2.activated(false);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node.currentAllocationCount());
		assertEquals(1, container.currentAllocationCount());
		assertEquals(1, leaf.currentAllocationCount());
		assertEquals(1, leaf.totalAllocationCount());
		assertEquals(1, box1.currentAllocationCount());
		assertEquals(0, box2.currentAllocationCount());
		assertEquals(1, box1.totalAllocationCount());
		assertEquals(0, box2.totalAllocationCount());

		box2.activated(true);
		allocator.updateAllocation();

		assertEquals(1, box1.currentAllocationCount());
		assertEquals(1, box2.currentAllocationCount());
		assertEquals(1, box1.totalAllocationCount());
		assertEquals(1, box2.totalAllocationCount());

		box1.activated(false);
		box2.activated(false);
		allocator.updateAllocation();

		assertEquals(0, box1.currentAllocationCount());
		assertEquals(0, box2.currentAllocationCount());
		assertEquals(1, box1.totalAllocationCount());
		assertEquals(1, box2.totalAllocationCount());
	}

	@Test
	public void testDependencyStructureChange()
	{
		final var context = new TestContext(0);
		final var root = Root.builder().build();
		final var node1 = Node.builder().build();
		final var node2 = Node.builder().build();
		final var node3 = Node.builder().build();
		final var container1 = Container.builder().build();
		final var container2 = Container.builder().build();

		root.nodes().add(node1);
		root.nodes().add(node2);
		root.nodes().add(node3);
		root.containers().add(container1);
		node1.container(container1);
		node2.container(container1);
		node3.container(container1);

		((FeaturedObject<?>) root).loadExtenderManager();
		final var allocator = IAllocationService.INSTANCE.buildAllocator(root,
																		 context,
																		 AllocationObjectAllocation.class);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node1.currentAllocationCount());
		assertEquals(1, node2.currentAllocationCount());
		assertEquals(1, node3.currentAllocationCount());
		assertEquals(0, node1.dependencyUpdateCount());
		assertEquals(0, node2.dependencyUpdateCount());
		assertEquals(0, node3.dependencyUpdateCount());
		assertEquals(1, container1.currentAllocationCount());

		root.containers().remove(container1);
		root.containers().add(container2);
		node1.container(container2);
		node2.container(container2);
		node3.container(container2);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
		assertEquals(1, node1.currentAllocationCount());
		assertEquals(1, node2.currentAllocationCount());
		assertEquals(1, node3.currentAllocationCount());
		assertEquals(1, node1.dependencyUpdateCount());
		assertEquals(1, node2.dependencyUpdateCount());
		assertEquals(1, node3.dependencyUpdateCount());
		assertEquals(1, container2.currentAllocationCount());
	}
}
