package org.sheepy.lily.core.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapters;

public class ServiceAdapterRegistry
{
	private final List<AdapterDefinition> serviceAdapters;
	private final List<AdapterDefinition> autoAdapters;
	private final Set<EClass> mappedEClasses = ConcurrentHashMap.newKeySet();
	private final Map<EClass, List<AdapterDefinition>> autoAdapterMap = new HashMap<>();

	ServiceAdapterRegistry()
	{
		List<AdapterDefinition> foundAdapters = new ArrayList<>();
		List<AdapterDefinition> foundAutoAdapters = new ArrayList<>();

		for (Module module : ModuleLayer.boot().modules())
		{
			Adapters adapters = module.getAnnotation(Adapters.class);
			if (adapters != null)
			{
				for (Class<? extends IAdapter> adapterClass : adapters.classifiers())
				{
					var wrapper = new AdapterDefinition(adapterClass);
					foundAdapters.add(wrapper);

					if (wrapper.isAutoAdapter())
					{
						foundAutoAdapters.add(wrapper);
						addAutoAdapter(wrapper);
					}

					// var name = adapterService.getClass().getSimpleName();
					// System.out.println("\tRegistered Adapter : " + name);
				}
			}
		}

		serviceAdapters = List.copyOf(foundAdapters);
		autoAdapters = List.copyOf(foundAutoAdapters);
	}

	public List<AdapterDefinition> getRegisteredAdapters()
	{
		return serviceAdapters;
	}

	public List<AdapterDefinition> getAutoAdapters(EClass eClass)
	{
		if (mappedEClasses.contains(eClass) == false)
		{
			computeAutoAdaptersMap(eClass);
		}

		return autoAdapterMap.get(eClass);
	}

	private void computeAutoAdaptersMap(EClass eClass)
	{
		for (int i = 0; i < autoAdapters.size(); i++)
		{
			AdapterDefinition adapter = autoAdapters.get(i);
			if (adapter.isApplicable(eClass))
			{
				addAutoAdapter(eClass, adapter);
			}
		}

		mappedEClasses.add(eClass);
	}

	private void addAutoAdapter(AdapterDefinition adapter)
	{
		for (EClass eClass : mappedEClasses)
		{
			if (adapter.isApplicable(eClass))
			{
				addAutoAdapter(eClass, adapter);
			}
		}
	}

	private void addAutoAdapter(EClass eClass, AdapterDefinition adapter)
	{
		List<AdapterDefinition> list = autoAdapterMap.get(eClass);
		if (list == null)
		{
			list = new ArrayList<>();
			autoAdapterMap.put(eClass, list);
		}
		list.add(adapter);
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
}
