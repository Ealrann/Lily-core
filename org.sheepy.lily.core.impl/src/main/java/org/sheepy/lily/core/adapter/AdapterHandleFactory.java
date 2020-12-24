package org.sheepy.lily.core.adapter;

import org.sheepy.lily.core.adapter.util.NotifyChangeManager;
import org.sheepy.lily.core.adapter.util.ObservatoryManager;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.*;

import java.lang.annotation.Annotation;
import java.util.List;

public final class AdapterHandleFactory implements IExtenderHandleFactory
{
	private static final List<IAdapterExtension.Descriptor> EXTENSION_DESCRIPTORS = List.of(NotifyChangeManager.Builder::new,
																							ObservatoryManager.Builder::new);

	@Override
	public <E extends IExtender> IExtenderHandleBuilder<E> newBuilder(final IExtenderDescriptor<E> descriptor)
	{
		return new AdapterHandleBuilder<>(descriptor, EXTENSION_DESCRIPTORS);
	}

	@Override
	public Class<? extends Annotation> describedBy()
	{
		return Adapter.class;
	}
}
