package org.sheepy.lily.core.adapter;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;

public interface IBasicAdapterFactory extends IAdapterFactoryService
{
	List<ITickDescriptor> getTickDescriptors(EObject eObject);
}
