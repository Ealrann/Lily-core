package org.sheepy.lily.core.api.notification;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.notification.util.ListenerNotificationMap;

public class Notifier implements INotifier
{
	private final ListenerNotificationMap notificationMap;

	public Notifier(int featureCount)
	{
		notificationMap = new ListenerNotificationMap(featureCount);
	}

	protected void fireNotification(Notification notification)
	{
		notificationMap.notifyChanged(notification);
	}

	@Override
	public void addListener(INotificationListener listener, int... features)
	{
		notificationMap.addListener(listener, features);
	}

	@Override
	public void removeListener(INotificationListener listener, int... features)
	{
		notificationMap.removeListener(listener, features);
	}
}
