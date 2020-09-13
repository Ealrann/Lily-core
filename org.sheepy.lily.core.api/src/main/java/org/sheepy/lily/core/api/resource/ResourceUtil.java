package org.sheepy.lily.core.api.resource;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;

public class ResourceUtil
{

	public static final Collection<URI> getXmlUrisFromPath(String path)
	{
		final List<URI> res = new ArrayList<>();
		final File dir = new File(path);

		if (dir.exists())
		{
			if (dir.isDirectory())
			{
				final var files = dir.listFiles();
				if(files != null)
				{
					for (final var file : files)
					{
						if (file.getName().endsWith(".xmi") || file.getName().endsWith(".xml"))
						{
							res.add(URI.createFileURI(file.getAbsolutePath()));
						}
					}
				}
			}
			else
			{
				if (path.endsWith(".xmi") || path.endsWith(".xml"))
				{
					res.add(URI.createFileURI(dir.getAbsolutePath()));
				}
			}
		}
		
		return res;
	}
}
