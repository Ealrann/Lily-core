package org.sheepy.lily.core.api.notification.util;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.notification.IEMFNotifier;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.Consumer;

public final class EMFListenerMap implements IEMFNotifier
{
	private final int featureCount;

	private Deque<Object>[] listenerMap = null;

	public EMFListenerMap(int featureCount)
	{
		this.featureCount = featureCount;
	}

	public void notify(Notification notification)
	{
		if (listenerMap != null)
		{
			final var targetClass = notification.getNotifier().getClass();
			final int featureId = notification.getFeatureID(targetClass);
			if (featureId != Notification.NO_FEATURE_ID)
			{
				final var listeners = listenerMap[featureId];
				if (listeners != null)
				{
					notify(listeners, notification);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static void notify(final Deque<Object> notificationListeners, final Notification notification)
	{
		for (final var listener : notificationListeners)
		{
			if (listener instanceof Runnable runnable)
			{
				runnable.run();
			}
			else
			{
				((Consumer<Notification>) listener).accept(notification);
			}
		}
	}

	@Override
	public void listen(Consumer<Notification> listener, int... features)
	{
		listenInternal(listener, features);
	}

	@Override
	public void listenNoParam(Runnable listener, int... features)
	{
		listenInternal(listener, features);
	}

	private void listenInternal(Object listener, int... features)
	{
		if (listenerMap == null)
		{
			initNotificationMap();
		}

		for (int i = 0; i < features.length; i++)
		{
			final var feature = features[i];
			registerNotificationListener(listener, feature);
		}
	}

	@Override
	public void sulk(Consumer<Notification> listener, int... features)
	{
		sulkInternal(listener, features);
	}

	@Override
	public void sulkNoParam(Runnable listener, int... features)
	{
		sulkInternal(listener, features);
	}

	private void sulkInternal(Object listener, int... features)
	{
		if (listenerMap != null)
		{
			for (int i = 0; i < features.length; i++)
			{
				final var feature = features[i];
				final var list = listenerMap[feature];
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
		listenerMap = new Deque[featureCount];
	}

	private void registerNotificationListener(final Object listener, final int id)
	{
		var list = listenerMap[id];
		if (list == null)
		{
			list = new ConcurrentLinkedDeque<>();
			listenerMap[id] = list;
		}
		list.add(listener);
	}
}
