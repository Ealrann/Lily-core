package org.sheepy.lily.core.api.notification.observatory;

import org.sheepy.lily.core.api.notification.IFeature;

public interface INotifierObservatoryBuilder<Feature extends IFeature<?, ?>> extends IObservatory.IBuilder
{
	<Listener> INotifierObservatoryBuilder<Feature> listen(Listener listener, IFeature<? super Listener, Feature> feature);
	INotifierObservatoryBuilder<Feature> listenNoParam(Runnable listener, IFeature<?, Feature> feature);
}
