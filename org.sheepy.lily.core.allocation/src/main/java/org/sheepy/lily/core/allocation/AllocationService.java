package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.allocation.IRootAllocator;

public final class AllocationService implements IAllocationService
{
	@Override
	public <T extends IAllocationContext> RootAllocator<T> createAllocator(IAllocable<T> allocable, T context)
	{
		return new RootAllocator<>(allocable, context);
	}

	@Override
	public <T extends IAllocationContext> IRootAllocator<T> createAllocator(final IRootAllocator<T> parentAllocator,
																			final IAllocable<T> allocable,
																			final T context)
	{
		return new RootAllocator<>((RootAllocator<T>) parentAllocator, allocable, context);
	}
}
