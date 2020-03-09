package org.sheepy.lily.core.api.adapter;

import org.sheepy.lily.core.api.notification.IFeature;
import org.sheepy.lily.core.api.notification.INotifier;

public interface INotifierAdapter<F extends IFeature<?>> extends IAdapter, INotifier<F>
{
}
