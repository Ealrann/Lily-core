package org.sheepy.common.api.adapter.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.adapter.IAutoAdapter;
import org.sheepy.common.api.adapter.IServiceAdapter;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.service.ServiceManager;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

public class ServiceAdapterRegistry
{
	private final List<IServiceAdapter> serviceAdapters;
	private final List<IAutoAdapter> autoServiceAdapters;

	private final Set<EClass> mappedEClasses = ConcurrentHashMap.newKeySet();

	private final Map<Integer, IServiceAdapter> adapterMap = new HashMap<>();
	private final ListMultimap<EClass, IAutoAdapter> autoAdapterMap = ArrayListMultimap.create();

	private final IServiceAdapterFactory adapterFactory;

	ServiceAdapterRegistry(IServiceAdapterFactory adapterFactory)
	{
		this.adapterFactory = adapterFactory;
		List<IServiceAdapter> foundAdapters = new ArrayList<>();
		List<IAutoAdapter> foundAutoAdapters = new ArrayList<>();

		for (var adapterService : ServiceManager.getServices(IServiceAdapter.class))
		{
			initAdapter(adapterService);
			foundAdapters.add(adapterService);

			if (adapterService instanceof IAutoAdapter)
			{
				foundAutoAdapters.add((IAutoAdapter) adapterService);
				addAutoAdapter((IAutoAdapter) adapterService);
			}

			// var name = adapterService.getClass().getSimpleName();
			// System.out.println("\tRegistered Adapter : " + name);
		}

		serviceAdapters = List.copyOf(foundAdapters);
		autoServiceAdapters = List.copyOf(foundAutoAdapters);
	}

	private void initAdapter(IServiceAdapter adapterService)
	{
		adapterService.setAdapterFactory(adapterFactory);
	}

	public List<IServiceAdapter> getRegisteredAdapters()
	{
		return serviceAdapters;
	}

	public List<IAutoAdapter> getAutoAdapters(EClass eClass)
	{
		if (mappedEClasses.contains(eClass) == false)
		{
			computeAutoAdaptersMap(eClass);
		}

		return autoAdapterMap.get(eClass);
	}

	private void computeAutoAdaptersMap(EClass eClass)
	{
		for (int i = 0; i < autoServiceAdapters.size(); i++)
		{
			IAutoAdapter adapter = autoServiceAdapters.get(i);
			if (adapter.isApplicable(eClass))
			{
				autoAdapterMap.put(eClass, adapter);
			}
		}

		mappedEClasses.add(eClass);
	}

	private void addAutoAdapter(IAutoAdapter adapter)
	{
		for (EClass eClass : mappedEClasses)
		{
			if (adapter.isApplicable(eClass))
			{
				autoAdapterMap.put(eClass, adapter);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends IServiceAdapter> T getAdapterFor(EClass targetEClass, Class<T> type)
	{
		T res = null;

		var key = hash(targetEClass, type);
		if (adapterMap.containsKey(key))
		{
			res = (T) adapterMap.get(key);
		}
		else
		{
			res = findAdapter(targetEClass, type);
			adapterMap.put(key, res);
		}

		return res;
	}

	@SuppressWarnings("unchecked")
	private <T extends IServiceAdapter> T findAdapter(EClass targetEClass, Class<T> type)
	{
		T res = null;

		for (int i = 0; i < serviceAdapters.size(); i++)
		{
			var adapter = serviceAdapters.get(i);
			if (adapter.isAdapterForType(type) && adapter.isApplicable(targetEClass))
			{
				res = (T) adapter;
				break;
			}
		}

		return res;
	}

	private static final int hash(EClass targetEClass, Class<? extends IServiceAdapter> type)
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((targetEClass == null) ? 0 : targetEClass.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
}
