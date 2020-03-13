package org.sheepy.lily.core.api.notification.observatory.internal.notifier;

import org.sheepy.lily.core.api.notification.IFeature;
import org.sheepy.lily.core.api.notification.INotifier;

public interface INotifierPOI<T extends IFeature<?, ?>>
{
	void listen(INotifier<T> notifier);
	void sulk(INotifier<T> notifier);
}
