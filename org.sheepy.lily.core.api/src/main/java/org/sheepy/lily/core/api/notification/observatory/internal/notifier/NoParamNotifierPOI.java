package org.sheepy.lily.core.api.notification.observatory.internal.notifier;

import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;

public final class NoParamNotifierPOI<Type extends IFeatures<Type>> implements INotifierPOI<Type>
{
	private final Runnable listener;
	private final Feature<?, Type> feature;

	public NoParamNotifierPOI(final Runnable listener, Feature<?, Type> feature)
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
