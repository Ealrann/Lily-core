package org.sheepy.lily.core.api.resource;

import org.eclipse.emf.ecore.EPackage;
import org.sheepy.lily.core.api.service.IService;

import java.util.Collection;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public interface IModelExtension extends IService
{
	Collection<EPackage> getEPackages();

	List<IModelExtension> EXTENSIONS = StreamSupport.stream(ServiceLoader.load(IModelExtension.class).spliterator(),
															false).collect(Collectors.toList());
}
