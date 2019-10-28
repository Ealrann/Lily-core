package org.sheepy.lily.core.adapter.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.sheepy.lily.core.adapter.ITickDescriptor;
import org.sheepy.lily.core.adapter.impl.AdapterHandle.NotifyHandle;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterManager;
import org.sheepy.lily.core.api.adapter.LilyEObject;

public final class AdapterManager extends EContentAdapter implements IAdapterManager
{
	private static final String ADAPTER_CREATION_LOOP = "Adapter creation loop.";
	private static final ServiceAdapterRegistry registry = ServiceAdapterRegistry.INSTANCE;

	public final List<ITickDescriptor> tickers = new ArrayList<>();

	private final List<AdapterHandle<?>> adapterHandles = new ArrayList<>();
	private final Deque<Class<?>> constructingAdapters = new ArrayDeque<>();

	private boolean constructing = false;
	private List<NotifyHandle>[] notificationMap = null;

	private void registerNotifier(EObject target, AdapterHandle<?> adapterHandle)
	{
		if (notificationMap == null)
		{
			initNotificationMap(target);
		}

		for (final var notifyHandle : adapterHandle.notifyHandles)
		{
			for (final Integer id : notifyHandle.featureIds)
			{
				var list = notificationMap[id];
				if (list == null)
				{
					list = new ArrayList<>();
					notificationMap[id] = list;
				}
				list.add(notifyHandle);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void initNotificationMap(EObject target)
	{
		final int featureCount = target.eClass().getEAllStructuralFeatures().size();
		notificationMap = new List[featureCount];
	}

	@Override
	public void notifyChanged(Notification notification)
	{
		super.notifyChanged(notification);

		if (notificationMap != null && notification.getFeature() != null)
		{
			final int featureId = notification.getFeatureID(target.getClass());
			final var notifyHandles = notificationMap[featureId];
			if (notifyHandles != null)
			{
				for (int i = 0; i < notifyHandles.size(); i++)
				{
					final var adapterHandle = notifyHandles.get(i);
					adapterHandle.notifyChanged(notification);
				}
			}
		}
	}

	@Override
	protected void setTarget(EObject target)
	{
		basicSetTarget(target);
		loadAutoAdapters(target);

		final EList<EObject> eContents = target.eContents();
		for (int i = 0; i < eContents.size(); i++)
		{
			final var child = eContents.get(i);
			addAdapter(child);
		}
	}

	@Override
	protected void unsetTarget(EObject target)
	{
		final EList<EObject> eContents = target.eContents();
		for (int i = 0; i < eContents.size(); i++)
		{
			final var child = eContents.get(i);
			unsetTarget(child);
		}

		disposeAutoAdapters();
	}

	@Override
	protected boolean resolve()
	{
		return false;
	}

	@Override
	public <T extends IAdapter> T adapt(EObject target, Class<T> type)
	{
		if (constructing && constructingAdapters.contains(type))
		{
			throw new AssertionError(ADAPTER_CREATION_LOOP);
		}

		T res = findAdapter(type);

		if (res == null)
		{
			res = createAdapter(target, type);
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

	private <T extends IAdapter> T createAdapter(EObject target, Class<T> type)
	{
		T res = null;

		final var descriptor = registry.getDescriptorFor(target, type);
		if (descriptor != null)
		{
			constructingAdapters.addLast(type);
			res = descriptor.info.create(target);
			final var adapterHandle = new AdapterHandle<>(descriptor, target, res);
			adapterHandles.add(adapterHandle);
			if (constructingAdapters.removeLast() != type) throwBadError();
			constructing = !constructingAdapters.isEmpty();

			registerNotifier(target, adapterHandle);

			adapterHandle.load();

			for (final var tickHandle : adapterHandle.tickHandles)
			{
				tickers.add(tickHandle);
			}
		}

		return res;
	}

	private void throwBadError() throws AssertionError
	{
		throw new AssertionError("Something went really wrong");
	}

	@Override
	protected void handleContainment(Notification notification)
	{
		switch (notification.getEventType())
		{
		case Notification.SET:
		{
			final Notifier oldValue = (Notifier) notification.getOldValue();
			final Notifier newValue = (Notifier) notification.getNewValue();

			// Allow to re-set a reference to trigger the listeners,
			// without destroying the AdapterManager
			if (oldValue != newValue)
			{
				if (oldValue != null)
				{
					removeAdapter(oldValue);
				}
				if (newValue != null)
				{
					addAdapter(newValue);
				}
			}
			break;
		}
		default:
			super.handleContainment(notification);
		}
	}

	@Override
	protected void addAdapter(Notifier notifier)
	{
		final var lilyObject = (LilyEObject) notifier;
		lilyObject.setupAdapterManager();
	}

	@Override
	protected void removeAdapter(Notifier notifier)
	{
		final var lilyObject = (LilyEObject) notifier;
		lilyObject.uninstallAdapterManager();
	}

	private void loadAutoAdapters(EObject target)
	{
		final var autoAdapters = registry.getDefinitionsFor(target);
		if (autoAdapters != null)
		{
			for (int i = 0; i < autoAdapters.size(); i++)
			{
				final var descriptor = autoAdapters.get(i);
				if (descriptor.info.isAutoAdapter())
				{
					adapt(target, descriptor.domain.type);
				}
			}
		}
	}

	private void disposeAutoAdapters()
	{
		for (int i = 0; i < adapterHandles.size(); i++)
		{
			final var adapterHandle = adapterHandles.get(i);
			adapterHandle.dispose();
		}
	}
}