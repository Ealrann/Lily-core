package org.sheepy.lily.core.allocation.children;

import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;
import org.sheepy.lily.core.api.util.IModelExplorer;

import java.util.stream.Collectors;

public record ChildrenInjector(Class<? extends IExtender>type, ConsumerHandle handle, IModelExplorer childrenExplorer)
{
	public ChildrenInjector(IExtenderHandle.AnnotatedHandle<InjectChildren> handle, IModelExplorer childrenExplorer)
	{
		this(handle.annotation().type(), (ConsumerHandle) handle.executionHandle(), childrenExplorer);
	}

	public void inject(ILilyEObject source)
	{
		handle.invoke(childrenExplorer.stream(source).map(c -> c.adapt(type)).collect(Collectors.toUnmodifiableList()));
	}

	public static final class Builder
	{
		private final AllocationChildrenManager childrenManager;

		public Builder(final AllocationChildrenManager childrenManager)
		{
			this.childrenManager = childrenManager;
		}

		public ChildrenInjector build(IExtenderHandle.AnnotatedHandle<InjectChildren> handle)
		{
			final var childrenExplorer = childrenManager.getChildrenExplorer(handle.annotation().index());
			return new ChildrenInjector(handle, childrenExplorer);
		}
	}
}
