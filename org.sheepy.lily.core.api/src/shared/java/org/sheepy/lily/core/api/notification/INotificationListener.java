package org.sheepy.lily.core.api.notification;

import org.eclipse.emf.common.notify.Notification;

import java.util.function.Consumer;

@Deprecated
@FunctionalInterface
public interface INotificationListener extends Consumer<Notification>
{
}
