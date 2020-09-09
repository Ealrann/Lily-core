package org.sheepy.lily.core.allocation.children.instance;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.allocation.operation.BuildOperation;
import org.sheepy.lily.core.api.allocation.EAllocationStatus;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.LinkedList;
import java.util.List;

public final class ChildHandleAllocator<Allocation extends IExtender>
{
	private final AllocationHandle<Allocation> handle;
	private final boolean reuseDirtyAllocations;
	private final Runnable whenUpdateNeeded;

	private final List<AllocationInstance<Allocation>> dirtyAllocations = new LinkedList<>();
	private AllocationInstance<Allocation> mainAllocation;

	public ChildHandleAllocator(final AllocationHandle<Allocation> handle, final Runnable whenUpdateNeeded)
	{
		this.handle = handle;
		this.whenUpdateNeeded = whenUpdateNeeded;
		this.reuseDirtyAllocations = handle.getDescriptor().reuseDirtyAllocations();
		handle.listenActivation(whenUpdateNeeded);
	}

	public void free()
	{
		handle.sulkActivation(whenUpdateNeeded);
	}

	public boolean canTriage(final boolean force)
	{
		return mainAllocation != null && (force || mainAllocation.isDirty());
	}

	public void triage(final boolean forcedTriage)
	{
		final boolean canReuseAllocations = !forcedTriage && handle.isActivated();
		final var oldAllocation = mainAllocation;
		dirtyAllocations.add(oldAllocation);
		mainAllocation = reuseDirtyAllocations && canReuseAllocations ? searchAndRestoreCandidate() : null;
		if (handle.getMainAllocation() == oldAllocation) handle.setMainAllocation(mainAllocation);
	}

	public boolean shouldUpdate()
	{
		return (mainAllocation == null || mainAllocation.isDirty()) &&  handle.isActivated();
	}

	public void setupBuildOperation(final BuildOperation operation)
	{
		handle.setupBuildOperation(operation, whenUpdateNeeded, instance -> mainAllocation = instance);
	}

	public boolean shouldFreeDirty(final AllocationInstance<?> allocation)
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

	public boolean isFree()
	{
		return mainAllocation == null && dirtyAllocations.isEmpty();
	}

	public boolean needTriage()
	{
		final boolean obsolete = mainAllocation.getStatus() == EAllocationStatus.Obsolete;
		final boolean dirtyLocked = mainAllocation.isDirty() && mainAllocation.isLocked();
		final boolean deactivated = handle.isActivated() == false;
		return obsolete || dirtyLocked || deactivated;
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

	public List<AllocationInstance<Allocation>> getDirtyAllocations()
	{
		return dirtyAllocations;
	}

	public ILilyEObject target()
	{
		return handle.getTarget();
	}

	public AllocationHandle<Allocation> handle()
	{
		return handle;
	}

	public void setMainAllocation(final AllocationInstance<Allocation> newAllocation)
	{
		mainAllocation = newAllocation;
	}
}
