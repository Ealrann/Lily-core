package org.sheepy.lily.core.api.notification.observatory;

import org.sheepy.lily.core.api.adapter.IAdapter;

import java.util.function.Consumer;

public interface IAdapterObservatoryBuilder<Type extends IAdapter> extends IObservatory.IBuilder
{
	IAdapterObservatoryBuilder<Type> gather(Consumer<Type> discoveredAdapter, Consumer<Type> removedAdapter);
}
