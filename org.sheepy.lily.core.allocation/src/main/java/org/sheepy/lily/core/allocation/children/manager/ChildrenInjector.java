package org.sheepy.lily.core.allocation.children.manager;

import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record ChildrenInjector(Class<? extends IExtender> type, ConsumerHandle handle, boolean many)
{
	public ChildrenInjector(IExtenderHandle.AnnotatedHandle<InjectChildren> handle)
	{
		this(handle.annotation().type(),
			 (ConsumerHandle) handle.executionHandle(),
			 handle.method().getParameterTypes()[0] == List.class);
	}

	public void inject(final Stream<ILilyEObject> children)
	{
		final var allocations = children.map(element -> element.adapt(type))
										.filter(Objects::nonNull)
										.collect(Collectors.toUnmodifiableList());
		inject(allocations);
	}

	public void inject(final List<? extends IExtender> children)
	{
		if (many) handle.invoke(children);
		else handle.invoke(children.isEmpty() ? null : children.get(0));
	}
}
