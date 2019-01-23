package org.sheepy.common.resource;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.sheepy.common.api.resource.IModelExtension;
import org.sheepy.common.api.resource.IResourceLoader;

public class ResourceLoader implements IResourceLoader
{

	// Load all EPackages
	static
	{
		for (IModelExtension extension : IModelExtension.EXTENSIONS)
		{
			for (EPackage ePackage : extension.getEPackages())
			{
				// Load factories
				ePackage.eClass();
				System.out.println("\tLoad EPackage: " + ePackage.getName());
			}
		}
	}

	@Override
	public Resource loadResource(InputStream inputStream)
	{
		Resource res = new XMIResourceImpl();

		try
		{
			res.load(inputStream, null);
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return res;
	}
}
