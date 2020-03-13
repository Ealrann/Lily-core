package org.sheepy.lily.core.api.notification.observatory;

import org.sheepy.lily.core.api.notification.IFeature;

public interface IAdapterObservatoryBuilder<Type extends IFeature<?, ?>> extends IObservatory.IBuilder
{
	<Listener> IAdapterObservatoryBuilder<Type> listen(Listener listener, IFeature<? super Listener, Type> feature);
	IAdapterObservatoryBuilder<Type> listenNoParam(Runnable listener, IFeature<?, Type> feature);
}
