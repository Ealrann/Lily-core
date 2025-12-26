package org.sheepy.lily.core.api.resource;

import java.util.Collection;
import java.util.List;

public final class ResourceUtil
{
	private ResourceUtil()
	{
	}

	@Deprecated(forRemoval = true, since = "1.0")
	public static Collection<String> getXmlUrisFromPath(final String path)
	{
		throw new UnsupportedOperationException(
				"getXmlUrisFromPath is specific to EMF XMI/XML resources and is not supported in the LMF-based stack. " +
				"Use LmLoader with ModelRegistry and explicit model paths instead.");
	}
}

