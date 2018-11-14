package org.sheepy.common.api.adapter.impl;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.IAutoAdapter;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.adapter.ISingletonAdapter;
import org.sheepy.common.api.adapter.IStatefullAdapter;

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
					res = (T) patternAdapter.clone();
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

	@Override
	public void loadAutoAdapters(EObject target)
	{
		for (IAutoAdapter adapter : registry.getAutoAdapters(target.eClass()))
		{
			adapt(target, adapter.getClass()).load(target);
		}
	}

	@Override
	public void disposeAutoAdapters(EObject target)
	{
		for (IAutoAdapter adapter : registry.getAutoAdapters(target.eClass()))
		{
			adapt(target, adapter.getClass()).dispose(target);
		}
	}
}
