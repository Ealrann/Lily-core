package org.sheepy.lily.core.api.notification.util;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.notification.INotificationListener;

import java.util.ArrayList;
import java.util.List;

public class EMFListenerMap
{
	private final int featureCount;

	private List<INotificationListener>[] notificationMap = null;

	public EMFListenerMap(int featureCount)
	{
		this.featureCount = featureCount;
	}

	public void fireNotification(Notification notification)
	{
		if (notificationMap != null)
		{
			final var targetClass = notification.getNotifier().getClass();
			final int featureId = notification.getFeatureID(targetClass);
			if (featureId != Notification.NO_FEATURE_ID)
			{
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
	}

	public void addListener(INotificationListener listener, int... features)
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

	public void removeListener(INotificationListener listener, int... features)
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
		notificationMap = new List[featureCount];
	}

	private void registerNotificationListener(final INotificationListener listener, final int id)
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
