package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;

public class AllocationConfigurator implements IAllocationConfigurator
{
	private boolean obsolete = false;

	private Runnable whenObsolete = null;
	private Runnable whenLocked = null;

	public void setCallbacks(Runnable whenObsolete)
	{
		assert this.whenObsolete == null;
		assert this.whenLocked == null;
		this.whenObsolete = whenObsolete;
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

	}

	@Override
	public void unlockAllocation()
	{

	}

	public boolean isLocked()
	{
		return false;
	}
}
