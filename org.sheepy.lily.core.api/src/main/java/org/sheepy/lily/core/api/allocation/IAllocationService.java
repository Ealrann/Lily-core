package org.sheepy.lily.core.api.allocation;

import java.util.ServiceLoader;

public interface IAllocationService
{
	<T extends IAllocationContext> IAllocationManager<T> createManager(IAllocable<T> allocable);

	IAllocationService INSTANCE = ServiceLoader.load(IAllocationService.class)
											   .findFirst()
											   .get();
}
