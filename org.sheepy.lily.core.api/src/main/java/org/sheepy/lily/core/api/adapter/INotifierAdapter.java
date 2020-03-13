package org.sheepy.lily.core.api.adapter;

import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.IFeature;
import org.sheepy.lily.core.api.notification.INotifier;

@Statefull // We should only listen dedicated adapters
public interface INotifierAdapter<Type extends IFeature<?, ?>> extends IAdapter, INotifier<Type>
{
}
