package org.sheepy.lily.core.api.notification.observatory;

import org.sheepy.lily.core.api.adapter.IAdapter;

import java.util.function.Consumer;

public interface IAdapterObservatoryBuilder<Adapter extends IAdapter> extends IObservatory.IBuilder
{
	IAdapterObservatoryBuilder<Adapter> gather(Consumer<Adapter> discoveredAdapter, Consumer<Adapter> removedAdapter);
}
