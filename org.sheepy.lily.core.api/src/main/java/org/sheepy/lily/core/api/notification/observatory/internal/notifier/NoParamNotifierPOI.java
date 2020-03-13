package org.sheepy.lily.core.api.notification.observatory.internal.notifier;

import org.sheepy.lily.core.api.notification.IFeature;
import org.sheepy.lily.core.api.notification.INotifier;

public final class NoParamNotifierPOI<Type extends IFeature<?, ?>> implements INotifierPOI<Type>
{
	private final Runnable listener;
	private final IFeature<?, Type> feature;

	public NoParamNotifierPOI(Runnable listener, IFeature<?, Type> feature)
	{
		this.listener = listener;
		this.feature = feature;
	}

	@Override
	public void listen(INotifier<Type> notifier)
	{
		notifier.listenNoParam(listener, feature);
	}

	@Override
	public void sulk(INotifier<Type> notifier)
	{
		notifier.sulkNoParam(listener, feature);
	}
}
