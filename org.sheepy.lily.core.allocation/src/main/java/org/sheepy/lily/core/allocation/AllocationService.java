package org.sheepy.lily.core.allocation;

import java.util.HashMap;
import java.util.Map;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationManager;
import org.sheepy.lily.core.api.allocation.IAllocationService;

public final class AllocationService implements IAllocationService
{
	private final Map<IAllocable<?>, AllocationManager<?>> managers = new HashMap<>();

	@Override
	@SuppressWarnings("unchecked")
	public <T extends IAllocationContext> AllocationManager<T> getManager(IAllocable<T> allocable)
	{
		return (AllocationManager<T>) managers.get(allocable);
	}

	public <T extends IAllocationContext> AllocationManager<?> getOrCreateVirtual(IAllocable<T> allocable)
	{
		@SuppressWarnings("unchecked")
		var manager = (AllocationManager<T>) managers.get(allocable);

		if (manager == null)
		{
			manager = AllocationManager.newVirtualManager(allocable);
			managers.put(allocable, manager);
		}

		return manager;
	}

	public <T extends IAllocationContext> AllocationManager<T> getOrCreate(	AllocationManager<?> parent,
																			IAllocable<T> allocable)
	{
		@SuppressWarnings("unchecked")
		var manager = (AllocationManager<T>) managers.get(allocable);

		if (manager == null)
		{
			manager = AllocationManager.newManager(parent, allocable);
			managers.put(allocable, manager);
		}
		else if (manager.isVirtual())
		{
			manager.setParent(parent, false);
		}

		return manager;
	}

	public <T extends IAllocationContext> AllocationManager<T> getOrCreateContext(	AllocationManager<T> parent,
																					IAllocable<T> allocable)
	{
		@SuppressWarnings("unchecked")
		var manager = (AllocationManager<T>) managers.get(allocable);

		if (manager == null)
		{
			manager = AllocationManager.newContextManager(parent, allocable);
			managers.put(allocable, manager);
		}

		return manager;
	}

	@Override
	public <T extends IAllocationContext> IAllocationManager<T> register(IAllocable<T> allocable)
	{
		final AllocationManager<T> manager = AllocationManager.newManager(null, allocable);
		managers.put(allocable, manager);
		return manager;
	}

	@Override
	public <T extends IAllocationContext> IAllocationManager<T> unregister(IAllocable<T> allocable)
	{
		final var manager = getManager(allocable);
		manager.free(false);
		managers.remove(allocable);
		return manager;
	}
}
