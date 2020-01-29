package org.sheepy.lily.core.api.adapter;

import java.util.ServiceLoader;

import org.sheepy.lily.core.api.service.IService;

public interface IAdapterFactoryService extends IService
{
	IAdapterFactoryService INSTANCE = ServiceLoader.load(IAdapterFactoryService.class)
												   .findFirst()
												   .get();

	IAdapterManager createAdapterManager(ILilyEObject target);
}
