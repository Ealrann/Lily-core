package org.sheepy.lily.core.api.notification;

import org.sheepy.lily.core.api.notification.util.ListenerMap;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public class Notifier<Type extends IFeature<?, ?>> implements INotifier.Internal<Type>
{
	private final ListenerMap<Type> listenerMap;

	public Notifier(int featureCount)
	{
		listenerMap = new ListenerMap<>(featureCount);
	}

	@Override
	public <Callback> void listen(final Callback listener, final IFeature<? super Callback, Type> feature)
	{
		listenerMap.listen(listener, feature);
	}

	@Override
	public <Callback> void listen(final Callback listener,
								  final Collection<? extends IFeature<? super Callback, Type>> features)
	{
		listenerMap.listen(listener, features);
	}

	@Override
	public void listenNoParam(final Runnable listener, final IFeature<?, Type> feature)
	{
		listenerMap.listenNoParam(listener, feature);
	}

	@Override
	public void listenNoParam(final Runnable listener, final Collection<? extends IFeature<?, Type>> features)
	{
		listenerMap.listenNoParam(listener, features);
	}

	@Override
	public <Callback> void sulk(final Callback listener, final IFeature<? super Callback, Type> feature)
	{
		listenerMap.sulk(listener, feature);
	}

	@Override
	public <Callback> void sulk(final Callback listener,
								final Collection<? extends IFeature<? super Callback, Type>> features)
	{
		listenerMap.sulk(listener, features);
	}

	@Override
	public void sulkNoParam(final Runnable listener, final IFeature<?, Type> feature)
	{
		listenerMap.sulkNoParam(listener, feature);
	}

	@Override
	public void sulkNoParam(final Runnable listener, final Collection<? extends IFeature<?, Type>> features)
	{
		listenerMap.sulkNoParam(listener, features);
	}

	@Override
	public <Callback> void notify(final IFeature<? super Callback, Type> feature, final Consumer<Callback> caller)
	{
		listenerMap.notify(feature, caller);
	}

	@Override
	public <T> void notify(final IFeature<Consumer<T>, Type> feature, final T value)
	{
		listenerMap.notify(feature, value);
	}

	@Override
	public void notify(final IFeature<IntConsumer, Type> feature, final int value)
	{
		listenerMap.notify(feature, value);
	}

	@Override
	public void notify(final IFeature<LongConsumer, Type> feature, final long value)
	{
		listenerMap.notify(feature, value);
	}

	@Override
	public void notify(final IFeature<Runnable, Type> feature)
	{
		listenerMap.notify(feature);
	}
}
