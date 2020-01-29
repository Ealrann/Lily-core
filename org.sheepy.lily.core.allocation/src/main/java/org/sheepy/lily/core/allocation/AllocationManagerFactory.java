package org.sheepy.lily.core.allocation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

@SuppressWarnings("unchecked")
final class AllocationManagerFactory<R extends IAllocationContext>
{
	public final AllocationManager<R> root;

	private final List<AllocationManager<?>> virtualManagers = new ArrayList<>();

	AllocationManagerFactory(IAllocable<R> root)
	{
		this.root = create(null, root);
	}

	<T extends IAllocationContext> AllocationManager<?> getOrCreateVirtual(IAllocable<T> allocable)
	{
		var manager = searchVirtual(allocable);

		if (manager == null)
		{
			manager = (AllocationManager<T>) searchManager(allocable);
		}

		if (manager == null)
		{
			manager = AllocationManager.newVirtualManager(this, allocable);
			virtualManagers.add(manager);
		}

		return manager;
	}

	private AllocationManager<?> searchManager(IAllocable<?> allocable)
	{
		final Deque<AllocationManager<?>> course = new ArrayDeque<>();
		AllocationManager<?> res = null;

		course.add(root);
		while (course.isEmpty() == false)
		{
			final var current = course.pop();
			if (current.allocable == allocable)
			{
				res = current;
				break;
			}
			else
			{
				course.addAll(current.getChildren());
			}
		}

		return res;
	}

	<T extends IAllocationContext> AllocationManager<T> create(	AllocationManager<?> parent,
																IAllocable<T> allocable)
	{
		var manager = searchVirtual(allocable);

		if (manager == null)
		{
			manager = AllocationManager.newManager(this, parent, allocable);
		}
		else if (manager.isVirtual())
		{
			manager.setParent(parent, false);
			virtualManagers.remove(manager);
		}

		return manager;
	}

	<T extends IAllocationContext> AllocationManager<T> createContext(	AllocationManager<T> parent,
																		IAllocable<T> allocable)
	{
		return AllocationManager.newContextManager(this, parent, allocable);
	}

	private <T extends IAllocationContext> AllocationManager<T> searchVirtual(IAllocable<T> allocable)
	{
		for (final var virtual : virtualManagers)
		{
			if (virtual.allocable == allocable)
			{
				return (AllocationManager<T>) virtual;
			}
		}
		return null;
	}
}
