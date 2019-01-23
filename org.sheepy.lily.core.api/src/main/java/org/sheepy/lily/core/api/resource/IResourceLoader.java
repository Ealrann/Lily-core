package org.sheepy.lily.core.api.resource;

import java.io.InputStream;
import java.util.ServiceLoader;

import org.eclipse.emf.ecore.resource.Resource;
import org.sheepy.lily.core.api.service.IService;

public interface IResourceLoader extends IService
{
	Resource loadResource(InputStream inputStream);

	static final IResourceLoader INSTANCE = ServiceLoader.load(IResourceLoader.class).findFirst()
			.get();
}
