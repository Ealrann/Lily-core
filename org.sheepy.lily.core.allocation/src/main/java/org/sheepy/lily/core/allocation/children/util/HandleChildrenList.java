package org.sheepy.lily.core.allocation.children.util;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.children.instance.ChildHandleAllocator;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public final class HandleChildrenList
{
	private final Runnable whenBranchDirty;
	private final List<ChildHandleAllocator<?>> allocators = new LinkedList<>();
	private final List<ChildHandleAllocator<?>> removedAllocators = new LinkedList<>();

	public HandleChildrenList(final Runnable whenBranchDirty)
	{
		this.whenBranchDirty = whenBranchDirty;
	}

	public void removeChildren(final List<ILilyEObject> removedChildren)
	{
		for (final var removedChild : removedChildren)
		{
			resolveAndRemove(removedChild);
		}
	}

	public void reload(final Stream<? extends AllocationHandle<?>> childrenHandles)
	{
		final var handleIterator = childrenHandles.iterator();
		final var listIterator = allocators.listIterator();
		while (handleIterator.hasNext())
		{
			final var currentHandle = handleIterator.next();
			if (listIterator.hasNext())
			{
				final var currentChildAllocator = listIterator.next();
				if (currentChildAllocator.handle() != currentHandle)
				{
					listIterator.set(buildAllocationContainer(currentHandle));
					listIterator.add(currentChildAllocator);
				}
			}
			else
			{
				listIterator.add(buildAllocationContainer(currentHandle));
			}
		}
	}

	private ChildHandleAllocator<?> buildAllocationContainer(final AllocationHandle<?> handle)
	{
		return new ChildHandleAllocator<>(handle, whenBranchDirty);
	}

	public void postCleanup()
	{
		removedAllocators.removeIf(ChildHandleAllocator::isFree);
	}

	public void resolveAndRemove(final ILilyEObject target)
	{
		final var it = allocators.iterator();
		while (it.hasNext())
		{
			final var child = it.next();
			if (child.target() == target)
			{
				removedAllocators.add(child);
				it.remove();
			}
		}
	}

	public Stream<ChildHandleAllocator<?>> stream()
	{
		return allocators.stream();
	}

	public List<ChildHandleAllocator<?>> getHandleAllocators()
	{
		return allocators;
	}

	public List<ChildHandleAllocator<?>> getRemovedHandleAllocators()
	{
		return removedAllocators;
	}
}
