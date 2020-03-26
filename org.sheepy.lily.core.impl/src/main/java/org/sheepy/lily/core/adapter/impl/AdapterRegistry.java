package org.sheepy.lily.core.adapter.impl;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.core.api.adapter.IAdapterRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public final class AdapterRegistry implements IAdapterRegistry
{
	private final static List<IAdapterProvider> ADAPTERS = StreamSupport.stream(ServiceLoader.load(IAdapterProvider.class)
																							 .spliterator(), false)
																		.collect(Collectors.toList());

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
		final var domain = new AdapterDomain<>(adapterClass);
		final var builder = new AdapterInfo.Builder<>(domain);
		final var definition = builder.build();
		return new AdapterDescriptor<>(domain, definition);
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

	public static class AdapterDescriptor<T extends IAdapter>
	{
		public final AdapterDomain<T> domain;
		public final AdapterInfo<T> info;

		public AdapterDescriptor(AdapterDomain<T> domain, AdapterInfo<T> executor)
		{
			this.domain = domain;
			this.info = executor;
		}

		public boolean isNamedAdapter()
		{
			return domain.targetName.isEmpty() == false;
		}
	}
}
