package org.sheepy.lily.core.api.notification;

public interface INotifier
{
	void addListener(INotificationListener listener, int... features);
	void removeListener(INotificationListener listener, int... features);
}
