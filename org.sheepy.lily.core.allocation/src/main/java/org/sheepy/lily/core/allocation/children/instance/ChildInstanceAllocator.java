package org.sheepy.lily.core.allocation.children.instance;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.allocation.instance.FreeContext;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.extender.IExtender;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public final class ChildInstanceAllocator<Allocation extends IExtender>
{
	private final AllocationHandle<Allocation> handle;
	private final boolean reuseDirtyAllocations;
	private final Runnable whenUpdateNeeded;
	private final Optional<Consumer<EAllocationStatus>> listener;

	private final List<AllocationInstance<Allocation>> dirtyAllocations = new LinkedList<>();
	private AllocationInstance<Allocation> mainAllocation;

	public ChildInstanceAllocator(final AllocationHandle<Allocation> handle,
								  final Runnable whenUpdateNeeded,
								  final Optional<Consumer<EAllocationStatus>> listener)
	{
		this.handle = handle;
		this.reuseDirtyAllocations = handle.getDescriptor().reuseDirtyAllocations();
		this.whenUpdateNeeded = whenUpdateNeeded;
		this.listener = listener;
	}

	public void cleanup(final FreeContext context)
	{
		if (mainAllocation != null)
		{
			if (mainAllocation.isUnlocked())
			{
				if (context.freeEverything() || isMainAllocationObsolete())
				{
					deprecateMainAllocation(context, true);
				}
				else if (mainAllocation.isDirty())
				{
					mainAllocation.cleanup(context);
				}
			}
			else if (mainAllocation.isDirty())
			{
				deprecateMainAllocation(context.encapsulate(false), false);
			}
		}
		freeDeprecatedHandles(context);
	}

	public void update(IAllocationContext context)
	{
		if (mainAllocation != null)
		{
			final boolean unlockObsolete = mainAllocation.isUnlocked() && isMainAllocationObsolete();
			final boolean lockDirty = mainAllocation.isLocked() && mainAllocation.isDirty();
			if (unlockObsolete || lockDirty)
			{
				deprecateMainAllocation(new FreeContext(context, false), false);
			}
		}

		if (mainAllocation == null)
		{
			resolveMainAllocation(context);
		}
		else if (mainAllocation.isDirty())
		{
			mainAllocation.update(context);
		}
	}

	private boolean isMainAllocationObsolete()
	{
		final boolean obsolete = mainAllocation.getStatus() == EAllocationStatus.Obsolete;
		final boolean dirtyLocked = mainAllocation.isDirty() && mainAllocation.isLocked();
		return obsolete || dirtyLocked;
	}

	public void markChildrenObsolete()
	{
		mainAllocation.markObsolete();
	}

	private void resolveMainAllocation(final IAllocationContext context)
	{
		if (reuseDirtyAllocations)
		{
			final var candidate = searchCandidate();
			if (candidate.isPresent())
			{
				mainAllocation = candidate.get();
				mainAllocation.update(context);
				dirtyAllocations.remove(mainAllocation);
				handle.setMainAllocation(mainAllocation);
			}
		}

		if (mainAllocation == null)
		{
			mainAllocation = handle.allocateNew(context, whenUpdateNeeded);
		}
		listener.ifPresent(mainAllocation::listen);
	}

	private Optional<AllocationInstance<Allocation>> searchCandidate()
	{
		return dirtyAllocations.stream().filter(AllocationInstance::isUpdatable).findAny();
	}

	private void deprecateMainAllocation(final FreeContext context, boolean tryFree)
	{
		listener.ifPresent(mainAllocation::sulk);

		final boolean free = tryFree && tryFreeMainAllocation(context);
		if (free == false)
		{
			dirtyAllocations.add(mainAllocation);
		}
		mainAllocation = null;
	}

	private boolean tryFreeMainAllocation(final FreeContext context)
	{
		return reuseDirtyAllocations ? context.freeIfObsoleteUnlocked(mainAllocation) : context.freeIfUnlocked(
				mainAllocation);
	}

	private void freeDeprecatedHandles(final FreeContext context)
	{
		dirtyAllocations.removeIf(reuseDirtyAllocations ? context::freeIfObsoleteUnlocked : context::freeIfUnlocked);
	}
}
