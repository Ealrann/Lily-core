package org.sheepy.lily.core.api.notification;

import org.sheepy.lily.core.api.notification.util.ListenerMap;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public class Notifier<Type extends IFeatures<Type>> implements INotifier.Internal<Type>
{
	private final ListenerMap<Type> listenerMap;

	public Notifier(List<Feature<?, Type>> features)
	{
		listenerMap = new ListenerMap<>(features);
	}

	@Override
	public <Callback> void listen(final Callback listener, final Feature<? super Callback, Type> feature)
	{
		listenerMap.listen(listener, feature);
	}

	@Override
	public <Callback> void listen(final Callback listener,
								  final Collection<? extends Feature<? super Callback, Type>> features)
	{
		listenerMap.listen(listener, features);
	}

	@Override
	public void listenNoParam(final Runnable listener, final Feature<?, Type> feature)
	{
		listenerMap.listenNoParam(listener, feature);
	}

	@Override
	public void listenNoParam(final Runnable listener, final Collection<? extends Feature<?, Type>> features)
	{
		listenerMap.listenNoParam(listener, features);
	}

	@Override
	public <Callback> void sulk(final Callback listener, final Feature<? super Callback, Type> feature)
	{
		listenerMap.sulk(listener, feature);
	}

	@Override
	public <Callback> void sulk(final Callback listener,
								final Collection<? extends Feature<? super Callback, Type>> features)
	{
		listenerMap.sulk(listener, features);
	}

	@Override
	public void sulkNoParam(final Runnable listener, final Feature<?, Type> feature)
	{
		listenerMap.sulkNoParam(listener, feature);
	}

	@Override
	public void sulkNoParam(final Runnable listener, final Collection<? extends Feature<?, Type>> features)
	{
		listenerMap.sulkNoParam(listener, features);
	}

	@Override
	public <Callback> void notify(final Feature<? super Callback, Type> feature, final Consumer<Callback> caller)
	{
		listenerMap.notify(feature, caller);
	}

	@Override
	public <T> void notify(final Feature<Consumer<T>, Type> feature, final T value)
	{
		listenerMap.notify(feature, value);
	}

	@Override
	public void notify(final Feature<IntConsumer, Type> feature, final int value)
	{
		listenerMap.notify(feature, value);
	}

	@Override
	public void notify(final Feature<LongConsumer, Type> feature, final long value)
	{
		listenerMap.notify(feature, value);
	}

	@Override
	public void notify(final Feature<Runnable, Type> feature)
	{
		listenerMap.notify(feature);
	}
}
