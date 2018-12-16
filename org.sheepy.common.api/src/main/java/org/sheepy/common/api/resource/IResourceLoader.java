package org.sheepy.common.api.resource;

import java.util.ServiceLoader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.sheepy.common.api.service.IService;

public interface IResourceLoader extends IService
{
	/**
	 * Create resource (override if already exists). This resource
	 * 
	 * @return
	 */
	Resource createResource(URI uri);

	/**
	 * Load a resource
	 * 
	 * @param uris
	 *            The URIs to load
	 * @param timeOutMs
	 *            The ResourceManager could have to wait {@link IModelExtension} to start, so you
	 *            probably should define a timeOut.
	 * @param listener
	 */
	Resource loadResources(URI uri);

	void saveResource(Resource resource);

	static final IResourceLoader INSTANCE = ServiceLoader.load(IResourceLoader.class).findFirst()
			.get();
}
