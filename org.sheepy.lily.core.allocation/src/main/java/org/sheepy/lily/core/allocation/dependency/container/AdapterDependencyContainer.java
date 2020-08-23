package org.sheepy.lily.core.allocation.dependency.container;

import org.sheepy.lily.core.api.allocation.EAllocationStatus;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;

import java.util.function.Consumer;

public final class AdapterDependencyContainer implements IDependencyContainer
{
	private final IExtender resolvedAllocation;
	private final IExtenderHandle<?> handle;

	public AdapterDependencyContainer(IExtenderHandle<?> handle)
	{
		resolvedAllocation = handle.getExtender();
		this.handle = handle;
	}

	@Override
	public IExtender get()
	{
		return resolvedAllocation;
	}

	@Override
	public boolean isAllocationDirty()
	{
		return handle.getExtender() != resolvedAllocation;
	}

	@Override
	public void listen(final Consumer<EAllocationStatus> statusListener)
	{
	}

	@Override
	public void sulk(final Consumer<EAllocationStatus> statusListener)
	{
	}
}
