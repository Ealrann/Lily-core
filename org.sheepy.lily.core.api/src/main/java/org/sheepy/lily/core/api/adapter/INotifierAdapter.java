package org.sheepy.lily.core.api.adapter;

import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;

@Statefull
public interface INotifierAdapter<Type extends IFeatures<Type>> extends IAdapter, INotifier<Type>
{
}
