package org.sheepy.lily.core.api.allocation;

public interface IAllocationConfigurator
{
	void setAllocationObsolete();
	void lockAllocation();
	void unlockAllocation();
}
