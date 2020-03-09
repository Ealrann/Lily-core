package org.sheepy.lily.core.api.input.event;

import org.sheepy.lily.core.api.notification.INotifier;

public interface IInputEvent
{
	void notify(INotifier.Internal<IInputFeature> notifier);
}
