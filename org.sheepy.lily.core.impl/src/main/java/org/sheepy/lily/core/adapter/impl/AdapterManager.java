package org.sheepy.lily.core.adapter.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.ITickDescriptor;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterManager;
import org.sheepy.lily.core.api.adapter.LilyEObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class AdapterManager implements IAdapterManager
{
	public final List<ITickDescriptor> tickers = new ArrayList<>();

	private final List<AdapterHandle<?>> adapterHandles = new ArrayList<>();
	private final AdapterManagerDeployer deployer;

	private boolean loaded = false;

	public AdapterManager(EObject target)
	{
		deployer = new AdapterManagerDeployer(target);
		deployer.buildAutoAdapters(adapterHandles);
		deployer.foreachChild(LilyEObject::setupAdapterManager);
	}

	@Override
	public void listen(Consumer<Notification> listener, int... features)
	{
		deployer.listen(listener, features);
	}

	@Override
	public void sulk(Consumer<Notification> listener, int... features)
	{
		deployer.sulk(listener, features);
	}

	@Override
	public void listenNoParam(Runnable listener, int... features)
	{
		deployer.listenNoParam(listener, features);
	}

	@Override
	public void sulkNoParam(Runnable listener, int... features)
	{
		deployer.sulkNoParam(listener, features);
	}

	@Override
	public <T extends IAdapter> T adapt(Class<T> type)
	{
		final T res = findAdapter(type);

		if (res != null)
		{
			return res;
		}
		else
		{
			return createAdapter(type);
		}
	}

	private <T extends IAdapter> T findAdapter(Class<T> type)
	{
		for (int i = 0; i < adapterHandles.size(); i++)
		{
			final var adapterHandle = adapterHandles.get(i);
			if (adapterHandle.domain.isAdapterForType(type))
			{
				return type.cast(adapterHandle.adapter);
			}
		}
		return null;
	}

	private <T extends IAdapter> T createAdapter(Class<T> type)
	{
		final var handle = deployer.createAdapter(type);
		if (handle != null)
		{
			adapterHandles.add(handle);
			if (loaded)
			{
				loadHandle(handle);
			}
			return handle.adapter;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void load()
	{
		if (!loaded)
		{
			loaded = true;
			deployer.setAutoLoad(true);

			for (int i = 0; i < adapterHandles.size(); i++)
			{
				final var adapterHandle = adapterHandles.get(i);
				loadHandle(adapterHandle);
			}
		}
		deployer.foreachChild(LilyEObject::loadAdapterManager);
	}

	@Override
	public void dispose()
	{
		deployer.foreachChild(LilyEObject::disposeAdapterManager);
		if (loaded)
		{
			loaded = false;
			deployer.setAutoLoad(false);

			for (int i = 0; i < adapterHandles.size(); i++)
			{
				final var adapterHandle = adapterHandles.get(i);
				adapterHandle.dispose();
			}
		}
	}

	public <T extends IAdapter> void loadHandle(final AdapterHandle<T> adapterHandle)
	{
		addHandleListener(adapterHandle);
		adapterHandle.load();
		tickers.addAll(adapterHandle.tickHandles);
	}

	private void addHandleListener(AdapterHandle<?> adapterHandle)
	{
		final var notifyHandles = adapterHandle.notifyHandles;
		for (int i = 0; i < notifyHandles.size(); i++)
		{
			final var notifyHandle = notifyHandles.get(i);
			final var featureIds = notifyHandle.featureIds;

			listen(notifyHandle, featureIds);
		}
	}
}
