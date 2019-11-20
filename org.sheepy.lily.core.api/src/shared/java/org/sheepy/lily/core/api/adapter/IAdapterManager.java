package org.sheepy.lily.core.api.adapter;

public interface IAdapterManager
{
	<T extends IAdapter> T adapt(Class<T> type);

	void load();
	void dispose();

	void addListener(INotificationListener listener, int... features);
	void removeListener(INotificationListener listener, int... features);
}
