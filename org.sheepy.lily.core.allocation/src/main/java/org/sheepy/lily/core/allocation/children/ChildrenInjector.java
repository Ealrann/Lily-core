package org.sheepy.lily.core.allocation.children;

import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.util.List;
import java.util.stream.Collectors;

public record ChildrenInjector(Class<? extends IExtender>type, ConsumerHandle handle)
{
	public ChildrenInjector(IExtenderHandle.AnnotatedHandle<InjectChildren> handle)
	{
		this(handle.annotation().type(), (ConsumerHandle) handle.executionHandle());
	}

	public void inject(List<ILilyEObject> children)
	{
		handle.invoke(children.stream().map(c -> c.adapt(type)).collect(Collectors.toUnmodifiableList()));
	}
}
