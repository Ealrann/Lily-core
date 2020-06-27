package org.sheepy.lily.core.api.allocation;

public interface IAllocationState
{
	void setAllocationObsolete();
	void lockAllocation();
	void unlockAllocation();
	boolean isLocked();
}
