package org.sheepy.lily.core.api.notification.observatory;

import org.sheepy.lily.core.api.adapter.IAdapter;

import java.util.function.Consumer;

public interface IAdapterObservatoryBuilder<Type extends IAdapter> extends IObservatory.IBuilder
{
	IAdapterObservatoryBuilder<Type> listenAdd(Consumer<Type> onAddedObject);
	IAdapterObservatoryBuilder<Type> listenRemove(Consumer<Type> onRemovedObject);
}
