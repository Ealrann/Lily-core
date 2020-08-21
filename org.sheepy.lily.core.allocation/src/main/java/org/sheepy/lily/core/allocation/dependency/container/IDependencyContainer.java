package org.sheepy.lily.core.allocation.dependency.container;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public interface IDependencyContainer
{
	IExtender get();
	boolean isAllocationDirty();
	void listen(Consumer<EAllocationStatus> statusListener);
	void sulk(Consumer<EAllocationStatus> statusListener);

	final class Builder
	{
		private final Class<? extends IExtender> type;

		public Builder(Class<? extends IExtender> type)
		{
			this.type = type;
		}

		public Stream<IDependencyContainer> streamBuild(final List<ILilyEObject> targets)
		{
			return targets.stream().map(this::build).filter(Optional::isPresent).map(Optional::get);
		}

		public Optional<IDependencyContainer> build(ILilyEObject target)
		{
			return target.extenders().adaptHandles(type).findAny().map(Builder::buildDependencyContainer);
		}

		private static IDependencyContainer buildDependencyContainer(final IExtenderHandle<? extends IExtender> handle)
		{
			if (handle instanceof AllocationHandle<?> allocationHandle)
			{
				return new AllocationDependencyContainer<>(allocationHandle);
			}
			else
			{
				return new AdapterDependencyContainer(handle);
			}
		}
	}
}
