package org.sheepy.lily.core.allocation.children.util;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.children.instance.ChildHandleAllocator;
import org.sheepy.lily.core.allocation.operation.IOperationNode;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.util.StreamUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
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

	public Stream<IOperationNode> prepareTriage(final boolean forceTriage)
	{
		return stream().map(a -> a.prepareTriage(forceTriage)).flatMap(Optional::stream);
	}

	public Stream<IOperationNode> prepareCleanup(final boolean free)
	{
		final var removedCleanupStream = removedAllocators.stream().flatMap(e -> e.prepareCleanup(true));
		final IOperationNode cleanRemovedList = c -> removedAllocators.removeIf(ChildHandleAllocator::isFree);
		final var removedStream = Stream.concat(removedCleanupStream, Stream.of(cleanRemovedList));

		final var cleanupStream = reverseStream().flatMap(a -> a.prepareCleanup(free));

		return Stream.concat(removedStream, cleanupStream);
	}

	public Stream<IOperationNode> prepareUpdate()
	{
		return stream().map(ChildHandleAllocator::prepareUpdate).flatMap(Optional::stream);
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

	public Stream<ChildHandleAllocator<?>> reverseStream()
	{
		return StreamUtil.reverseStream(allocators);
	}
}
