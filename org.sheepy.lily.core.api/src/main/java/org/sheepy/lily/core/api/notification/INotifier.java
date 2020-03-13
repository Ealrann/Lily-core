package org.sheepy.lily.core.api.notification;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public interface INotifier<Type extends IFeature<?, ?>>
{
	<Callback> void listen(Callback listener, IFeature<? super Callback, Type> feature);
	<Callback> void listen(Callback listener, Collection<? extends IFeature<? super Callback, Type>> features);
	void listenNoParam(Runnable listener, IFeature<?, Type> feature);
	void listenNoParam(Runnable listener, Collection<? extends IFeature<?, Type>> features);

	<Callback> void sulk(Callback listener, IFeature<? super Callback, Type> feature);
	<Callback> void sulk(Callback listener, Collection<? extends IFeature<? super Callback, Type>> features);
	void sulkNoParam(Runnable listener, IFeature<?, Type> feature);
	void sulkNoParam(Runnable listener, Collection<? extends IFeature<?, Type>> features);

	interface Internal<Type extends IFeature<?, ?>> extends INotifier<Type>
	{
		<T> void notify(IFeature<Consumer<T>, Type> feature, T value);
		void notify(IFeature<IntConsumer, Type> feature, int value);
		void notify(IFeature<LongConsumer, Type> feature, long value);
		void notify(IFeature<Runnable, Type> feature);

		<Callback> void notify(IFeature<? super Callback, Type> feature, Consumer<Callback> caller);
	}
}
