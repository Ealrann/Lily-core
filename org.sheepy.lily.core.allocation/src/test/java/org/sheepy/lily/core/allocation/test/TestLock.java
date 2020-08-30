package org.sheepy.lily.core.allocation.test;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.allocation.test.adapters.*;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationFactory;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.model.LilyEObject;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class TestLock
{
	@Test
	public void testLockLeaf()
	{
		final var context = new TestContext(0);
		final var root = TestallocationFactory.eINSTANCE.createRoot();
		final var node = TestallocationFactory.eINSTANCE.createNode();
		final var leaf = TestallocationFactory.eINSTANCE.createLeaf();
		final var container = TestallocationFactory.eINSTANCE.createContainer();
		final var box1 = TestallocationFactory.eINSTANCE.createBox();
		final var box2 = TestallocationFactory.eINSTANCE.createBox();

		root.getNodes().add(node);
		root.getContainers().add(container);
		node.getLeaves().add(leaf);
		container.getBoxes().add(box1);
		container.getBoxes().add(box2);
		leaf.getBoxes().add(box1);

		((LilyEObject) root).loadExtenderManager();
		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, node.getCurrentAllocationCount());
		assertEquals(1, leaf.getCurrentAllocationCount());
		assertEquals(1, container.getCurrentAllocationCount());
		assertEquals(1, box1.getCurrentAllocationCount());
		assertEquals(1, box2.getCurrentAllocationCount());

		final var lock1 = leaf.adapt(LeafAllocation.class).newLock();
		final var lock2 = leaf.adapt(LeafAllocation.class).newLock();
		leaf.getBoxes().clear();
		leaf.getBoxes().add(box2);

		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);
		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, node.getCurrentAllocationCount());
		assertEquals(2, leaf.getCurrentAllocationCount());
		assertEquals(1, container.getCurrentAllocationCount());
		assertEquals(1, box1.getCurrentAllocationCount());
		assertEquals(1, box2.getCurrentAllocationCount());

		lock1.unlock();
		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);

		lock2.unlock();
		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, node.getCurrentAllocationCount());
		assertEquals(1, leaf.getCurrentAllocationCount());
		assertEquals(1, container.getCurrentAllocationCount());
		assertEquals(1, box1.getCurrentAllocationCount());
		assertEquals(1, box2.getCurrentAllocationCount());
	}

	@Test
	public void testLockContainer()
	{
		final var context = new TestContext(0);
		final var root = TestallocationFactory.eINSTANCE.createRoot();
		final var node = TestallocationFactory.eINSTANCE.createNode();
		final var leaf = TestallocationFactory.eINSTANCE.createLeaf();
		final var container = TestallocationFactory.eINSTANCE.createContainer();
		final var box1 = TestallocationFactory.eINSTANCE.createBox();
		final var box2 = TestallocationFactory.eINSTANCE.createBox();

		root.getNodes().add(node);
		root.getContainers().add(container);
		node.getLeaves().add(leaf);
		container.getBoxes().add(box1);
		leaf.getBoxes().add(box1);

		((LilyEObject) root).loadExtenderManager();
		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, node.getCurrentAllocationCount());
		assertEquals(1, leaf.getCurrentAllocationCount());
		assertEquals(1, container.getCurrentAllocationCount());
		assertEquals(1, box1.getCurrentAllocationCount());
		assertEquals(0, box2.getCurrentAllocationCount());

		final var lock1 = container.adapt(ContainerAllocation.class).newLock();
		final var lock2 = container.adapt(ContainerAllocation.class).newLock();
		container.getBoxes().clear();
		container.getBoxes().add(box2);
		leaf.getBoxes().clear();
		leaf.getBoxes().add(box2);

		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);
		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, node.getCurrentAllocationCount());
		assertEquals(1, leaf.getCurrentAllocationCount());
		assertEquals(2, container.getCurrentAllocationCount());
		assertEquals(1, box1.getCurrentAllocationCount());
		assertEquals(1, box2.getCurrentAllocationCount());

		lock1.unlock();
		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);

		lock2.unlock();
		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, node.getCurrentAllocationCount());
		assertEquals(1, leaf.getCurrentAllocationCount());
		assertEquals(1, container.getCurrentAllocationCount());
		assertEquals(0, box1.getCurrentAllocationCount());
		assertEquals(1, box2.getCurrentAllocationCount());
	}

	@Test
	public void testFreeReusableAllocations()
	{
		final var context = new TestContext(0);
		final var root = TestallocationFactory.eINSTANCE.createRoot();
		final var node = TestallocationFactory.eINSTANCE.createNode();

		root.getNodes().add(node);

		((LilyEObject) root).loadExtenderManager();
		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, node.getCurrentAllocationCount());
		assertEquals(1, root.getTotalAllocationCount());
		assertEquals(1, node.getTotalAllocationCount());

		final var lock1 = node.adapt(NodeAllocation.class).newLock();
		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, node.getCurrentAllocationCount());
		assertEquals(1, root.getTotalAllocationCount());
		assertEquals(1, node.getTotalAllocationCount());

		node.adapt(NodeAllocation.class).requestUpdate();
		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(2, node.getCurrentAllocationCount());
		assertEquals(1, root.getTotalAllocationCount());
		assertEquals(2, node.getTotalAllocationCount());

		final var lock2 = node.adapt(NodeAllocation.class).newLock();
		node.adapt(NodeAllocation.class).requestUpdate();
		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(3, node.getCurrentAllocationCount());
		assertEquals(1, root.getTotalAllocationCount());
		assertEquals(3, node.getTotalAllocationCount());

		lock1.unlock();
		final var lock3 = node.adapt(NodeAllocation.class).newLock();
		node.adapt(NodeAllocation.class).requestUpdate();
		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(3, node.getCurrentAllocationCount());
		assertEquals(1, root.getTotalAllocationCount());
		assertEquals(3, node.getTotalAllocationCount());


		lock2.unlock();
		lock3.unlock();
		IAllocationService.INSTANCE.free(root, context, AllocationObjectAllocation.class);

		assertEquals(0, root.getCurrentAllocationCount());
		assertEquals(0, node.getCurrentAllocationCount());
	}
}
