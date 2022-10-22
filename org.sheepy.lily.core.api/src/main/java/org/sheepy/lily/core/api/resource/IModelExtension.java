package org.sheepy.lily.core.api.resource;

import org.eclipse.emf.ecore.EPackage;

import java.util.Collection;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

public interface IModelExtension
{
	Collection<EPackage> getEPackages();

	List<IModelExtension> EXTENSIONS = StreamSupport.stream(ServiceLoader.load(IModelExtension.class)
																		 .spliterator(), false)
													.toList();
}
