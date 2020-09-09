package org.sheepy.lily.core.api.notification.observatory;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;

public interface INotifierAdapterObservatoryBuilder<Type extends IFeatures<?>, Notifier extends IExtender & INotifier<?>> extends
																														  INotifierObservatoryBuilder<Type>,
																														  IAdapterObservatoryBuilder<Notifier>
{
}
