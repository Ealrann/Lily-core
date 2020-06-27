package org.sheepy.lily.core.allocation.children;

import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;
import org.sheepy.lily.core.api.util.IModelExplorer;

import java.util.List;
import java.util.stream.Collectors;

public record ChildrenInjector(Class<? extends IExtender>type, ConsumerHandle handle, IModelExplorer childrenExplorer,
							   boolean many)
{
	public ChildrenInjector(IExtenderHandle.AnnotatedHandle<InjectChildren> handle, IModelExplorer childrenExplorer)
	{
		this(handle.annotation().type(),
			 (ConsumerHandle) handle.executionHandle(),
			 childrenExplorer,
			 handle.method().getParameterTypes()[0] == List.class);
	}

	public void inject(ILilyEObject source)
	{
		final var stream = childrenExplorer.stream(source).map(c -> c.adapt(type));
		if (many) handle.invoke(stream.collect(Collectors.toUnmodifiableList()));
		else handle.invoke(stream.findAny().orElse(null));
	}

	public static final class Builder
	{
		private final AllocationChildrenManager.Builder childrenManagerBuilder;

		public Builder(final AllocationChildrenManager.Builder childrenManagerBuilder)
		{
			this.childrenManagerBuilder = childrenManagerBuilder;
		}

		public ChildrenInjector build(IExtenderHandle.AnnotatedHandle<InjectChildren> handle)
		{
			final var childrenExplorer = childrenManagerBuilder.getChildrenExplorer(handle.annotation().index());
			return new ChildrenInjector(handle, childrenExplorer);
		}
	}
}
