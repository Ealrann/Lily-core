package org.sheepy.lily.core.allocation.dependency.container;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.IAdapterHandle;

public final class DependencyContainer
{
	private final IAdapterHandle<?> handle;
	private final Runnable onDependencyUpdate;

	private IAdapter extender;

	public DependencyContainer(final IAdapterHandle<?> handle, final Runnable onDependencyUpdate)
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

	public IAdapter get()
	{
		return extender;
	}

	public boolean isDirty()
	{
		return extender != handle.getExtender();
	}

	public IAdapterHandle<?> handle()
	{
		return handle;
	}
}
