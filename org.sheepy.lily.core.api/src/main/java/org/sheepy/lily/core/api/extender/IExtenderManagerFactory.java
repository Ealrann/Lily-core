package org.sheepy.lily.core.api.extender;

import org.sheepy.lily.core.api.service.IService;

import java.util.ServiceLoader;

public interface IExtenderManagerFactory extends IService
{
	IExtenderManagerFactory INSTANCE = ServiceLoader.load(IExtenderManagerFactory.class)
													.findFirst()
													.orElse(null);

	IExtenderManager.Internal createExtenderManager(IAdaptable target);
}
