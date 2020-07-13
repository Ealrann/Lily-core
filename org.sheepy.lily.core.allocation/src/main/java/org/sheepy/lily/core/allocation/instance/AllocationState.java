package org.sheepy.lily.core.allocation.instance;

import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.api.allocation.IAllocationState;

import java.math.BigInteger;
import java.util.function.BiConsumer;

public class AllocationState implements IAllocationState
{
	private final Runnable whenUpdateNeeded;
	private final BiConsumer<EAllocationStatus, EAllocationStatus> onStatusChange;
	private final BitLocker bitLocker = new BitLocker();

	private EAllocationStatus status = EAllocationStatus.Allocated;
	private EAllocationStatus branchStatus = EAllocationStatus.Allocated;
	private boolean locked = false;
	private boolean needUpdate = false;

	public AllocationState(final BiConsumer<EAllocationStatus, EAllocationStatus> onStatusChange,
						   final Runnable whenUpdateNeeded)
	{
		this.onStatusChange = onStatusChange;
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
		if (branchStatus == EAllocationStatus.Allocated)
		{
			branchStatus = EAllocationStatus.Dirty;
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
		this.branchStatus = EAllocationStatus.Allocated;
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

	public boolean isDirty()
	{
		return status != EAllocationStatus.Allocated || branchStatus != EAllocationStatus.Allocated;
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

	private static final class BitLocker
	{
		private BigInteger bits = BigInteger.ZERO;

		public int newLock()
		{
			int lock = 0;
			while (bits.testBit(lock)) lock++;
			bits = bits.setBit(lock);
			return lock;
		}

		public void release(int lock)
		{
			bits = bits.clearBit(lock);
			if (bits.equals(BigInteger.ZERO))
			{
				bits = BigInteger.ZERO;
			}
		}

		public boolean isLocked()
		{
			return !bits.equals(BigInteger.ZERO);
		}
	}
}
