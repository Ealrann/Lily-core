package org.sheepy.lily.core.allocation.dependency.container;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.api.allocation.EAllocationStatus;
import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.api.extender.IExtender;

import java.util.function.Consumer;

public final class AllocationDependencyContainer<T extends IExtender> implements IDependencyContainer
{
	private final AllocationInstance<T> resolvedAllocation;
	private Consumer<EAllocationStatus> statusListener;

	public AllocationDependencyContainer(final AllocationHandle<T> handle)
	{
		resolvedAllocation = handle.getMainAllocation();

		if (resolvedAllocation == null)
		{
			throw new RuntimeException("Unallocated Dependency: " + handle.getExtenderClass().getSimpleName());
		}
	}

	@Override
	public boolean isAllocationDirty()
	{
		return resolvedAllocation.getStatus() != EAllocationStatus.Allocated;
	}

	@Override
	public IExtender get()
	{
		return resolvedAllocation.getAllocation();
	}

	@Override
	public void listen(Consumer<EAllocationStatus> statusListener)
	{
		this.statusListener = statusListener;
		resolvedAllocation.listenStatus(this.statusListener);
	}

	@Override
	public void sulk(Consumer<EAllocationStatus> statusListener)
	{
		resolvedAllocation.sulkStatus(this.statusListener);
		this.statusListener = null;
	}
}
