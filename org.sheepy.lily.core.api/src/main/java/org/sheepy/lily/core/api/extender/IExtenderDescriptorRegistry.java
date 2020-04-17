package org.sheepy.lily.core.api.extender;

import org.eclipse.emf.ecore.EObject;

import java.util.ServiceLoader;
import java.util.stream.Stream;

public interface IExtenderDescriptorRegistry
{
	Stream<IExtenderDescriptor<?>> streamDescriptors(final EObject target);
	Stream<IExtenderDescriptor<?>> streamDescriptors();

	IExtenderDescriptorRegistry INSTANCE = ServiceLoader.load(IExtenderDescriptorRegistry.class)
														.findFirst()
														.orElse(null);
}
