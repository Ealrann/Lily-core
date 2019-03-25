package org.sheepy.lily.core.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapters;

public class ServiceAdapterRegistry
{
	private final List<AdapterDescriptor> descriptors;

	ServiceAdapterRegistry()
	{
		final List<AdapterDescriptor> foundDescriptors = new ArrayList<>();

		for (final Module module : ModuleLayer.boot().modules())
		{
			final Adapters adapters = module.getAnnotation(Adapters.class);
			if (adapters != null)
			{
				for (final Class<? extends IAdapter> adapterClass : adapters.classifiers())
				{
					final var domain = new AdapterDomain(adapterClass);
					final var definition = new AdapterExecutor(domain);
					final var container = new AdapterDescriptor(domain, definition);

					foundDescriptors.add(container);
				}
			}
		}

		descriptors = List.copyOf(foundDescriptors);
	}

	public AdapterDescriptor getDescriptorFor(EObject eObject, Class<? extends IAdapter> type)
	{
		AdapterDescriptor res = null;

		for (final AdapterDescriptor descriptor : descriptors)
		{
			final var domain = descriptor.domain;
			if (domain.isAdapterForType(type) && domain.isApplicable(eObject))
			{
				res = descriptor;

				if (res.isNamedAdapter())
				{
					break;
				}
			}
		}

		return res;
	}

	public List<AdapterDescriptor> getDefinitionsFor(EObject eobject)
	{
		final List<AdapterDescriptor> res = new ArrayList<>();

		for (final AdapterDescriptor descriptor : descriptors)
		{
			final var domain = descriptor.domain;
			if (domain.isApplicable(eobject))
			{
				res.add(descriptor);
			}
		}

		return res;
	}

}
