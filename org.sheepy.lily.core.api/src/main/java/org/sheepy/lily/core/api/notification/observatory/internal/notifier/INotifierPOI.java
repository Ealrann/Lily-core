package org.sheepy.lily.core.api.notification.observatory.internal.notifier;

import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;

public interface INotifierPOI<T extends IFeatures<T>>
{
	void listen(INotifier<T> notifier);
	void sulk(INotifier<T> notifier);
}
