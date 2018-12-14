package org.sheepy.common.api.resource;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sheepy.common.api.service.IService;
import org.sheepy.common.api.service.ServiceManager;

public interface IResourceManager extends IService
{

	/**
	 * Create resource (override if already exists). This resource
	 * 
	 * @return
	 */
	Resource createResource(URI uri);

	/**
	 * Load a resource, and fire the listener when the load is done.
	 * 
	 * @param uris
	 *            The URIs to load
	 * @param timeOutMs
	 *            The ResourceManager could have to wait {@link IModelExtension}
	 *            to start, so you probably should define a timeOut.
	 * @param listener
	 */
	void loadResources(Collection<URI> uris, int timeOutMs, IResourceLoaderListener listener);

	/**
	 * Return a resource if present on resourceSet.
	 * 
	 * @return
	 */
	Resource getResource(URI uri);

	/**
	 * Unload and remove a resource from the resourceSet.
	 * 
	 * @return
	 */
	void removeResource(Resource resource);
	
	void removeAllResources();

	void saveResource(Resource resource);

	ResourceSet getResourceSet();

	static IResourceManager getService()
	{
		return ServiceManager.getService(IResourceManager.class);
	}
}
