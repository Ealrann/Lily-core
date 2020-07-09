package org.sheepy.lily.core.allocation.test;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.allocation.test.adapters.AllocationObjectAllocation;
import org.sheepy.lily.core.allocation.test.adapters.BoxAllocation;
import org.sheepy.lily.core.allocation.test.adapters.ContainerAllocation;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationFactory;
import org.sheepy.lily.core.api.allocation.IAllocationService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCompositeChildren
{
	@Test
	public void testComposite()
	{
		final var root = TestallocationFactory.eINSTANCE.createRoot();
		final var container = TestallocationFactory.eINSTANCE.createContainer();
		final var box = TestallocationFactory.eINSTANCE.createBox();

		root.getContainers().add(container);
		container.getBoxes().add(box);

		final var rootAllocation = IAllocationService.INSTANCE.allocate(root, null, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, container.getCurrentAllocationCount());
		assertEquals(1, box.getCurrentAllocationCount());

		container.adapt(ContainerAllocation.class).markObsolete();
		rootAllocation.cleanup(null);
		rootAllocation.update(null);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, container.getCurrentAllocationCount());
		assertEquals(1, box.getCurrentAllocationCount());
		assertEquals(2, container.getTotalAllocationCount());
		assertEquals(2, box.getTotalAllocationCount());

		box.adapt(BoxAllocation.class).markObsolete();
		rootAllocation.cleanup(null);
		rootAllocation.update(null);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, container.getCurrentAllocationCount());
		assertEquals(1, box.getCurrentAllocationCount());
		assertEquals(3, container.getTotalAllocationCount());
		assertEquals(3, box.getTotalAllocationCount());
	}

	@Test
	public void testLockComposite()
	{
		final var root = TestallocationFactory.eINSTANCE.createRoot();
		final var container = TestallocationFactory.eINSTANCE.createContainer();
		final var box = TestallocationFactory.eINSTANCE.createBox();

		root.getContainers().add(container);
		container.getBoxes().add(box);

		final var rootAllocation = IAllocationService.INSTANCE.allocate(root, null, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, container.getCurrentAllocationCount());
		assertEquals(1, box.getCurrentAllocationCount());

		final var containerAllocation = container.adapt(ContainerAllocation.class);
		containerAllocation.markObsolete();
		containerAllocation.lockAllocation();
		rootAllocation.cleanup(null);
		rootAllocation.update(null);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(2, container.getCurrentAllocationCount());
		assertEquals(2, box.getCurrentAllocationCount());
		assertEquals(2, container.getTotalAllocationCount());
		assertEquals(2, box.getTotalAllocationCount());

		containerAllocation.unlockAllocation();
		rootAllocation.cleanup(null);
		rootAllocation.update(null);
		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, container.getCurrentAllocationCount());
		assertEquals(1, box.getCurrentAllocationCount());
		assertEquals(2, container.getTotalAllocationCount());
		assertEquals(2, box.getTotalAllocationCount());
	}

	@Test
	public void testLockParent()
	{
		final var root = TestallocationFactory.eINSTANCE.createRoot();
		final var container = TestallocationFactory.eINSTANCE.createContainer();
		final var box = TestallocationFactory.eINSTANCE.createBox();

		root.getContainers().add(container);
		container.getBoxes().add(box);

		final var rootAllocation = IAllocationService.INSTANCE.allocate(root, null, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, container.getCurrentAllocationCount());
		assertEquals(1, box.getCurrentAllocationCount());

		final var containerAllocation = container.adapt(ContainerAllocation.class);
		final var boxAllocation = box.adapt(BoxAllocation.class);
		boxAllocation.markObsolete();
		containerAllocation.lockAllocation();
		rootAllocation.cleanup(null);
		rootAllocation.update(null);

		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(2, container.getCurrentAllocationCount());
		assertEquals(2, box.getCurrentAllocationCount());
		assertEquals(2, container.getTotalAllocationCount());
		assertEquals(2, box.getTotalAllocationCount());

		containerAllocation.unlockAllocation();
		rootAllocation.cleanup(null);
		rootAllocation.update(null);
		assertEquals(1, root.getCurrentAllocationCount());
		assertEquals(1, container.getCurrentAllocationCount());
		assertEquals(1, box.getCurrentAllocationCount());
		assertEquals(2, container.getTotalAllocationCount());
		assertEquals(2, box.getTotalAllocationCount());
	}
}
