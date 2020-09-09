package org.sheepy.lily.core.api.notification.observatory.internal.notifier;

import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;

public final class NotifierPOI<Callback, Type extends IFeatures<?>> implements INotifierPOI<Type>
{
	private final Callback listener;
	private final Feature<Callback, ? super Type> feature;

	public NotifierPOI(final Callback listener, Feature<Callback, ? super Type> feature)
	{
		this.listener = listener;
		this.feature = feature;
	}

	@Override
	public void listen(INotifier<? extends Type> notifier)
	{
		notifier.listen(listener, feature);
	}

	@Override
	public void sulk(INotifier<? extends Type> notifier)
	{
		notifier.sulk(listener, feature);
	}
}
