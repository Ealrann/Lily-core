package org.sheepy.lily.core.adapter;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.sheepy.lily.core.api.adapter.IAutoAdapter;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IStatefullAdapter;
import org.sheepy.lily.core.api.resource.IResourceLoader;
import org.sheepy.lily.core.api.util.ReflectivityUtils;

public class ServiceAdapterFactory implements IServiceAdapterFactory
{
	private final ServiceAdapterRegistry registry = new ServiceAdapterRegistry(this);

	// Force the ResourceLoader to be loaded
	static final IResourceLoader instance = IResourceLoader.INSTANCE;

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IAdapter> T adapt(EObject target, Class<T> type)
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

	@Override
	public void setupAutoAdapters(EObject root)
	{
		root.eAdapters().add(new AutoEContentAdapter());
	}

	@Override
	public void disposeAutoAdapters(EObject root)
	{
		Iterator<Adapter> it = root.eAdapters().iterator();
		while (it.hasNext())
		{
			Adapter next = it.next();
			if (next instanceof AutoEContentAdapter)
			{
				it.remove();
			}
		}
	}

	class AutoEContentAdapter extends EContentAdapter
	{
		@Override
		protected void setTarget(EObject target)
		{
			loadAutoAdapters(target);
			super.setTarget(target);
		}

		@Override
		protected void unsetTarget(EObject target)
		{
			super.unsetTarget(target);
			disposeAutoAdapters(target);
		}

		private void loadAutoAdapters(EObject target)
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

		private void disposeAutoAdapters(EObject target)
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
	}
}
