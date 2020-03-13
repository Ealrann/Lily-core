package org.sheepy.lily.core.api.notification.util;

import org.eclipse.emf.common.notify.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class EMFListenerMap
{
	private final int featureCount;

	private List<Object>[] notificationMap = null;

	public EMFListenerMap(int featureCount)
	{
		this.featureCount = featureCount;
	}

	@SuppressWarnings("unchecked")
	public void notify(Notification notification)
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
						if (listener instanceof Runnable)
						{
							((Runnable) listener).run();
						}
						else
						{
							((Consumer<Notification>) listener).accept(notification);
						}
					}
				}
			}
		}
	}

	public void listen(Consumer<Notification> listener, int... features)
	{
		listenInternal(listener, features);
	}

	public void listenNoParam(Runnable listener, int... features)
	{
		listenInternal(listener, features);
	}

	private void listenInternal(Object listener, int... features)
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

	public void sulk(Consumer<Notification> listener, int... features)
	{
		sulkInternal(listener, features);
	}

	public void sulkNoParam(Runnable listener, int... features)
	{
		sulkInternal(listener, features);
	}

	private void sulkInternal(Object listener, int... features)
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

	private void registerNotificationListener(final Object listener, final int id)
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
