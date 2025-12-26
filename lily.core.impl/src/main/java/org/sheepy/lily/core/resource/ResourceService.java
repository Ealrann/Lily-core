package org.sheepy.lily.core.resource;

import org.logoce.lmf.core.api.service.ILmLoader;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.api.model.ModelRegistry;
import org.logoce.lmf.core.api.service.LmLoadException;
import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.core.api.resource.IResourceService;
import org.sheepy.lily.core.model.application.Application;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public final class ResourceService implements IResourceService
{
	private final ILmLoader.Session session;

	public ResourceService()
	{
		final var registry = buildRegistry();
		this.session = ILmLoader.provider()
								.map(provider -> provider.newSession(registry))
								.orElse(null);
	}

	@Override
	public LMObject loadResource(final InputStream inputStream)
	{
		if (inputStream == null) return null;
		if (session == null) return null;

		try
		{
			final var roots = session.loadObjects(inputStream);
			if (roots.isEmpty()) return null;
			return roots.getFirst();
		}
		catch (final IOException | LmLoadException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void saveResource(final LMObject root, final String uri)
	{
		throw new UnsupportedOperationException("LMF resource serialization is not supported yet");
	}

	@Override
	public Optional<Application> loadApplication(final Module module, final String filePath)
	{
		if (module == null || filePath == null) return Optional.empty();

		try (final var inputStream = module.getResourceAsStream(filePath))
		{
			final var root = loadResource(inputStream);
			return root instanceof Application app ? Optional.of(app) : Optional.empty();
		}
		catch (final IOException e)
		{
			e.printStackTrace();
			return Optional.empty();
		}
	}

	private static ModelRegistry buildRegistry()
	{
		final var builder = new ModelRegistry.Builder(ModelRegistry.empty());
		for (final var extension : IModelExtension.EXTENSIONS)
		{
			for (final var pkg : extension.getEPackages())
			{
				builder.register(pkg.model());
			}
		}
		return builder.build();
	}
}
