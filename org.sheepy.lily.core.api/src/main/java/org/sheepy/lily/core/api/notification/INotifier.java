package org.sheepy.lily.core.api.notification;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public interface INotifier<F extends IFeature<?>>
{
	<T> void listen(Consumer<? super T> listener, Feature<T, ? extends F> feature);
	void listen(IntConsumer listener, IntFeature<? extends F> feature);
	void listen(LongConsumer listener, LongFeature<? extends F> feature);

	<T> void sulk(Consumer<? super T> listener, Feature<T, ? extends F> feature);
	void sulk(IntConsumer listener, IntFeature<? extends F> feature);
	void sulk(LongConsumer listener, LongFeature<? extends F> feature);

	interface Internal<F extends IFeature<?>> extends INotifier<F>
	{
		<T> void notify(Feature<T, ? extends F> feature, T value);
		void notify(IntFeature<? extends F> feature, int value);
		void notify(LongFeature<? extends F> feature, long value);
	}
}
