package org.sheepy.lily.core.api.adapter;

import org.eclipse.emf.common.notify.Notification;

@FunctionalInterface
public interface INotificationListener
{
	void notifyChanged(Notification notification);
}
