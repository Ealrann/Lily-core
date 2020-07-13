package org.sheepy.lily.core.allocation.test;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.allocation.test.adapters.AllocationObjectAllocation;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationFactory;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.model.LilyEObject;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class BasicTest
{
	@Test
	public void testBasic()
	{
		final var root = TestallocationFactory.eINSTANCE.createRoot();

		((LilyEObject)root).loadAdapterManager();
		IAllocationService.INSTANCE.allocate(root, null, AllocationObjectAllocation.class);

		assertEquals(1, root.getCurrentAllocationCount());
	}
}
