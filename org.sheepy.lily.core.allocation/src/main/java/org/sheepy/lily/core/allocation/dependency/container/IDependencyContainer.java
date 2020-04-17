package org.sheepy.lily.core.allocation.dependency.container;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.List;
import java.util.stream.Collectors;

public interface IDependencyContainer
{
	ILilyEObject getTarget();
	void resolve();
	IExtender get();
	boolean isAllocationDirty();

	final class Builder
	{
		private final ILilyEObject target;

		public Builder(final ILilyEObject target)
		{
			this.target = target;
		}

		public List<IDependencyContainer> build(Class<? extends IExtender> type)
		{
			return target.adapters()
						 .adaptHandles(type)
						 .map(this::buildDependencyContainer)
						 .collect(Collectors.toUnmodifiableList());
		}

		private IDependencyContainer buildDependencyContainer(final IExtenderHandle<? extends IExtender> handle)
		{
			if (handle instanceof AllocationHandle<?> allocationHandle)
			{
				return new AllocationDependencyContainer(allocationHandle);
			}
			else
			{
				return new AdapterDependencyContainer(handle, target);
			}
		}
	}
}
