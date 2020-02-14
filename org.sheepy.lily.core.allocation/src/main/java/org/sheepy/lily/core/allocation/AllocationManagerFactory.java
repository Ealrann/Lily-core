package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.allocation.internal.AllocationState;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

@SuppressWarnings("unchecked")
final class AllocationManagerFactory<R extends IAllocationContext>
{
	public final List<AllocationManager<R>> roots = new ArrayList<>();

	private final List<AllocationState<?>> orphanStates = new ArrayList<>();

	public AllocationManager<R> newRoot(IAllocable<R> root)
	{
		final var res = create(null, root);
		roots.add(res);
		return res;
	}

	AllocationState<?> getOrCreateState(IAllocable<?> allocable)
	{
		final var res = searchOrphanState(allocable, false);
		if (res != null)
		{
			return res;
		}

		final var manager = search(allocable);
		if (manager != null)
		{
			return manager.state;
		}

		return newOrphanState(allocable);
	}

	private AllocationState<?> newOrphanState(final IAllocable<?> allocable)
	{
		final var newState = new AllocationState<>(allocable);
		orphanStates.add(newState);
		return newState;
	}

	<T extends IAllocationContext> AllocationManager<T> create(AllocationManager<?> parent, IAllocable<T> allocable)
	{
		final var state = searchOrphanState(allocable, true);
		final var parentState = parent != null ? parent.state : null;
		if (state != null)
		{
			state.setParent(parentState);
			return AllocationManager.newManager(this, parent, state);
		}
		else
		{
			final var newState = new AllocationState<>(allocable);
			newState.setParent(parentState);
			return AllocationManager.newManager(this, parent, newState);
		}
	}

	<T extends IAllocationContext> AllocationManager<T> createContext(AllocationManager<T> parent,
																	  IAllocable<T> allocable)
	{
		final var parentState = parent != null ? parent.state : null;
		final var newState = new AllocationState<>(allocable);
		newState.setParent(parentState);
		return AllocationManager.newContextManager(this, newState);
	}

	private AllocationManager<?> search(IAllocable<?> allocable)
	{
		final Deque<AllocationManager<?>> course = new ArrayDeque<>(roots);
		while (course.isEmpty() == false)
		{
			final var current = course.pop();
			if (current.state.allocable == allocable)
			{
				return current;
			}
			else
			{
				course.addAll(current.getChildren());
			}
		}
		return null;
	}

	private <T extends IAllocationContext> AllocationState<T> searchOrphanState(IAllocable<T> allocable, boolean remove)
	{
		final var it = orphanStates.iterator();
		while (it.hasNext())
		{
			final var state = it.next();
			if (state.allocable == allocable)
			{
				if (remove) it.remove();
				return (AllocationState<T>) state;
			}
		}
		return null;
	}
}
