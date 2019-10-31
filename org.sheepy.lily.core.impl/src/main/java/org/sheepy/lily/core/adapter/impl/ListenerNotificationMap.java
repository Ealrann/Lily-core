package org.sheepy.lily.core.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.core.api.adapter.INotificationListener;

public class ListenerNotificationMap implements INotificationListener
{
	private List<INotificationListener>[] notificationMap = null;
	private final EClass targetClass;

	public ListenerNotificationMap(EClass targetClass)
	{
		this.targetClass = targetClass;
	}

	@Override
	public void notifyChanged(Notification notification)
	{
		final var feature = notification.getFeature();
		if (feature != null && notificationMap != null)
		{
			final var targetClass = notification.getNotifier().getClass();
			final int featureId = notification.getFeatureID(targetClass);
			final var notificationListeners = notificationMap[featureId];
			if (notificationListeners != null)
			{
				for (int i = 0; i < notificationListeners.size(); i++)
				{
					final var listener = notificationListeners.get(i);
					listener.notifyChanged(notification);
				}
			}
		}
	}

	public void addListener(AdapterHandle<?> adapterHandle)
	{
		if (notificationMap == null)
		{
			initNotificationMap();
		}

		final var notifyHandles = adapterHandle.notifyHandles;
		for (int i = 0; i < notifyHandles.size(); i++)
		{
			final var notifyHandle = notifyHandles.get(i);
			final var featureIds = notifyHandle.featureIds;
			for (int j = 0; j < featureIds.size(); j++)
			{
				final var feature = featureIds.get(j);
				registerNotificationListener(notifyHandle, feature);
			}
		}
	}

	public void addListener(INotificationListener listener, int[] features)
	{
		if (notificationMap == null)
		{
			initNotificationMap();
		}

		for (int i = 0; i < features.length; i++)
		{
			final var feature = features[i];
			registerNotificationListener(listener, feature);
		}
	}

	public void removeListener(INotificationListener listener, int[] features)
	{
		if (notificationMap != null)
		{
			for (int i = 0; i < features.length; i++)
			{
				final var feature = features[i];
				final var list = notificationMap[feature];
				if (list != null)
				{
					list.remove(listener);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void initNotificationMap()
	{
		final int featureCount = targetClass.getEAllStructuralFeatures().size();
		notificationMap = new List[featureCount];
	}

	private void registerNotificationListener(	final INotificationListener listener,
												final Integer id)
	{
		var list = notificationMap[id];
		if (list == null)
		{
			list = new ArrayList<>(2);
			notificationMap[id] = list;
		}
		list.add(listener);
	}
}
