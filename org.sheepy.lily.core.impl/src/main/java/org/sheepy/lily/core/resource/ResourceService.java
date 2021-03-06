package org.sheepy.lily.core.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.core.api.resource.IResourceService;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.model.application.Application;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

public class ResourceService implements IResourceService
{
	// Load all EPackages
	static
	{
		for (final IModelExtension extension : IModelExtension.EXTENSIONS)
		{
			for (final EPackage ePackage : extension.getEPackages())
			{
				// Load factories
				ePackage.eClass();

				if (DebugUtil.DEBUG_VERBOSE_ENABLED)
				{
					System.out.println("\tLoad EPackage: " + ePackage.getName());
				}
			}
		}
	}

	@Override
	public Resource loadResource(InputStream inputStream)
	{
		final Resource res = new XMIResourceImpl();

		try
		{
			res.load(inputStream, null);
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public void saveResource(final EObject root, final URI uri)
	{
		final var resource = new XMIResourceImpl(uri);
		resource.getContents().add(root);
		try
		{
			resource.save(Map.of());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public Optional<Application> loadApplication(final Module module, final String filePath)
	{
		try
		{
			final var inputStream = module.getResourceAsStream(filePath);
			final var resource = loadResource(inputStream);

			if (resource != null && resource.getContents().isEmpty() == false)
			{
				return Optional.of((Application) resource.getContents().get(0));
			}
			else
			{
				return Optional.empty();
			}
		}
		catch (final IOException e)
		{
			e.printStackTrace();
			return Optional.empty();
		}
	}
}
