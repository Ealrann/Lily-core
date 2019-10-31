package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationManager;
import org.sheepy.lily.core.api.allocation.IAllocationService;

public final class AllocationService implements IAllocationService
{
	@Override
	public <T extends IAllocationContext> IAllocationManager<T> createManager(IAllocable<T> allocable)
	{
		final var factory = new AllocationManagerFactory<>(allocable);
		return factory.root;
	}
}
