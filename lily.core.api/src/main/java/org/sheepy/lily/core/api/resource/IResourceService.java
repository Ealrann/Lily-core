package org.sheepy.lily.core.api.resource;

import org.logoce.lmf.core.lang.LMObject;
import org.sheepy.lily.core.model.application.Application;

import java.io.InputStream;
import java.util.Optional;
import java.util.ServiceLoader;

public interface IResourceService
{
	LMObject loadResource(final InputStream inputStream);

	void saveResource(final LMObject root, final String uri);

	Optional<Application> loadApplication(final Module module, final String filePath);

	IResourceService INSTANCE = ServiceLoader.load(IResourceService.class)
											 .findFirst()
											 .orElse(null);
}

