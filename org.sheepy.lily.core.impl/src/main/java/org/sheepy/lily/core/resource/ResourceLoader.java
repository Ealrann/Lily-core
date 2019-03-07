package org.sheepy.lily.core.resource;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.core.api.resource.IResourceLoader;
import org.sheepy.lily.core.api.util.DebugUtil;

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

				if (DebugUtil.DEBUG_ENABLED)
				{
					System.out.println("\tLoad EPackage: " + ePackage.getName());
				}
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
