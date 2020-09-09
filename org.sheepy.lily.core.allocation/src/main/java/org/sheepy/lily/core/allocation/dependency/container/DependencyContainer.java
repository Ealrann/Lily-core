package org.sheepy.lily.core.allocation.dependency.container;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;

public final class DependencyContainer
{
	private final IExtenderHandle<?> handle;
	private final Runnable onDependencyUpdate;

	private IExtender extender;

	public DependencyContainer(final IExtenderHandle<?> handle, final Runnable onDependencyUpdate)
	{
		this.handle = handle;
		this.onDependencyUpdate = onDependencyUpdate;
		extender = handle.getExtender();
		handle.listenNoParam(onDependencyUpdate);
		if (handle instanceof AllocationHandle<?> allocHandle) allocHandle.listenActivation(onDependencyUpdate);
	}

	public void update()
	{
		extender = handle.getExtender();
	}

	public void free()
	{
		if (handle instanceof AllocationHandle<?> allocHandle) allocHandle.sulkActivation(onDependencyUpdate);
		handle.sulkNoParam(onDependencyUpdate);
	}

	public IExtender get()
	{
		return extender;
	}

	public boolean isDirty()
	{
		return extender != handle.getExtender();
	}

	public IExtenderHandle<?> handle()
	{
		return handle;
	}
}
