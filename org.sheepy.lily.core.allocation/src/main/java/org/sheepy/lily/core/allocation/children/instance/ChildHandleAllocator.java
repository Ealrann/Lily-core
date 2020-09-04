package org.sheepy.lily.core.allocation.children.instance;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.allocation.operation.BuildOperation;
import org.sheepy.lily.core.allocation.operation.IOperation;
import org.sheepy.lily.core.allocation.spliterator.CleanupTreeIterator;
import org.sheepy.lily.core.api.allocation.EAllocationStatus;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ChildHandleAllocator<Allocation extends IExtender>
{
	private final AllocationHandle<Allocation> handle;
	private final boolean reuseDirtyAllocations;
	private final Runnable whenUpdateNeeded;

	private final Deque<AllocationInstance<Allocation>> dirtyAllocations = new LinkedList<>();
	private AllocationInstance<Allocation> mainAllocation;

	public ChildHandleAllocator(final AllocationHandle<Allocation> handle, final Runnable whenUpdateNeeded)
	{
		this.handle = handle;
		this.reuseDirtyAllocations = handle.getDescriptor().reuseDirtyAllocations();
		this.whenUpdateNeeded = whenUpdateNeeded;
	}

	public boolean canTriage(final boolean force)
	{
		return mainAllocation != null && (force || mainAllocation.isDirty());
	}

	public void triage(final boolean canReuseAllocations)
	{
		final var oldAllocation = mainAllocation;
		dirtyAllocations.add(oldAllocation);
		mainAllocation = reuseDirtyAllocations && canReuseAllocations ? searchAndRestoreCandidate() : null;
		if (handle.getMainAllocation() == oldAllocation) handle.setMainAllocation(mainAllocation);
	}

	public Stream<IOperation<CleanupTreeIterator>> prepareCleanupOperation(final boolean free)
	{
		final var dirtyNodes = prepareCleanupDirtyOperations(free);
		if (mainAllocation != null && (free || mainAllocation.isDirty()))
		{
			return Stream.concat(dirtyNodes, Stream.of(prepareCleanupMainOperation(free)));
		}
		else
		{
			return dirtyNodes;
		}
	}

	public boolean shouldUpdate()
	{
		return mainAllocation == null || mainAllocation.isDirty();
	}

	public void setupBuildOperation(final BuildOperation operation)
	{
		handle.setupBuildOperation(operation, whenUpdateNeeded, instance -> mainAllocation = instance);
	}

	public boolean isFree()
	{
		return mainAllocation == null && dirtyAllocations.isEmpty();
	}

	private IOperation<CleanupTreeIterator> prepareCleanupMainOperation(final boolean free)
	{
		if (free && mainAllocation.isUnlocked())
		{
			final var prepareFree = handle.prepareFreeOperation(mainAllocation);
			mainAllocation = null;
			return prepareFree;
		}
		else
		{
			return handle.prepareCleanupOperation(mainAllocation);
		}
	}

	private Stream<IOperation<CleanupTreeIterator>> prepareCleanupDirtyOperations(final boolean free)
	{
		final var readyToFree = dirtyAllocations.stream()
												.filter(free ? AllocationInstance::isUnlocked : this::shouldFreeDirty)
												.collect(Collectors.toUnmodifiableList());
		dirtyAllocations.removeAll(readyToFree);
		return readyToFree.stream().map(this::prepareFreeDirtyOperation);
	}

	private IOperation<CleanupTreeIterator> prepareFreeDirtyOperation(final AllocationInstance<Allocation> alloc)
	{
		return handle.prepareFreeOperation(alloc);
	}

	private boolean shouldFreeDirty(final AllocationInstance<?> allocation)
	{
		final var obsolete = allocation.getStatus() == EAllocationStatus.Obsolete;
		final var unlocked = allocation.isUnlocked();

		if (reuseDirtyAllocations)
		{
			return obsolete && unlocked;
		}
		else
		{
			return unlocked;
		}
	}

	public boolean needReallocation()
	{
		final boolean obsolete = mainAllocation.getStatus() == EAllocationStatus.Obsolete;
		final boolean dirtyLocked = mainAllocation.isDirty() && mainAllocation.isLocked();
		return obsolete || dirtyLocked;
	}

	private AllocationInstance<Allocation> searchAndRestoreCandidate()
	{
		final var candidate = dirtyAllocations.stream().filter(AllocationInstance::isUpdatable).findAny();
		if (candidate.isPresent())
		{
			final var restored = candidate.get();
			dirtyAllocations.remove(restored);
			return restored;
		}
		else return null;
	}

	public AllocationInstance<Allocation> getMainAllocation()
	{
		return mainAllocation;
	}

	public ILilyEObject target()
	{
		return handle.getTarget();
	}

	public AllocationHandle<Allocation> handle()
	{
		return handle;
	}
}
