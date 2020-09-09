package org.sheepy.lily.core.api.notification.observatory;

import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeatures;

public interface INotifierObservatoryBuilder<Type extends IFeatures<?>>
{
	<Listener> INotifierObservatoryBuilder<Type> listen(Listener listener, Feature<Listener, ? super Type> feature);
	INotifierObservatoryBuilder<Type> listenNoParam(Runnable listener, Feature<?, ? super Type> feature);
}
