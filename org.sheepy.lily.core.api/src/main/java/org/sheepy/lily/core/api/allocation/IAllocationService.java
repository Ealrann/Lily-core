package org.sheepy.lily.core.api.allocation;

import java.util.ServiceLoader;

public interface IAllocationService
{
	<T extends IAllocationContext> IRootAllocator<T> createAllocator(IAllocable<T> allocable, T context);

	IAllocationService INSTANCE = ServiceLoader.load(IAllocationService.class).findFirst().get();
}
