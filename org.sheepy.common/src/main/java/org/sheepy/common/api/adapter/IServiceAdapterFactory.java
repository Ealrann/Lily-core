package org.sheepy.common.api.adapter;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.internal.ServiceAdapterFactory;

public interface IServiceAdapterFactory
{
	public static final IServiceAdapterFactory INSTANCE = ServiceAdapterFactory.INSTANCE;
	
	<T extends ISingletonAdapter> T adapt(EObject lilyObject, Class<T> classifier);
	
	void setupRootForAutoAdapters(EObject root);
}
