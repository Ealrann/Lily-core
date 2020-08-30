package org.sheepy.lily.core.allocation.children.instance;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.allocation.operation.TriageOperation;
import org.sheepy.lily.core.allocation.operation.IOperationNode;
import org.sheepy.lily.core.api.allocation.EAllocationStatus;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.Deque;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ChildHandleAllocator<Allocation extends IExtender>
{
	private final AllocationHandle<Allocation> handle;
	private final boolean reuseDirtyAllocations;
	private final Runnable whenUpdateNeeded;

	private final Deque<AllocationInstance<Allocation>> dirtyAllocations = new ConcurrentLinkedDeque<>();
	private AllocationInstance<Allocation> mainAllocation;

	public ChildHandleAllocator(final AllocationHandle<Allocation> handle, final Runnable whenUpdateNeeded)
	{
		this.handle = handle;
		this.reuseDirtyAllocations = handle.getDescriptor().reuseDirtyAllocations();
		this.whenUpdateNeeded = whenUpdateNeeded;
	}

	public Optional<IOperationNode> prepareTriage(final boolean forceTriage)
	{
		if (mainAllocation != null)
		{
			final BooleanSupplier triageOperation = () -> {
				final var oldAllocation = mainAllocation;
				final AllocationInstance<Allocation> newAllocation;
				if (needReallocation() || forceTriage)
				{
					newAllocation = reuseDirtyAllocations && !forceTriage ? searchCandidate().orElse(null) : null;
				}
				else
				{
					newAllocation = mainAllocation;
				}

				if (oldAllocation != newAllocation)
				{
					if (oldAllocation != null)
					{
						dirtyAllocations.add(oldAllocation);
					}
					if (newAllocation != null)
					{
						dirtyAllocations.remove(newAllocation);
					}

					mainAllocation = newAllocation;
					if (handle.getMainAllocation() == oldAllocation) handle.setMainAllocation(newAllocation);

					return true;
				}
				else
				{
					return false;
				}
			};

			return Optional.of(new TriageOperation(mainAllocation, triageOperation, needReallocation() || forceTriage));
		}
		else
		{
			return Optional.empty();
		}
	}

	public Stream<IOperationNode> prepareCleanup(final boolean free)
	{
		final var dirtyNodes = prepareCleanupDirty(free);

		if (mainAllocation != null && (free || mainAllocation.isDirty()))
		{
			return Stream.concat(dirtyNodes, Stream.of(prepareCleanupMain(free)));
		}
		else
		{
			return dirtyNodes;
		}
	}

	public Optional<IOperationNode> prepareUpdate()
	{
		if (mainAllocation == null)
		{
			final var instanceBuilder = handle.newNodeBuilder(whenUpdateNeeded, instance -> mainAllocation = instance);
			return Optional.of(instanceBuilder);
		}
		else if (mainAllocation.isDirty())
		{
			return Optional.of(handle.prepareUpdate(mainAllocation));
		}
		else
		{
			return Optional.empty();
		}
	}

	public boolean isFree()
	{
		return mainAllocation == null && dirtyAllocations.isEmpty();
	}

	private IOperationNode prepareCleanupMain(final boolean free)
	{
		if (free && mainAllocation.isUnlocked())
		{
			final var prepareFree = handle.prepareFree(mainAllocation);
			mainAllocation = null;
			return prepareFree;
		}
		else
		{
			return mainAllocation.prepareCleanup();
		}
	}

	private Stream<IOperationNode> prepareCleanupDirty(final boolean free)
	{
		final var readyToFree = dirtyAllocations.stream()
												.filter(alloc -> shouldFreeDirty(alloc, free))
												.collect(Collectors.toUnmodifiableList());
		dirtyAllocations.removeAll(readyToFree);
		return readyToFree.stream().map(this::prepareFreeDirty);
	}

	private IOperationNode prepareFreeDirty(final AllocationInstance<Allocation> alloc)
	{
		return handle.prepareFree(alloc);
	}

	private boolean shouldFreeDirty(final AllocationInstance<?> allocation, final boolean free)
	{
		final var obsolete = allocation.getStatus() == EAllocationStatus.Obsolete;
		final var unlocked = allocation.isUnlocked();

		if (reuseDirtyAllocations)
		{
			return (free || obsolete) && unlocked;
		}
		else
		{
			return unlocked;
		}
	}

	private boolean needReallocation()
	{
		final boolean obsolete = mainAllocation.getStatus() == EAllocationStatus.Obsolete;
		final boolean dirtyLocked = mainAllocation.isDirty() && mainAllocation.isLocked();
		return obsolete || dirtyLocked;
	}

	private Optional<AllocationInstance<Allocation>> searchCandidate()
	{
		return dirtyAllocations.stream().filter(AllocationInstance::isUpdatable).findAny();
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
