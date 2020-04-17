package org.sheepy.lily.core.extender;

import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.extender.IExtenderManagerFactory;
import org.sheepy.lily.core.api.resource.IResourceLoader;

public final class ExtenderManagerFactory implements IExtenderManagerFactory
{
	static
	{
		// Force the ResourceLoader to load
		@SuppressWarnings("unused") final IResourceLoader resourceLoader = IResourceLoader.INSTANCE;
	}

	@Override
	public ExtenderManager createExtenderManager(ILilyEObject target)
	{
		return new ExtenderManager(target);
	}
}
