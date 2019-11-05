package org.sheepy.lily.core.api.adapter;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.util.ListenerNotificationMap;

public abstract class NotifierAdapter implements INotifierAdapter
{
	private final ListenerNotificationMap notificationMap;

	public NotifierAdapter(int featureCount)
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
