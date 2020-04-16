package org.sheepy.lily.core.adapter;

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
	public IAdapterManager createAdapterManager(ILilyEObject target)
	{
		return new AdapterManager(target);
	}
}
