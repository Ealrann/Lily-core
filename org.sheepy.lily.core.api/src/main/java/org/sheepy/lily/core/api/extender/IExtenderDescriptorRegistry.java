package org.sheepy.lily.core.api.extender;

import org.eclipse.emf.ecore.EObject;

import java.util.ServiceLoader;
import java.util.stream.Stream;

public interface IExtenderDescriptorRegistry
{
	Stream<IExtenderDescriptor<?>> streamDescriptors();
	<T extends IExtender> Stream<IExtenderDescriptor<T>> streamDescriptors(final EObject target, final Class<T> type);

	IExtenderDescriptorRegistry INSTANCE = ServiceLoader.load(IExtenderDescriptorRegistry.class)
														.findFirst()
														.orElse(null);
}
