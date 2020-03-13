package org.sheepy.lily.core.api.notification.observatory.internal.notifier;

import org.sheepy.lily.core.api.notification.IFeature;
import org.sheepy.lily.core.api.notification.INotifier;

public final class NotifierPOI<Callback, Type extends IFeature<?, ?>> implements INotifierPOI<Type>
{
	private final Callback listener;
	private final IFeature<Callback, Type> feature;

	public NotifierPOI(Callback listener, IFeature<Callback, Type> feature)
	{
		this.listener = listener;
		this.feature = feature;
	}

	@Override
	public void listen(INotifier<Type> notifier)
	{
		notifier.listen(listener, feature);
	}

	@Override
	public void sulk(INotifier<Type> notifier)
	{
		notifier.sulk(listener, feature);
	}
}
