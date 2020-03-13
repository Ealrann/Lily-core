package org.sheepy.lily.core.api.adapter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.InternalEObject;
import org.sheepy.lily.core.api.notification.INotificationListener;

import java.util.function.Consumer;
import java.util.stream.Stream;

public interface ILilyEObject extends InternalEObject
{
	Stream<ILilyEObject> streamChildren();
	Stream<ILilyEObject> streamAllChildren();

	<T extends IAdapter> T adapt(Class<T> type);
	<T extends IAdapter> T adaptNotNull(Class<T> type);

	<T extends IAdapter> T adaptGeneric(Class<? extends IAdapter> type);
	<T extends IAdapter> T adaptNotNullGeneric(Class<? extends IAdapter> type);

	default void addListener(INotificationListener listener, int... features)
	{
		listen(listener, features);
	}
	default void removeListener(INotificationListener listener, int... features)
	{
		sulk(listener, features);
	}

	void listen(Consumer<Notification> listener, int... features);
	void sulk(Consumer<Notification> listener, int... features);

	void listenNoParam(Runnable listener, int... features);
	void sulkNoParam(Runnable listener, int... features);
}
