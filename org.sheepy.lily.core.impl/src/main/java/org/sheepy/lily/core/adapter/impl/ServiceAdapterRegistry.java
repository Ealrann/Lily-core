package org.sheepy.lily.core.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapters;

public class ServiceAdapterRegistry
{
	private final List<AdapterDescriptor<?>> descriptors;

	ServiceAdapterRegistry()
	{
		final List<AdapterDescriptor<?>> foundDescriptors = new ArrayList<>();

		for (final Module module : ModuleLayer.boot().modules())
		{
			final Adapters adapters = module.getAnnotation(Adapters.class);
			if (adapters != null)
			{
				for (final Class<? extends IAdapter> adapterClass : adapters.classifiers())
				{
					foundDescriptors.add(createDescriptor(adapterClass));
				}
			}
		}

		descriptors = List.copyOf(foundDescriptors);
	}

	private static <T extends IAdapter> AdapterDescriptor<T> createDescriptor(final Class<T> adapterClass)
	{
		final var domain = new AdapterDomain<>(adapterClass);
		final var definition = new AdapterInfo<>(domain);
		return new AdapterDescriptor<>(domain, definition);
	}

	@SuppressWarnings("unchecked")
	public <T extends IAdapter> AdapterDescriptor<T> getDescriptorFor(	EObject eObject,
																		Class<T> type)
	{
		AdapterDescriptor<T> res = null;

		for (final var descriptor : descriptors)
		{
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

		for (final var descriptor : descriptors)
		{
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
