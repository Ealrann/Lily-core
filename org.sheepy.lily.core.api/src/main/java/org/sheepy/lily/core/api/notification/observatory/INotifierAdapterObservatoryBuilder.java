package org.sheepy.lily.core.api.notification.observatory;

import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.core.api.notification.IFeatures;

public interface INotifierAdapterObservatoryBuilder<Type extends IFeatures<Type>, Notifier extends INotifierAdapter<Type>> extends
																																INotifierObservatoryBuilder<Type>,
																																IAdapterObservatoryBuilder<Notifier>
{
}
