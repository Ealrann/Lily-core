package org.sheepy.lily.core.api.notification;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public interface INotifier<Type extends IFeatures<Type>>
{
	<Callback> void listen(Callback listener, Feature<? super Callback, Type> feature);
	<Callback> void listen(Callback listener, Collection<? extends Feature<? super Callback, Type>> features);
	void listenNoParam(Runnable listener, Feature<?, Type> feature);
	void listenNoParam(Runnable listener, Collection<? extends Feature<?, Type>> features);

	<Callback> void sulk(Callback listener, Feature<? super Callback, Type> feature);
	<Callback> void sulk(Callback listener, Collection<? extends Feature<? super Callback, Type>> features);
	void sulkNoParam(Runnable listener, Feature<?, Type> feature);
	void sulkNoParam(Runnable listener, Collection<? extends Feature<?, Type>> features);

	interface Internal<Type extends IFeatures<Type>> extends INotifier<Type>
	{
		<T> void notify(Feature<Consumer<T>, Type> feature, T value);
		void notify(Feature<IntConsumer, Type> feature, int value);
		void notify(Feature<LongConsumer, Type> feature, long value);
		void notify(Feature<Runnable, Type> feature);

		<Callback> void notify(Feature<? super Callback, Type> feature, Consumer<Callback> caller);
	}
}
