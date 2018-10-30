package org.sheepy.common.api.service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Service that has a life cycle (activation and deactivation).
 * 
 * For now, can't be instantiated multiple times.
 */
public abstract interface ITreeService extends IService
{
	void activate();
	void deactivate();
	
	Class<? extends ITreeService> dependsOn();
	
	static Iterator<ITreeService> getServices()
	{
		return ServiceLoader.load(ITreeService.class).iterator();
	}
}
