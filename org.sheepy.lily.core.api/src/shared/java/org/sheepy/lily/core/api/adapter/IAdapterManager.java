package org.sheepy.lily.core.api.adapter;

import org.eclipse.emf.common.notify.Notification;

import java.util.function.Consumer;

public interface IAdapterManager
{
	<T extends IAdapter> T adapt(Class<T> type);

	void load();
	void dispose();

	void listen(Consumer<Notification> listener, int... features);
	void sulk(Consumer<Notification> listener, int... features);

	void listenNoParam(Runnable listener, int... features);
	void sulkNoParam(Runnable listener, int... features);
}
