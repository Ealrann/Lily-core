package org.sheepy.lily.core.allocation.internal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.Predicate;

import org.sheepy.lily.core.allocation.AllocationManager;
import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

public final class AllocationConfiguration<T extends IAllocationContext>
{
	public final List<AllocationManager<?>> children = new ArrayList<>();
	public final Deque<AllocationManager<?>> childrenToRemove = new ArrayDeque<>();
	public final List<AllocationState<?>> dependencies = new ArrayList<>();
	public final T context;

	private IAllocationContext childrenContext = null;
	private Predicate<IAllocationContext> allocationCondition;

	public AllocationConfiguration(T context)
	{
		this.context = context;
	}

	public boolean isAllocable()
	{
		if (allocationCondition != null)
		{
			return allocationCondition.test(context);
		}
		else
		{
			return true;
		}
	}

	public boolean areDependenciesAllocated()
	{
		for (int i = 0; i < dependencies.size(); i++)
		{
			final var dep = dependencies.get(i);
			if (dep.isDirty() || dep.getStatus() != EAllocationStatus.Allocated)
			{
				return false;
			}
		}
		return true;
	}

	public void allocateChildren()
	{
		for (int i = 0; i < children.size(); i++)
		{
			final var allocationManager = children.get(i);
			allocationManager.allocate();
		}
	}

	public void freeChildren(boolean dirtyOnly)
	{
		for (int i = children.size() - 1; i >= 0; i--)
		{
			final var allocationManager = children.get(i);
			allocationManager.free(dirtyOnly);
		}
	}

	public IAllocationContext childContext()
	{
		return childrenContext != null ? childrenContext : context;
	}

	public void setChildrenContext(IAllocationContext childrenContext)
	{
		this.childrenContext = childrenContext;
	}

	public void setAllocationCondition(Predicate<IAllocationContext> allocationCondition)
	{
		this.allocationCondition = allocationCondition;
	}

	public void appendInfo(StringBuilder appendTo, int depth)
	{
		if (dependencies.isEmpty() == false)
		{
			appendTo.append("Dependencies: ");
			for (final var dep : dependencies)
			{
				appendTo.append(dep.toString());
			}
		}

		for (final var child : children)
		{
			child.appendInfo(appendTo, depth + 1);
		}
	}
}