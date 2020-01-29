package org.sheepy.lily.core.api.adapter;

import org.eclipse.emf.ecore.InternalEObject;
import org.sheepy.lily.core.api.notification.INotificationListener;

import java.util.stream.Stream;

public interface ILilyEObject extends InternalEObject
{
	Stream<ILilyEObject> streamChildren();
	Stream<ILilyEObject> streamAllChildren();

	<T extends IAdapter> T adapt(Class<T> type);
	<T extends IAdapter> T adaptNotNull(Class<T> type);

	<T extends IAdapter> T adaptGeneric(Class<? extends IAdapter> type);
	<T extends IAdapter> T adaptNotNullGeneric(Class<? extends IAdapter> type);

	void addListener(INotificationListener listener, int... features);
	void removeListener(INotificationListener listener, int... features);
}
