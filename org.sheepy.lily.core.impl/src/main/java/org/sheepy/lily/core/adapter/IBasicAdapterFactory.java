package org.sheepy.lily.core.adapter;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;

public interface IBasicAdapterFactory extends IAdapterFactoryService
{
	ITickDescriptor getTickDescriptor(EObject eObject);
}
