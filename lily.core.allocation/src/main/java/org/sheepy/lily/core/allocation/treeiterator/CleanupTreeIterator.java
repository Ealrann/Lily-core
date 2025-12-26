package org.sheepy.lily.core.allocation.treeiterator;

import org.sheepy.lily.core.allocation.children.instance.ChildDescriptorAllocator;
import org.sheepy.lily.core.allocation.children.instance.ChildHandleAllocator;
import org.sheepy.lily.core.allocation.children.instance.ChildrenSupervisor;
import org.sheepy.lily.core.allocation.children.manager.AllocationChildrenManager;
import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.allocation.operation.CleanupOperation;
import org.sheepy.lily.core.allocation.operation.FreeOperation;
import org.sheepy.lily.core.allocation.operation.IOperation;

import java.util.Optional;

public final class CleanupTreeIterator extends AllocationTreeIterator<CleanupTreeIterator>
{
	private final CleanupOperation cleanupOperation = new CleanupOperation();
	private final FreeOperation freeOperation = new FreeOperation();

	private boolean free;
	private boolean currentIsMain;
	private int allocationIndex;
	private AllocationInstance<?> currentAllocation;
	private ChildHandleAllocator<?> currentHandleAllocator;

	public CleanupTreeIterator()
	{
		super(true, true);
	}

	public void load(final AllocationChildrenManager childrenManager, final boolean free)
	{
		super.load(childrenManager);
		this.free = free;
		currentAllocation = null;
		currentHandleAllocator = null;
	}

	@Override
	public Optional<IOperation<CleanupTreeIterator>> tryAdvance()
	{
		if (tryAdvanceAllocation())
		{
			if (!currentIsMain || free || isIteratingRemovedElements())
			{
				if (currentIsMain)
				{
					currentHandleAllocator.setMainAllocation(null);
				}
				else
				{
					currentHandleAllocator.getDirtyAllocations().remove(currentAllocation);
					allocationIndex--;
				}
				freeOperation.setup(currentHandleAllocator.target(), currentAllocation);
				return Optional.of(freeOperation);
			}
			else
			{
				cleanupOperation.setup(currentAllocation);
				return Optional.of(cleanupOperation);
			}
		}
		else
		{
			return Optional.empty();
		}
	}

	private boolean tryAdvanceAllocation()
	{
		do
		{
			while (currentHandleAllocator == null || allocationIndex >= allocationsCount())
			{
				currentHandleAllocator = tryAdvanceHandleAllocator();
				if (currentHandleAllocator == null) return false;
				else allocationIndex = 0;
			}

			final var dirtyAllocations = currentHandleAllocator.getDirtyAllocations();
			if (allocationIndex < dirtyAllocations.size())
			{
				currentIsMain = false;
				currentAllocation = dirtyAllocations.get(allocationIndex);
			}
			else
			{
				currentIsMain = true;
				currentAllocation = currentHandleAllocator.getMainAllocation();
			}
			allocationIndex++;

		} while (!shouldCleanupCurrent());

		return true;
	}

	private boolean shouldCleanupCurrent()
	{
		if (currentIsMain)
		{
			return (free || isIteratingRemovedElements() || currentAllocation.isDirty()) && currentAllocation.isUnlocked();
		}
		else
		{
			return (free || isIteratingRemovedElements()) ? currentAllocation.isUnlocked() : currentHandleAllocator.shouldFreeDirty(
					currentAllocation);
		}
	}

	private int allocationsCount()
	{
		final var mainAllocation = currentHandleAllocator.getMainAllocation();
		return currentHandleAllocator.getDirtyAllocations().size() + (mainAllocation != null ? 1 : 0);
	}

	@Override
	protected void updateSupervisor(final ChildrenSupervisor supervisor)
	{
	}

	@Override
	protected void postUpdateSupervisor(final ChildrenSupervisor supervisor)
	{
	}

	@Override
	protected void postUpdateDescriptorAllocator(final ChildDescriptorAllocator descriptorAllocator)
	{
		descriptorAllocator.postCleanup();
	}

	@Override
	protected boolean operatesOnHandleAllocator(final ChildHandleAllocator<?> currentHandleAllocator)
	{
		return true;
	}
}
