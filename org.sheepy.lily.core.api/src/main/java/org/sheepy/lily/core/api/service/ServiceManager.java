package org.sheepy.lily.core.api.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

import org.sheepy.lily.core.api.util.DebugUtil;

public class ServiceManager
{
	/**
	 * Map between Service Interface and Services
	 */
	private static Map<Class<? extends IService>, List<IService>> serviceMap = new HashMap<>();

	/**
	 * Map between implementation service classes, and service.
	 */
	private static Map<Class<? extends IService>, IService> instanciatedServiceMap = new HashMap<>();

	private static final Comparator<IService> priorityComparator = new Comparator<>()
	{
		@Override
		public int compare(IService o1, IService o2)
		{
			return Integer.compare(o1.getPriority(), o2.getPriority());
		}
	};

	public static final <T extends IService> List<T> getServices(Class<T> serviceClass)
	{
		return getServicesInternal(serviceClass);
	}

	@SuppressWarnings("unchecked")
	public static final <T extends IService> List<T> getServicesInternal(Class<T> serviceClass)
	{
		if (serviceMap.containsKey(serviceClass) == false)
		{
			load(serviceClass);
		}

		return (List<T>) serviceMap.get(serviceClass);
	}

	public static final <T extends IService> T getService(Class<T> serviceClass)
	{
		List<T> services = getServicesInternal(serviceClass);

		if (services.size() > 0)
		{
			return services.get(0);
		}
		else
		{
			return null;
		}
	}

	/**
	 * 
	 */
	private static Deque<Class<? extends IService>> serviceBuildDeque = new ArrayDeque<>();

	private static final void load(Class<? extends IService> serviceClass)
	{
		List<IService> res = Collections.emptyList();

		if (serviceBuildDeque.contains(serviceClass))
		{
			logCyclingError(serviceClass);
		}
		else
		{
			serviceBuildDeque.push(serviceClass);
			res = new ArrayList<>();

			try
			{
				res = gatherServices(serviceClass);
			} finally
			{
				serviceBuildDeque.pop();
			}
		}

		serviceMap.put(serviceClass, List.copyOf(res));

		// If the build list is empty : we activate treeServices
		if (serviceBuildDeque.isEmpty())
		{
			// activateTreeServices();
		}
	}

	private static List<IService> gatherServices(Class<? extends IService> serviceClass)
	{
		List<IService> res = new ArrayList<>();
		var it = ServiceLoader.load(serviceClass).iterator();

		while (it.hasNext())
		{
			IService service = it.next();

			Class<? extends IService> instantiateClass = service.getClass();
			if (instanciatedServiceMap.containsKey(instantiateClass))
			{
				// If the service has already been instantiated (maybe
				// with a different interface)
				res.add(instanciatedServiceMap.get(instantiateClass));
			}
			else
			{
				res.add(service);
			}
		}

		Collections.sort(res, priorityComparator);

		if (DebugUtil.DEBUG_ENABLED)
		{
			for (IService service : res)
			{
				log(serviceClass, service);
			}
		}

		return res;
	}

	private static void logCyclingError(Class<? extends IService> serviceClass)
	{
		List<Class<? extends IService>> stack = new ArrayList<>(serviceBuildDeque);
		Collections.reverse(stack);
		// Oups, cycling build detected
		System.err.println(
				"==================================================================================");
		System.err.println(
				"[Loop service building] The following services calls each other constructors:");
		int index = 1;
		for (Class<? extends IService> service : stack)
		{
			System.err.println(String.format("\t%d: %s", index++, service.getSimpleName()));
		}
		System.err.println(String.format("\t%d: %s", index, serviceClass.getSimpleName()));
		System.err.println(
				"==================================================================================");
	}

	private static void log(Class<? extends IService> serviceClass, IService service)
	{
		System.out.println(
				String.format("Start service [%s] %s (priority [%d])", serviceClass.getSimpleName(),
						service.getClass().getSimpleName(), service.getPriority()));
	}
}
