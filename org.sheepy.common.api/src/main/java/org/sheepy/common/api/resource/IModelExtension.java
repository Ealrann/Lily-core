package org.sheepy.common.api.resource;

import java.util.Collection;

import org.eclipse.emf.ecore.EPackage;
import org.sheepy.common.api.service.IService;
import org.sheepy.common.api.service.ServiceManager;

public interface IModelExtension extends IService
{
	Collection<EPackage> getEPackages();

	static IModelExtension getService()
	{
		return ServiceManager.getService(IModelExtension.class);
	}
}
