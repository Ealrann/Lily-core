package org.sheepy.lily.core.allocation.test;

import org.junit.jupiter.api.Test;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.sheepy.lily.core.allocation.test.adapters.AllocationObjectAllocation;
import org.sheepy.lily.core.allocation.test.adapters.TestContext;
import org.sheepy.lily.core.allocation.test.testallocation.Root;
import org.sheepy.lily.core.api.allocation.IAllocationService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class BasicTest
{
	@Test
	public void testBasic()
	{
		final var context = new TestContext(0);
		final var root = Root.builder().build();

		((FeaturedObject<?>) root).loadExtenderManager();

		final var allocator = IAllocationService.INSTANCE.buildAllocator(root,
																		 context,
																		 AllocationObjectAllocation.class);
		allocator.updateAllocation();

		assertEquals(1, root.currentAllocationCount());
	}
}
