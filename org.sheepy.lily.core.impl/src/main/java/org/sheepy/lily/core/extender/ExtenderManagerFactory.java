package org.sheepy.lily.core.extender;

import org.sheepy.lily.core.api.extender.IAdaptable;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.extender.IExtenderManagerFactory;
import org.sheepy.lily.core.api.resource.IResourceService;

public final class ExtenderManagerFactory implements IExtenderManagerFactory
{
	static
	{
		// Force the ResourceLoader to load
		@SuppressWarnings("unused") final IResourceService resourceLoader = IResourceService.INSTANCE;
	}

	@Override
	public ExtenderManager createExtenderManager(IAdaptable target)
	{
		return new ExtenderManager(target);
	}
}
