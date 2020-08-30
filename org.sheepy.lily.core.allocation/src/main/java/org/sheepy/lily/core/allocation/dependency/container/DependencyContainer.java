package org.sheepy.lily.core.allocation.dependency.container;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;

public final class DependencyContainer
{
	private final IExtender extender;
	private final IExtenderHandle<? extends IExtender> handle;
	private final Runnable onDependencyUpdate;

	public DependencyContainer(final IExtenderHandle<? extends IExtender> handle, final Runnable onDependencyUpdate)
	{
		this.handle = handle;
		this.onDependencyUpdate = onDependencyUpdate;
		extender = handle.getExtender();
		handle.listenNoParam(onDependencyUpdate);
	}

	public void free()
	{
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
}
