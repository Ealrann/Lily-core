package org.sheepy.lily.core.allocation.dependency.container;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;

public final class AdapterDependencyContainer implements IDependencyContainer
{
	private final IExtenderHandle<?> handle;
	private final ILilyEObject target;
	private IExtender resolvedAllocation = null;

	public AdapterDependencyContainer(IExtenderHandle<?> handle, ILilyEObject target)
	{
		this.handle = handle;
		this.target = target;
	}

	@Override
	public void resolve()
	{
		resolvedAllocation = handle.getExtender();
	}

	@Override
	public ILilyEObject getTarget()
	{
		return target;
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
}
