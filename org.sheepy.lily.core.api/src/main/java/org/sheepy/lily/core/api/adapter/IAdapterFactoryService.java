package org.sheepy.lily.core.api.adapter;

import java.util.ServiceLoader;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.service.IService;

public interface IAdapterFactoryService extends IService
{
	static final IAdapterFactoryService INSTANCE = ServiceLoader.load(IAdapterFactoryService.class)
			.findFirst().get();

	<T extends IAdapter> T adapt(EObject lilyObject, Class<T> classifier);

	void setupRoot(EObject root);
	void uninstallRoot(EObject root);
}
