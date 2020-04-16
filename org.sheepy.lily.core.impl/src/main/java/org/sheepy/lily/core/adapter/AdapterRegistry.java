package org.sheepy.lily.core.adapter;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.description.AdapterDescriptor;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterAnnotationService;
import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.core.api.adapter.IAdapterRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public final class AdapterRegistry implements IAdapterRegistry
{
	private static final List<IAdapterProvider> ADAPTERS = ServiceLoader.load(IAdapterProvider.class)
																		.stream()
																		.map(ServiceLoader.Provider::get)
																		.collect(Collectors.toList());

	private static final List<IAdapterAnnotationService<?, ?>> ANNOTATION_SERVICES = ServiceLoader.load(
			IAdapterAnnotationService.class)
																								  .stream()
																								  .map(t -> (IAdapterAnnotationService<?, ?>) t
																										  .get())
																								  .collect(Collectors.toList());
	private static final AdapterDescriptor.Builder descriptorBuilder = new AdapterDescriptor.Builder(ANNOTATION_SERVICES);

	private final List<AdapterDescriptor<?>> descriptors = new ArrayList<>();

	public AdapterRegistry()
	{
		for (final var adapters : ADAPTERS)
		{
			for (final var adapterClass : adapters.classifiers())
			{
				descriptors.add(createDescriptor(adapterClass));
			}
		}
	}

	@Override
	public void register(Class<? extends IAdapter> classifier)
	{
		descriptors.add(createDescriptor(classifier));
	}

	private static <T extends IAdapter> AdapterDescriptor<T> createDescriptor(final Class<T> adapterClass)
	{
		return descriptorBuilder.build(adapterClass);
	}

	@SuppressWarnings("unchecked")
	public <T extends IAdapter> AdapterDescriptor<T> getDescriptorFor(EObject eObject, Class<T> type)
	{
		AdapterDescriptor<T> res = null;

		for (int i = 0; i < descriptors.size(); i++)
		{
			final var descriptor = descriptors.get(i);
			final var domain = descriptor.domain;
			if (domain.isAdapterForType(type) && domain.isApplicable(eObject))
			{
				res = (AdapterDescriptor<T>) descriptor;
				if (res.isNamedAdapter())
				{
					break;
				}
			}
		}

		return res;
	}

	public List<AdapterDescriptor<?>> getDefinitionsFor(EObject eobject)
	{
		final List<AdapterDescriptor<?>> res = new ArrayList<>();

		for (int i = 0; i < descriptors.size(); i++)
		{
			final var descriptor = descriptors.get(i);
			final var domain = descriptor.domain;
			if (domain.isApplicable(eobject))
			{
				res.add(descriptor);
			}
		}

		return res;
	}
}
