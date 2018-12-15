package org.sheepy.common.api.adapter.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.sheepy.common.api.adapter.IAutoAdapter;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.adapter.ISingletonAdapter;
import org.sheepy.common.api.adapter.IStatefullAdapter;
import org.sheepy.common.api.adapter.impl.AutoEContentAdapter;
import org.sheepy.common.api.resource.IModelExtension;
import org.sheepy.common.api.util.ReflectivityUtils;

public class ServiceAdapterFactory implements IServiceAdapterFactory
{
	public static final ServiceAdapterFactory INSTANCE = new ServiceAdapterFactory();

	private final ServiceAdapterRegistry registry = new ServiceAdapterRegistry(this);

	private ServiceAdapterFactory()
	{}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends ISingletonAdapter> T adapt(EObject target, Class<T> type)
	{
		T res = null;

		var adapters = target.eAdapters();
		for (int i = 0; i < adapters.size(); i++)
		{
			var adapter = adapters.get(i);
			if (adapter.isAdapterForType(type))
			{
				res = (T) adapter;
				break;
			}
		}

		if (res == null)
		{
			final T patternAdapter = registry.getAdapterFor(target.eClass(), type);
			if (patternAdapter != null)
			{
				if (patternAdapter instanceof IStatefullAdapter)
				{
					var classifier = (Class<T>) patternAdapter.getClass();
					res = ReflectivityUtils.constructNew(classifier);
				}
				else // Singleton Adapter, no need to check anything else.
				{
					res = patternAdapter;
				}

				target.eAdapters().add(res);
			}
		}

		return res;
	}

	public void loadAutoAdapters(EObject target)
	{
		List<IAutoAdapter> autoAdapters = registry.getAutoAdapters(target.eClass());
		if (autoAdapters != null)
		{
			for (IAutoAdapter adapter : autoAdapters)
			{
				adapt(target, adapter.getClass()).load(target);
			}
		}
	}

	public void disposeAutoAdapters(EObject target)
	{
		List<IAutoAdapter> autoAdapters = registry.getAutoAdapters(target.eClass());
		if (autoAdapters != null)
		{
			for (IAutoAdapter adapter : autoAdapters)
			{
				adapt(target, adapter.getClass()).dispose(target);
			}
		}
	}

	@Override
	public void setupRootForAutoAdapters(EObject root)
	{
		loadEPackages();
		
		root.eAdapters().add(new AutoEContentAdapter());
	}

	private void loadEPackages()
	{
		for(IModelExtension extension : IModelExtension.EXTENSIONS)
		{
			for (EPackage ePackage : extension.getEPackages())
			{
				// Load factories
				ePackage.eClass();
				System.out.println("\tLoad EPackage: " + ePackage.getName());
			}
		}
	}
}
