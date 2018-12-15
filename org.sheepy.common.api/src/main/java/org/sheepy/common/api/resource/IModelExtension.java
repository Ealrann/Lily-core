package org.sheepy.common.api.resource;

import java.util.Collection;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EPackage;
import org.sheepy.common.api.service.IService;

public interface IModelExtension extends IService
{
	Collection<EPackage> getEPackages();

	static List<IModelExtension> EXTENSIONS = StreamSupport
			.stream(ServiceLoader.load(IModelExtension.class).spliterator(), false)
			.collect(Collectors.toList());
}
