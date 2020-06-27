package org.sheepy.lily.core.allocation.children;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.extender.IExtender;

import java.util.ArrayDeque;
import java.util.Deque;

public final class ChildContainer<Allocation extends IExtender>
{
	private final AllocationHandle<Allocation> handle;
	private final Runnable whenUpdateNeeded;

	private final Deque<AllocationInstance<Allocation>> dirtyAllocations = new ArrayDeque<>(1);
	private AllocationInstance<Allocation> mainAllocation;

	public ChildContainer(final AllocationHandle<Allocation> handle, Runnable whenUpdateNeeded)
	{
		this.handle = handle;
		this.whenUpdateNeeded = whenUpdateNeeded;
	}

	public void cleanup(final IAllocationContext context, boolean freeEverything)
	{
		if (mainAllocation != null)
		{
			final boolean obsolete = mainAllocation.getStatus() == EAllocationStatus.Obsolete;
			final boolean dirtyLocked = mainAllocation.getStatus() == EAllocationStatus.Dirty && mainAllocation.isLocked();

			if (freeEverything || obsolete || dirtyLocked)
			{
				deprecateMainHandle();
			}
			else if (mainAllocation.isDirty())
			{
				mainAllocation.cleanup(context, false);
			}
		}
		freeDeprecatedHandles(context);
	}

	public void update(IAllocationContext context)
	{
		if (mainAllocation == null)
		{
			final var candidate = dirtyAllocations.stream().filter(AllocationInstance::isUpdatable).findAny();

			if (candidate.isPresent())
			{
				mainAllocation = candidate.get();
				mainAllocation.update(context);
				handle.setMainAllocation(mainAllocation);
			}
			else
			{
				mainAllocation = handle.allocateNew(context, whenUpdateNeeded);
			}
		}
		else if (mainAllocation.isDirty())
		{
			mainAllocation.update(context);
		}
	}

	private void deprecateMainHandle()
	{
		dirtyAllocations.add(mainAllocation);
		mainAllocation = null;
	}

	private void freeDeprecatedHandles(IAllocationContext context)
	{
		final var it = dirtyAllocations.iterator();
		while (it.hasNext())
		{
			final var allocation = it.next();
			if (allocation.getStatus() == EAllocationStatus.Obsolete && allocation.isUnlocked())
			{
				allocation.free(context);
				it.remove();
			}
		}
	}
}
