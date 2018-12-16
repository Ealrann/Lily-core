package org.sheepy.common.api.adapter;

import java.util.ServiceLoader;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.service.IService;

public interface IServiceAdapterFactory extends IService
{
	static final IServiceAdapterFactory INSTANCE = ServiceLoader.load(IServiceAdapterFactory.class)
			.findFirst().get();

	<T extends IAdapter> T adapt(EObject lilyObject, Class<T> classifier);

	void setupAutoAdapters(EObject root);
	void disposeAutoAdapters(EObject root);
}
