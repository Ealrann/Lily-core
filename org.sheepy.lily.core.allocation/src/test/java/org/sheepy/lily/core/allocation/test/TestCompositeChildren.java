package org.sheepy.lily.core.allocation.test;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.allocation.test.adapters.AllocationObjectAllocation;
import org.sheepy.lily.core.allocation.test.adapters.BoxAllocation;
import org.sheepy.lily.core.allocation.test.adapters.ContainerAllocation;
import org.sheepy.lily.core.allocation.test.adapters.TestContext;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationFactory;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.model.LilyEObject;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCompositeChildren
{
	@Test
	public void testComposite()
	{
		final var context = new TestContext(0);
		final var root = TestallocationFactory.eINSTANCE.createRoot();
		final var container = TestallocationFactory.eINSTANCE.createContainer();
		final var box = TestallocationFactory.eINSTANCE.createBox();

		root.getContainers().add(container);
		container.getBoxes().add(box);

		((LilyEObject) root).loadExtenderManager();
		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, container.getCurrentAllocationCount());
		assertEquals(1, box.getCurrentAllocationCount());

		container.adapt(ContainerAllocation.class).markObsolete();
		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, container.getCurrentAllocationCount());
		assertEquals(1, box.getCurrentAllocationCount());
		assertEquals(2, container.getTotalAllocationCount());
		assertEquals(2, box.getTotalAllocationCount());

		box.adapt(BoxAllocation.class).markObsolete();
		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, container.getCurrentAllocationCount());
		assertEquals(1, box.getCurrentAllocationCount());
		assertEquals(2, container.getTotalAllocationCount());
		assertEquals(3, box.getTotalAllocationCount());
	}

	@Test
	public void testLockComposite()
	{
		final var context = new TestContext(0);
		final var root = TestallocationFactory.eINSTANCE.createRoot();
		final var container = TestallocationFactory.eINSTANCE.createContainer();
		final var box = TestallocationFactory.eINSTANCE.createBox();

		root.getContainers().add(container);
		container.getBoxes().add(box);

		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, container.getCurrentAllocationCount());
		assertEquals(1, box.getCurrentAllocationCount());

		final var containerAllocation = container.adapt(ContainerAllocation.class);
		containerAllocation.markObsolete();
		containerAllocation.lockAllocation();
		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(2, container.getCurrentAllocationCount());
		assertEquals(2, box.getCurrentAllocationCount());
		assertEquals(2, container.getTotalAllocationCount());
		assertEquals(2, box.getTotalAllocationCount());

		containerAllocation.unlockAllocation();
		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);
		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, container.getCurrentAllocationCount());
		assertEquals(1, box.getCurrentAllocationCount());
		assertEquals(2, container.getTotalAllocationCount());
		assertEquals(2, box.getTotalAllocationCount());
	}

	@Test
	public void testLockParent()
	{
		final var context = new TestContext(0);
		final var root = TestallocationFactory.eINSTANCE.createRoot();
		final var container = TestallocationFactory.eINSTANCE.createContainer();
		final var box = TestallocationFactory.eINSTANCE.createBox();

		root.getContainers().add(container);
		container.getBoxes().add(box);

		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, container.getCurrentAllocationCount());
		assertEquals(1, box.getCurrentAllocationCount());

		final var containerAllocation = container.adapt(ContainerAllocation.class);
		final var boxAllocation = box.adapt(BoxAllocation.class);
		boxAllocation.markObsolete();
		containerAllocation.lockAllocation();
		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(2, container.getCurrentAllocationCount());
		assertEquals(2, box.getCurrentAllocationCount());
		assertEquals(2, container.getTotalAllocationCount());
		assertEquals(2, box.getTotalAllocationCount());

		containerAllocation.unlockAllocation();
		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);
		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, container.getCurrentAllocationCount());
		assertEquals(1, box.getCurrentAllocationCount());
		assertEquals(2, container.getTotalAllocationCount());
		assertEquals(2, box.getTotalAllocationCount());
	}

	@Test
	public void tryLockBranch()
	{
		final var context = new TestContext(0);
		final var root = TestallocationFactory.eINSTANCE.createRoot();
		final var container = TestallocationFactory.eINSTANCE.createContainer();
		final var box1 = TestallocationFactory.eINSTANCE.createBox();
		final var box2 = TestallocationFactory.eINSTANCE.createBox();
		final var node = TestallocationFactory.eINSTANCE.createNode();
		final var leaf = TestallocationFactory.eINSTANCE.createLeaf();

		root.getContainers().add(container);
		root.getNodes().add(node);
		container.getBoxes().add(box1);
		container.getBoxes().add(box2);
		node.getLeaves().add(leaf);
		leaf.getBoxes().add(box1);

		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);

		container.adapt(ContainerAllocation.class).lockAllocation();
		box2.adapt(BoxAllocation.class).markObsolete();

		IAllocationService.INSTANCE.updateAllocation(root, context, AllocationObjectAllocation.class);
	}
}
