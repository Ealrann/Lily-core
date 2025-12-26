package org.sheepy.lily.core.api.resource;

import org.logoce.lmf.core.api.model.IModelPackage;

import java.util.Collection;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

public interface IModelExtension
{
	Collection<IModelPackage> getEPackages();

	List<IModelExtension> EXTENSIONS = StreamSupport.stream(ServiceLoader.load(IModelExtension.class)
																		 .spliterator(), false)
													.toList();
}

