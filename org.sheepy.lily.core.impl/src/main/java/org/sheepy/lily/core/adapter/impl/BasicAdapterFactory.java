package org.sheepy.lily.core.adapter.impl;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.sheepy.lily.core.adapter.IBasicAdapterFactory;
import org.sheepy.lily.core.adapter.ITickDescriptor;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterManager;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.resource.IResourceLoader;

public final class BasicAdapterFactory implements IBasicAdapterFactory
{
	static
	{
		// Force the ResourceLoader to load
		@SuppressWarnings("unused")
		final IResourceLoader resourceLoader = IResourceLoader.INSTANCE;
	}

	@Override
	public <T extends IAdapter> T adapt(ILilyEObject target, Class<T> type)
	{
		T res = null;

		final var manager = getOrCreateManager(target);
		res = manager.adapt(type);

		return res;
	}

	private static IAdapterManager getOrCreateManager(ILilyEObject target)
	{
		IAdapterManager res = target.getAdapterManager();

		if (res == null)
		{
			res = new AdapterManager();
			target.setAdapterManager(res);
		}

		return res;
	}

	@Override
	public void setupRoot(ILilyEObject root)
	{
		getOrCreateManager(root);
	}

	@Override
	public void uninstallRoot(ILilyEObject root)
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
	public List<ITickDescriptor> getTickDescriptors(ILilyEObject eObject)
	{
		final var manager = (AdapterManager) getOrCreateManager(eObject);
		return manager.tickers;
	}
}
