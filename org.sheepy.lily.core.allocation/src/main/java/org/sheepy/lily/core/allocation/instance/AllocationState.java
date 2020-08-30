package org.sheepy.lily.core.allocation.instance;

import org.sheepy.lily.core.allocation.util.BitLocker;
import org.sheepy.lily.core.api.allocation.EAllocationStatus;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.notification.util.ConsumerListenerList;

import java.util.function.Consumer;

public final class AllocationState implements IAllocationState
{
	private final Runnable whenUpdateNeeded;
	private final BitLocker bitLocker = new BitLocker();
	private final ConsumerListenerList<EAllocationStatus> listeners = new ConsumerListenerList<>();

	private EAllocationStatus status = EAllocationStatus.Allocated;
	private boolean locked = false;
	private boolean needUpdate = false;

	public AllocationState(final Runnable whenUpdateNeeded)
	{
		this.whenUpdateNeeded = whenUpdateNeeded;
	}

	@Override
	public Lock lockUntil()
	{
		lockAllocation();
		final int lock = bitLocker.newLock();
		return () -> releaseLock(lock);
	}

	private void releaseLock(int lock)
	{
		bitLocker.release(lock);
		if (bitLocker.isLocked() == false)
		{
			unlockAllocation();
		}
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
		if (status == EAllocationStatus.Allocated)
		{
			setStatus(EAllocationStatus.Dirty);
			whenUpdateNeeded.run();
		}
	}

	@Override
	public void requestUpdate()
	{
		if (this.needUpdate == false)
		{
			this.needUpdate = true;
			markDirty();
		}
	}

	public EAllocationStatus getStatus()
	{
		return status;
	}

	public void reset()
	{
		setStatus(EAllocationStatus.Allocated);
	}

	public void setStatus(EAllocationStatus status)
	{
		if (this.status != status)
		{
			this.status = status;
			listeners.notify(status);
		}
	}

	@Override
	public void lockAllocation()
	{
		if (!locked)
		{
			locked = true;
		}
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

	@Override
	public void listenStatus(Consumer<EAllocationStatus> listener)
	{
		listeners.listen(listener);
	}

	@Override
	public void sulkStatus(Consumer<EAllocationStatus> listener)
	{
		listeners.sulk(listener);
	}

	public boolean isDirty()
	{
		return status != EAllocationStatus.Allocated;
	}

	@Override
	public boolean isLocked()
	{
		return locked;
	}

	public boolean needUpdate()
	{
		return needUpdate;
	}

	public void updated()
	{
		needUpdate = false;
	}
}
