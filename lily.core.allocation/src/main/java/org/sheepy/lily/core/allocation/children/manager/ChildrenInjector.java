package org.sheepy.lily.core.allocation.children.manager;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.extender.IAdapterHandle;
import org.logoce.lmf.core.api.extender.reflect.ConsumerHandle;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;

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

	public void inject(final Stream<? extends IFeaturedObject> children)
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
