package org.sheepy.lily.core.api.adapter;

import org.eclipse.emf.common.notify.Adapter;

public interface IAdapterManager extends Adapter
{
	<T extends IAdapter> T adapt(Class<T> type);

	void load();
	void dispose();

	void addListener(INotificationListener listener, int[] features);
	void removeListener(INotificationListener listener, int[] features);
}
