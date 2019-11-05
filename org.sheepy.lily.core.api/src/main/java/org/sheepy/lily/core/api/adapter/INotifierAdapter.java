package org.sheepy.lily.core.api.adapter;

public interface INotifierAdapter extends IAdapter
{
	void addListener(INotificationListener listener, int... features);
	void removeListener(INotificationListener listener, int... features);
}
