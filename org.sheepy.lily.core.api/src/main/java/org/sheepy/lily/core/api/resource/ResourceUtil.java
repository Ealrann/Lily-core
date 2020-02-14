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
				for (File f : dir.listFiles())
				{
					if (f.getName().endsWith(".xmi") || f.getName().endsWith(".xml"))
					{
						res.add(URI.createFileURI(f.getAbsolutePath()));
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
