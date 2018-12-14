package org.sheepy.common.api.adapter.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.adapter.IAutoAdapter;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.adapter.ISingletonAdapter;
import org.sheepy.common.api.service.ServiceManager;

public class ServiceAdapterRegistry
{
	private final List<ISingletonAdapter> serviceAdapters;
	private final List<IAutoAdapter> autoServiceAdapters;

	private final Set<EClass> mappedEClasses = ConcurrentHashMap.newKeySet();

	private final Map<EClass, List<IAutoAdapter>> autoAdapterMap = new HashMap<>();

	private final IServiceAdapterFactory adapterFactory;

	ServiceAdapterRegistry(IServiceAdapterFactory adapterFactory)
	{
		this.adapterFactory = adapterFactory;
		List<ISingletonAdapter> foundAdapters = new ArrayList<>();
		List<IAutoAdapter> foundAutoAdapters = new ArrayList<>();

		for (var adapterService : ServiceManager.getServices(ISingletonAdapter.class))
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

	private void initAdapter(ISingletonAdapter adapterService)
	{
		adapterService.setAdapterFactory(adapterFactory);
	}

	public List<ISingletonAdapter> getRegisteredAdapters()
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
				addAutoAdapter(eClass, adapter);
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
				addAutoAdapter(eClass, adapter);
			}
		}
	}

	private void addAutoAdapter(EClass eClass, IAutoAdapter adapter)
	{
		List<IAutoAdapter> list = autoAdapterMap.get(eClass);
		if (list == null)
		{
			list = new ArrayList<>();
			autoAdapterMap.put(eClass, list);
		}
		list.add(adapter);
	}

	@SuppressWarnings("unchecked")
	public <T extends ISingletonAdapter> T getAdapterFor(EClass targetEClass, Class<T> type)
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
}
