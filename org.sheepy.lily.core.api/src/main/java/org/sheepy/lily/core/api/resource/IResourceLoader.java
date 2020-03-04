package org.sheepy.lily.core.api.resource;

import org.eclipse.emf.ecore.resource.Resource;
import org.sheepy.lily.core.api.service.IService;

import java.io.InputStream;
import java.util.ServiceLoader;

public interface IResourceLoader extends IService
{
	Resource loadResource(InputStream inputStream);

	IResourceLoader INSTANCE = ServiceLoader.load(IResourceLoader.class).findFirst().orElse(null);
}
