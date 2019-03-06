package org.sheepy.lily.core.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapters;

public class ServiceAdapterRegistry
{
	private final List<AdapterDefinition> serviceAdapters;
	private final Map<EClass, List<AdapterDefinition>> autoAdapterMap = new HashMap<>();

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

		serviceAdapters = List.copyOf(foundAdapters);
	}

	public List<AdapterDefinition> getRegisteredAdapters()
	{
		return serviceAdapters;
	}

	public AdapterDefinition getAdapterFor(EClass targetEClass, Class<? extends IAdapter> type)
	{
		AdapterDefinition res = null;

		for (int i = 0; i < serviceAdapters.size(); i++)
		{
			var adapter = serviceAdapters.get(i);
			if (adapter.isAdapterForType(type) && adapter.isApplicable(targetEClass))
			{
				res = adapter;
				break;
			}
		}

		return res;
	}

	public List<AdapterDefinition> getAdaptersFor(EClass targetEClass)
	{
		List<AdapterDefinition> res = new ArrayList<>();

		for (int i = 0; i < serviceAdapters.size(); i++)
		{
			var adapter = serviceAdapters.get(i);
			if (adapter.isApplicable(targetEClass))
			{
				res.add(adapter);
			}
		}

		return res;
	}
}
