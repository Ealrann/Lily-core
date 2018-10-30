package org.sheepy.common.api.service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Common service. Can be intantiated multiple times.
 */
public interface IStandaloneService extends IService
{
	static Iterator<IStandaloneService> getServices()
	{
		return ServiceLoader.load(IStandaloneService.class).iterator();
	}
}
