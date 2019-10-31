package org.sheepy.lily.core.api.adapter;

import java.util.ServiceLoader;

import org.sheepy.lily.core.api.service.IService;

public interface IAdapterFactoryService extends IService
{
	static final IAdapterFactoryService INSTANCE = ServiceLoader.load(IAdapterFactoryService.class)
																.findFirst()
																.get();

	@Deprecated
	<T extends IAdapter> T adapt(ILilyEObject lilyObject, Class<T> classifier);

	IAdapterManager createAdapterManager(ILilyEObject target);
}
