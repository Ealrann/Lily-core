package org.sheepy.lily.core.adapter.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.ITickDescriptor;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterManager;
import org.sheepy.lily.core.api.adapter.IAdapterRegistry;
import org.sheepy.lily.core.api.adapter.INotificationListener;
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.core.api.util.ListenerNotificationMap;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.api.util.TinyEContentAdapter;

public final class AdapterManager extends TinyEContentAdapter implements IAdapterManager
{
	private static final String ADAPTER_CREATION_LOOP = "Adapter creation loop.";
	private static final AdapterRegistry registry = (AdapterRegistry) IAdapterRegistry.INSTANCE;

	private final Deque<Class<?>> constructingAdapters = new ArrayDeque<>();
	private boolean constructing = false;

	public final List<ITickDescriptor> tickers = new ArrayList<>();

	private final List<AdapterHandle<?>> adapterHandles = new ArrayList<>();
	private final ListenerNotificationMap notificationMap;

	private boolean loaded = false;

	public AdapterManager(EObject target)
	{
		setTarget(target);

		final int featureCount = target.eClass().getEAllStructuralFeatures().size();
		notificationMap = new ListenerNotificationMap(featureCount);
		installAutoAdapters();

		foreachChild(LilyEObject::setupAdapterManager);
	}

	@Override
	public void addListener(INotificationListener listener, int[] features)
	{
		notificationMap.addListener(listener, features);
	}

	@Override
	public void removeListener(INotificationListener listener, int[] features)
	{
		notificationMap.removeListener(listener, features);
	}

	@Override
	public <T extends IAdapter> T adapt(Class<T> type)
	{
		if (constructing && constructingAdapters.contains(type))
		{
			throw new AssertionError(ADAPTER_CREATION_LOOP);
		}

		T res = findAdapter(type);

		if (res == null)
		{
			res = createAdapter(type);
		}

		return res;
	}

	private <T extends IAdapter> T findAdapter(Class<T> type)
	{
		T res = null;
		for (int i = 0; i < adapterHandles.size(); i++)
		{
			final var adapterHandle = adapterHandles.get(i);
			if (adapterHandle.domain.isAdapterForType(type))
			{
				res = type.cast(adapterHandle.adapter);
				break;
			}
		}
		return res;
	}

	private <T extends IAdapter> T createAdapter(Class<T> type)
	{
		T res = null;

		final var eTarget = (EObject) target;
		final var descriptor = registry.getDescriptorFor(eTarget, type);
		if (descriptor != null)
		{
			constructing = true;
			constructingAdapters.addLast(type);
			res = descriptor.info.create(eTarget);
			final var adapterHandle = new AdapterHandle<>(descriptor, eTarget, res);
			adapterHandles.add(adapterHandle);
			if (constructingAdapters.removeLast() != type) throwBadError();
			constructing = !constructingAdapters.isEmpty();

			if (loaded)
			{
				loadHandle(adapterHandle);
			}
		}

		return res;
	}

	private static void throwBadError() throws AssertionError
	{
		throw new AssertionError("Something went really wrong");
	}

	@Override
	public void notifyChanged(Notification notification)
	{
		super.notifyChanged(notification);
		notificationMap.notifyChanged(notification);
	}

	@Override
	protected void setupChild(Notifier notifier)
	{
		final var child = (LilyEObject) notifier;
		child.setupAdapterManager();

		if (loaded)
		{
			child.loadAdapterManager();
		}
	}

	@Override
	protected void disposeChild(Notifier notifier)
	{
		if (loaded)
		{
			final var child = (LilyEObject) notifier;
			child.disposeAdapterManager();
		}
	}

	@Override
	public void load()
	{
		if (loaded == false)
		{
			loaded = true;
			for (int i = 0; i < adapterHandles.size(); i++)
			{
				final var adapterHandle = adapterHandles.get(i);
				loadHandle(adapterHandle);
			}
		}

		foreachChild(LilyEObject::loadAdapterManager);
	}

	private void foreachChild(Consumer<LilyEObject> consumer)
	{
		ModelUtil	.streamChildren((EObject) target)
					.map(LilyEObject.class::cast)
					.collect(Collectors.toList())
					.forEach(consumer);
	}

	private void installAutoAdapters()
	{
		final var eTarget = (EObject) target;
		final var autoAdapters = registry.getDefinitionsFor(eTarget);
		if (autoAdapters != null)
		{
			for (int i = 0; i < autoAdapters.size(); i++)
			{
				final var descriptor = autoAdapters.get(i);
				if (descriptor.info.isAutoAdapter())
				{
					adapt(descriptor.domain.type);
				}
			}
		}
	}

	@Override
	public void dispose()
	{
		if (loaded)
		{
			foreachChild(LilyEObject::disposeAdapterManager);
		}

		loaded = false;

		for (int i = 0; i < adapterHandles.size(); i++)
		{
			final var adapterHandle = adapterHandles.get(i);
			adapterHandle.dispose();
		}
	}

	private <T extends IAdapter> void loadHandle(final AdapterHandle<T> adapterHandle)
	{
		addHandleListener(adapterHandle);
		adapterHandle.load();
		for (final var tickHandle : adapterHandle.tickHandles)
		{
			tickers.add(tickHandle);
		}
	}

	private void addHandleListener(AdapterHandle<?> adapterHandle)
	{
		final var notifyHandles = adapterHandle.notifyHandles;
		for (int i = 0; i < notifyHandles.size(); i++)
		{
			final var notifyHandle = notifyHandles.get(i);
			final var featureIds = notifyHandle.featureIds;
			for (int j = 0; j < featureIds.size(); j++)
			{
				final var feature = featureIds.get(j);
				notificationMap.addListener(notifyHandle, feature);
			}
		}
	}
}
