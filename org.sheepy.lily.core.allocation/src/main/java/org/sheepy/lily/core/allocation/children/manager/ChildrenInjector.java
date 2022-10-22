package org.sheepy.lily.core.allocation.children.manager;

import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.IAdapterHandle;
import org.logoce.extender.api.reflect.ConsumerHandle;
import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public record ChildrenInjector(Class<? extends IAdapter> type, ConsumerHandle handle, boolean many)
{
	public ChildrenInjector(IAdapterHandle.AnnotatedHandle<InjectChildren> handle)
	{
		this(handle.annotation()
				   .type(),
			 (ConsumerHandle) handle.executionHandle(),
			 handle.method()
				   .getParameterTypes()[0] == List.class);
	}

	public void inject(final Stream<ILilyEObject> children)
	{
		final var allocations = children.map(element -> element.adapt(type))
										.filter(Objects::nonNull)
										.toList();
		inject(allocations);
	}

	public void inject(final List<? extends IAdapter> children)
	{
		if (many) handle.invoke(children);
		else handle.invoke(children.isEmpty() ? null : children.get(0));
	}
}
