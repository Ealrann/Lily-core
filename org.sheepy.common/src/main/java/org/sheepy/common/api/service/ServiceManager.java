package org.sheepy.common.api.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

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

	/**
	 * Map between implementation service classes, and service.
	 */
	private static ListMultimap<Class<? extends ITreeService>, Class<? extends ITreeService>> dependancyGraph = ArrayListMultimap
			.create();

	private static final Comparator<IService> priorityComparator = new Comparator<>()
	{
		@Override
		public int compare(IService o1, IService o2)
		{
			return Integer.compare(o1.getPriority(), o2.getPriority());
		}
	};

	public static final <T extends IStandaloneService> List<T> getServices(Class<T> serviceClass)
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

	public static final void restartTreeService(Class<? extends ITreeService> serviceClass)
	{
		ITreeService service = getService(serviceClass);

		if (service != null)
		{
			service.deactivate();

			for (Class<? extends ITreeService> subService : dependancyGraph.get(serviceClass))
			{
				restartTreeService(subService);
			}

			service.activate();
		}
	}

	/**
	 * 
	 */
	private static Deque<Class<? extends IService>> serviceBuildDeque = new ArrayDeque<>();
	private static Deque<ITreeService> serviceToActivate = new ArrayDeque<>();

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
			activateTreeServices();
		}
	}

	private static void activateTreeServices()
	{
		// We copy the list, because the activation could lead to new
		// service build.
		List<ITreeService> toActivate = List.copyOf(serviceToActivate);
		Collections.reverse(toActivate);
		serviceToActivate.clear();
		for (ITreeService service : toActivate)
		{
			if (service.dependsOn() != null)
			{
				Class<? extends ITreeService> clazz = service.getClass();
				dependancyGraph.put(service.dependsOn(), clazz);
			}

			service.activate();
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
				if (service instanceof ITreeService)
				{
					serviceToActivate.push((ITreeService) service);
				}

				res.add(service);
			}
		}

		Collections.sort(res, priorityComparator);

		for (IService service : res)
		{
			log(serviceClass, service);
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
