package org.sheepy.lily.core.allocation.dependency.container;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.AllocationInstance;
import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.api.extender.IExtender;

import java.util.function.Consumer;

public final class AllocationDependencyContainer<T extends IExtender> implements IDependencyContainer
{
	private final AllocationInstance<T> resolvedAllocation;
	private Consumer<AllocationInstance<T>> statusListener;

	public AllocationDependencyContainer(AllocationHandle<T> handle)
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
		this.statusListener = instance -> statusListener.accept(instance.getStatus());
		resolvedAllocation.listen(this.statusListener);
	}

	@Override
	public void sulk(Consumer<EAllocationStatus> statusListener)
	{
		resolvedAllocation.sulk(this.statusListener);
		this.statusListener = null;
	}
}
