package org.sheepy.lily.core.adapter.impl;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.IAdapterManager;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.resource.IResourceLoader;

public final class AdapterManagerFactory implements IAdapterFactoryService
{
	static
	{
		// Force the ResourceLoader to load
		@SuppressWarnings("unused")
		final IResourceLoader resourceLoader = IResourceLoader.INSTANCE;
	}

	@Override
	public <T extends IAdapter> T adapt(ILilyEObject target, Class<T> type)
	{
		return target.adapt(type);
	}

	@Override
	public IAdapterManager createAdapterManager()
	{
		return new AdapterManager();
	}
}
