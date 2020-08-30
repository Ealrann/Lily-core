package org.sheepy.lily.core.allocation.children.manager;

import org.sheepy.lily.core.allocation.description.AllocationDescriptor;
import org.sheepy.lily.core.allocation.operation.IOperationNode;
import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.util.List;
import java.util.function.Supplier;

public record ChildrenInjector(Class<? extends IExtender> type, ConsumerHandle handle, boolean many)
{
	public ChildrenInjector(IExtenderHandle.AnnotatedHandle<InjectChildren> handle)
	{
		this(handle.annotation().type(),
			 (ConsumerHandle) handle.executionHandle(),
			 handle.method().getParameterTypes()[0] == List.class);
	}

	public boolean match(AllocationDescriptor<?> descriptor)
	{
		final var extenderClass = descriptor.extenderClass();
		return extenderClass.isAssignableFrom(type);
	}

	public IOperationNode prepareInjection(final Supplier<List<IExtender>> children)
	{
		return c -> inject(children.get());
	}

	public void inject(final List<IExtender> children)
	{
		if (many) handle.invoke(children);
		else handle.invoke(children.isEmpty() ? null : children.get(0));
	}
}
