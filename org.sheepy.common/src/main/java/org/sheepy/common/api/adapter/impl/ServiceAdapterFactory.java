package org.sheepy.common.api.adapter.impl;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.IAutoAdapter;
import org.sheepy.common.api.adapter.IServiceAdapter;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.adapter.IStatefullAdapter;

public class ServiceAdapterFactory implements IServiceAdapterFactory
{
	public static final ServiceAdapterFactory INSTANCE = new ServiceAdapterFactory();

	private final ServiceAdapterRegistry registry = new ServiceAdapterRegistry(this);

	private ServiceAdapterFactory()
	{}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IServiceAdapter> T adapt(EObject target, Class<T> type)
	{
		final T patternAdapter = registry.getAdapterFor(target.eClass(), type);
		T res = null;

		if (patternAdapter != null)
		{
			if (patternAdapter instanceof IStatefullAdapter)
			{
				var adapters = target.eAdapters();
				for (int i = 0; i < adapters.size(); i++)
				{
					final var adapter = adapters.get(i);
					if (adapter.getClass() == patternAdapter.getClass())
					{
						res = (T) adapter;
						break;
					}
				}
				if (res == null)
				{
					res = (T) patternAdapter.clone();
					target.eAdapters().add((IStatefullAdapter) res);
				}
			}
			else // Singleton Adapter, no need to check anything else.
			{
				res = patternAdapter;
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
