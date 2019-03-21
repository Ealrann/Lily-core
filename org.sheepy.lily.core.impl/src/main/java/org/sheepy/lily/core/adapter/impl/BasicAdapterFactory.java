package org.sheepy.lily.core.adapter.impl;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.IBasicAdapterFactory;
import org.sheepy.lily.core.adapter.ITickDescriptor;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.resource.IResourceLoader;

public class BasicAdapterFactory implements IBasicAdapterFactory
{
	private final ServiceAdapterRegistry registry = new ServiceAdapterRegistry();

	// Force the ResourceLoader to be loaded
	static final IResourceLoader instance = IResourceLoader.INSTANCE;

	@Override
	public <T extends IAdapter> T adapt(EObject target, Class<T> type)
	{
		T res = null;

		final AdapterManager manager = getOrCreateManager(target);
		res = manager.adapt(type);

		return res;
	}

	private AdapterManager getOrCreateManager(EObject target)
	{
		AdapterManager res = null;
		for (final Adapter adapter : target.eAdapters())
		{
			if (adapter instanceof AdapterManager)
			{
				res = (AdapterManager) adapter;
				break;
			}
		}

		if (res == null)
		{
			res = new AdapterManager(registry);
			target.eAdapters().add(res);
		}

		return res;
	}

	@Override
	public void setupRoot(EObject root)
	{
		getOrCreateManager(root);
	}

	@Override
	public void uninstallRoot(EObject root)
	{
		final Iterator<Adapter> it = root.eAdapters().iterator();
		while (it.hasNext())
		{
			final Adapter next = it.next();
			if (next instanceof AdapterManager)
			{
				it.remove();
			}
		}
	}

	@Override
	public ITickDescriptor getTickDescriptor(EObject eObject)
	{
		return getOrCreateManager(eObject);
	}

}
