package org.sheepy.lily.core.api.adapter;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;

public interface INotifierAdapter<Type extends IFeatures<Type>> extends INotifier<Type>, IExtender
{
}
