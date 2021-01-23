package org.sheepy.lily.core.api.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sheepy.lily.core.model.application.Application;

import java.io.InputStream;
import java.util.Optional;
import java.util.ServiceLoader;

public interface IResourceService
{
	Resource loadResource(final InputStream inputStream);
	void saveResource(final EObject root, final URI uri);

	Optional<Application> loadApplication(final Module module, final String filePath);

	IResourceService INSTANCE = ServiceLoader.load(IResourceService.class)
											 .findFirst()
											 .orElse(null);
}
