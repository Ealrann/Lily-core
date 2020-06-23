package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;

public class AllocationConfigurator implements IAllocationConfigurator
{
	private boolean obsolete = false;
	private boolean locked = false;

	private Runnable whenObsolete = null;
	private Runnable whenUnLocked = null;

	public void setCallbacks(Runnable whenObsolete, Runnable whenUnLocked)
	{
		assert this.whenObsolete == null;
		assert this.whenUnLocked == null;
		this.whenObsolete = whenObsolete;
		this.whenUnLocked = whenUnLocked;
	}

	@Override
	public void setAllocationObsolete()
	{
		this.obsolete = true;
		whenObsolete.run();
	}

	public boolean isObsolete()
	{
		return obsolete;
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
			whenUnLocked.run();
			locked = false;
		}
	}

	@Override
	public boolean isLocked()
	{
		return locked;
	}
}
