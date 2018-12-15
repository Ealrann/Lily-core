package org.sheepy.common.api.cadence;

import java.util.Collection;
import java.util.EventListener;
import java.util.ServiceLoader;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sheepy.common.api.service.IService;
import org.sheepy.common.model.root.LObject;

public interface ICadencer extends IService
{
	// Tickers on cadencer clock
	// Step in ms
	void addTicker(ITicker ticker, int freq);

	void removeTicker(ITicker ticker, int freq);

	void tick(long stepNano);

	ICommandStack getCommandStack();

	ResourceSet getResourceSet();

	Collection<Long> getCadencedThreadsId();

	void stop();

	void dispose();

	/**
	 * Add an already loaded resource to the cadencer.
	 * 
	 * @param resource
	 */
	void addResource(Resource resource);

	void removeResource(Resource resource);

	/**
	 * Delete with crossreferences
	 * 
	 * @param eo
	 * @TODO ne devrait plus être dans le cadencer
	 */
	void deleteObject(EObject eo);

	Collection<Resource> getCadencedResources();

	void addListener(IUnitListener listener);
	void removeListener(IUnitListener listener);

	public interface IUnitListener extends EventListener
	{
		void onUnitAdd(LObject unit);
		void onUnitRemove(LObject unit);
	}

	static ICadencer INSTANCE = ServiceLoader.load(ICadencer.class).findFirst().get();
}
