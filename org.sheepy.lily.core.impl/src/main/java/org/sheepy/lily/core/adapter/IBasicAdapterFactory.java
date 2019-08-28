package org.sheepy.lily.core.adapter;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.ILilyEObject;

public interface IBasicAdapterFactory extends IAdapterFactoryService
{
	List<ITickDescriptor> getTickDescriptors(ILilyEObject eObject);
}
