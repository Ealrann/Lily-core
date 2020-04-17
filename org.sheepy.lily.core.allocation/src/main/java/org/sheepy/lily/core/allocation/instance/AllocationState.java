package org.sheepy.lily.core.allocation.instance;

import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.api.allocation.IAllocationState;

import java.util.function.BiConsumer;

public class AllocationState implements IAllocationState
{
	private final Runnable whenUpdateNeeded;
	private final BiConsumer<EAllocationStatus, EAllocationStatus> onStatusChange;

	private EAllocationStatus status = EAllocationStatus.Allocated;
	private EAllocationStatus branchStatus = EAllocationStatus.Allocated;
	private boolean locked = false;

	public AllocationState(final BiConsumer<EAllocationStatus, EAllocationStatus> onStatusChange,
						   final Runnable whenUpdateNeeded)
	{
		this.onStatusChange = onStatusChange;
		this.whenUpdateNeeded = whenUpdateNeeded;
	}

	@Override
	public void setAllocationObsolete()
	{
		markObsolete();
	}

	public void markObsolete()
	{
		if (status != EAllocationStatus.Obsolete)
		{
			setStatus(EAllocationStatus.Obsolete);
			whenUpdateNeeded.run();
		}
	}

	public void markDirty()
	{
		if (status == EAllocationStatus.Allocated)
		{
			setStatus(EAllocationStatus.Dirty);
			whenUpdateNeeded.run();
		}
	}

	public void markBranchDirty()
	{
		if (branchStatus == EAllocationStatus.Allocated)
		{
			branchStatus = EAllocationStatus.Dirty;
			whenUpdateNeeded.run();
		}
	}

	public EAllocationStatus getStatus()
	{
		return status;
	}

	public void setStatus(EAllocationStatus status)
	{
		if (this.status != status)
		{
			final var oldStatus = this.status;
			this.status = status;
			onStatusChange.accept(oldStatus, status);
		}
	}

	public void setBranchStatus(final EAllocationStatus newBranchStatus)
	{
		this.branchStatus = newBranchStatus;
	}

	@Override
	public void lockAllocation()
	{
		locked = true;
	}

	@Override
	public void unlockAllocation()
	{
		if (locked)
		{
			locked = false;
			if (isDirty())
			{
				whenUpdateNeeded.run();
			}
		}
	}

	public boolean isDirty()
	{
		return status != EAllocationStatus.Allocated || branchStatus != EAllocationStatus.Allocated;
	}

	@Override
	public boolean isLocked()
	{
		return locked;
	}
}
