package org.sheepy.lily.core.api.allocation;

public interface IAllocationState
{
	void setAllocationObsolete();

	void requestUpdate();
	void lockAllocation();
	void unlockAllocation();
	boolean isLocked();
	Lock lockUntil();

	@FunctionalInterface
	interface Lock extends Runnable
	{
		void unlock();

		@Override
		default void run()
		{
			unlock();
		}
	}
}
