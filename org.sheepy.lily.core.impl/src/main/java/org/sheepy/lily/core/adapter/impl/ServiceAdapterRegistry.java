package org.sheepy.lily.core.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapters;

public class ServiceAdapterRegistry
{
	private final List<AdapterDefinition> adapters;

	ServiceAdapterRegistry()
	{
		List<AdapterDefinition> foundAdapters = new ArrayList<>();

		for (Module module : ModuleLayer.boot().modules())
		{
			Adapters adapters = module.getAnnotation(Adapters.class);
			if (adapters != null)
			{
				for (Class<? extends IAdapter> adapterClass : adapters.classifiers())
				{
					var wrapper = new AdapterDefinition(adapterClass);
					foundAdapters.add(wrapper);

					// var name = adapterService.getClass().getSimpleName();
					// System.out.println("\tRegistered Adapter : " + name);
				}
			}
		}

		adapters = List.copyOf(foundAdapters);
	}

	public AdapterDefinition getAdapterFor(EObject eObject, Class<? extends IAdapter> type)
	{
		AdapterDefinition res = null;

		for (AdapterDefinition definition : adapters)
		{
			if (definition.isAdapterForType(type) && definition.isApplicable(eObject))
			{
				res = definition;

				if (res.isNamedAdapter())
				{
					break;
				}
			}
		}

		return res;
	}

	public List<AdapterDefinition> getAdaptersFor(EObject eobject)
	{
		List<AdapterDefinition> res = new ArrayList<>();

		for (AdapterDefinition adapter : adapters)
		{
			if (adapter.isApplicable(eobject))
			{
				res.add(adapter);
			}
		}

		return res;
	}
}
