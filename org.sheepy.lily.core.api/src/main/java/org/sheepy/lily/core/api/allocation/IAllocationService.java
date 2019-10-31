package org.sheepy.lily.core.api.allocation;

import java.util.ServiceLoader;

public interface IAllocationService
{
	public <T extends IAllocationContext> IAllocationManager<T> createManager(IAllocable<T> allocable);
//	public <T extends IAllocationContext> IAllocationManager<T> unregister(IAllocable<T> allocable);
//
//	<T extends IAllocationContext> IAllocationManager<T> getManager(IAllocable<T> allocable);

	static final IAllocationService INSTANCE = ServiceLoader.load(IAllocationService.class)
			.findFirst().get();
}
