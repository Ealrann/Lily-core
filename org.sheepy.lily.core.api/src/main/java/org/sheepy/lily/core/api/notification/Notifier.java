package org.sheepy.lily.core.api.notification;

import org.sheepy.lily.core.api.notification.util.ListenerMap;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public class Notifier<F extends IFeature<?>> implements INotifier.Internal<F>
{
	private final ListenerMap<F> listenerMap;

	public Notifier(int featureCount)
	{
		listenerMap = new ListenerMap<>(featureCount);
	}

	@Override
	public <T> void listen(final Consumer<? super T> listener, final Feature<T, ? extends F> feature)
	{
		listenerMap.listen(listener, feature);
	}

	@Override
	public void listen(final IntConsumer listener, final IntFeature<? extends F> feature)
	{
		listenerMap.listen(listener, feature);
	}

	@Override
	public void listen(final LongConsumer listener, final LongFeature<? extends F> feature)
	{
		listenerMap.listen(listener, feature);
	}

	@Override
	public <T> void sulk(final Consumer<? super T> listener, final Feature<T, ? extends F> feature)
	{
		listenerMap.sulk(listener, feature);
	}

	@Override
	public void sulk(final IntConsumer listener, final IntFeature<? extends F> feature)
	{
		listenerMap.sulk(listener, feature);
	}

	@Override
	public void sulk(final LongConsumer listener, final LongFeature<? extends F> feature)
	{
		listenerMap.sulk(listener, feature);
	}

	@Override
	public <T> void notify(final Feature<T, ? extends F> feature, final T value)
	{
		listenerMap.notify(feature, value);
	}

	@Override
	public void notify(final IntFeature<? extends F> feature, final int value)
	{
		listenerMap.notify(feature, value);
	}

	@Override
	public void notify(final LongFeature<? extends F> feature, final long value)
	{
		listenerMap.notify(feature, value);
	}
}
