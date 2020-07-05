package org.sheepy.lily.core.allocation.children;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.allocation.instance.FreeContext;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.extender.IExtender;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public final class ChildContainer<Allocation extends IExtender>
{
	private final AllocationHandle<Allocation> handle;
	private final Runnable whenUpdateNeeded;
	private final Optional<Consumer<EAllocationStatus>> listener;

	private final List<AllocationInstance<Allocation>> dirtyAllocations = new ArrayList<>(1);
	private AllocationInstance<Allocation> mainAllocation;

	public ChildContainer(final AllocationHandle<Allocation> handle,
						  final Runnable whenUpdateNeeded,
						  final Optional<Consumer<EAllocationStatus>> listener)
	{
		this.handle = handle;
		this.whenUpdateNeeded = whenUpdateNeeded;
		this.listener = listener;
	}

	public void cleanup(final FreeContext context)
	{
		if (mainAllocation != null)
		{
			final var status = mainAllocation.getStatus();
			final boolean obsolete = status == EAllocationStatus.Obsolete;
			final boolean dirtyLocked = mainAllocation.isDirty() && mainAllocation.isLocked();

			if (context.freeEverything() || obsolete || dirtyLocked)
			{
				deprecateMainAllocation(context);
			}
			else if (mainAllocation.isDirty())
			{
				mainAllocation.cleanup(context);
			}
		}
		freeDeprecatedHandles(context);
	}

	public void update(IAllocationContext context)
	{
		if (mainAllocation == null)
		{
			resolveMainAllocation(context);
		}
		else if (mainAllocation.isDirty())
		{
			mainAllocation.update(context);
		}
	}

	private void resolveMainAllocation(final IAllocationContext context)
	{
		final var candidate = dirtyAllocations.stream().filter(AllocationInstance::isUpdatable).findAny();
		if (candidate.isPresent())
		{
			mainAllocation = candidate.get();
			mainAllocation.update(context);
			dirtyAllocations.remove(mainAllocation);
			handle.setMainAllocation(mainAllocation);
		}
		else
		{
			mainAllocation = handle.allocateNew(context, whenUpdateNeeded);
		}
		listener.ifPresent(mainAllocation::listen);
	}

	private void deprecateMainAllocation(final FreeContext context)
	{
		listener.ifPresent(mainAllocation::sulk);
		if (context.freeIfObsoleteUnlocked(mainAllocation) == false)
		{
			dirtyAllocations.add(mainAllocation);
		}
		mainAllocation = null;
	}

	private void freeDeprecatedHandles(final FreeContext context)
	{
		dirtyAllocations.removeIf(context::freeIfObsoleteUnlocked);
	}
}
