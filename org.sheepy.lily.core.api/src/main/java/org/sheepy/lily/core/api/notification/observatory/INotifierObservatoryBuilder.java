package org.sheepy.lily.core.api.notification.observatory;

import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeatures;

public interface INotifierObservatoryBuilder<Type extends IFeatures<Type>> extends IObservatory.IBuilder
{
	<Listener> INotifierObservatoryBuilder<Type> listen(Listener listener, Feature<? super Listener, Type> feature);
	INotifierObservatoryBuilder<Type> listenNoParam(Runnable listener, Feature<?, Type> feature);
}
