package org.sheepy.lily.core.api.notification;

import org.eclipse.emf.common.notify.Notification;

public interface INotificationListener
{
	void notifyChanged(Notification notification);
}
