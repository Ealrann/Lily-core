package org.sheepy.lily.core.api.allocation;

import java.util.function.Consumer;

public interface IAllocationState
{
	void setAllocationObsolete();

	void requestUpdate();
	void lockAllocation();
	void unlockAllocation();
	boolean isLocked();
	Lock lockUntil();

	void listenStatus(Consumer<EAllocationStatus> listener);
	void sulkStatus(Consumer<EAllocationStatus> listener);

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
