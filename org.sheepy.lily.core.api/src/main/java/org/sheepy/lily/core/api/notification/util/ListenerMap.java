package org.sheepy.lily.core.api.notification.util;

import org.sheepy.lily.core.api.notification.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.function.Supplier;

public final class ListenerMap<F extends IFeature<?>> implements INotifier.Internal<F>
{
	private final IListenerList<?>[] listenerMap;

	public ListenerMap(int featureCount)
	{
		listenerMap = new IListenerList[featureCount];
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> void notify(Feature<T, ? extends F> feature, T value)
	{
		final var listeners = (ListenerList<T>) listenerMap[feature.ordinal()];
		if (listeners != null)
		{
			listeners.notify(value);
		}
	}

	@Override
	public void notify(IntFeature<? extends F> feature, int value)
	{
		final var listeners = (IntListenerList) listenerMap[feature.ordinal()];
		if (listeners != null)
		{
			listeners.notify(value);
		}
	}

	@Override
	public void notify(LongFeature<? extends F> feature, long value)
	{
		final var listeners = (LongListenerList) listenerMap[feature.ordinal()];
		if (listeners != null)
		{
			listeners.notify(value);
		}
	}

	@Override
	public <T> void listen(Consumer<? super T> listener, Feature<T, ? extends F> feature)
	{
		getOrCreateListenerList(feature.ordinal(), ListenerList<T>::new).add(listener);
	}

	@Override
	public void listen(IntConsumer listener, IntFeature<? extends F> feature)
	{
		getOrCreateListenerList(feature.ordinal(), IntListenerList::new).add(listener);
	}

	@Override
	public void listen(LongConsumer listener, LongFeature<? extends F> feature)
	{
		getOrCreateListenerList(feature.ordinal(), LongListenerList::new).add(listener);
	}

	@Override
	public <T> void sulk(Consumer<? super T> listener, Feature<T, ? extends F> feature)
	{
		this.<Consumer<? super T>>getListenerList(feature.ordinal()).ifPresent(list -> list.remove(listener));
	}

	@Override
	public void sulk(IntConsumer listener, IntFeature<? extends F> feature)
	{
		this.<IntConsumer>getListenerList(feature.ordinal()).ifPresent(list -> list.remove(listener));
	}

	@Override
	public void sulk(LongConsumer listener, LongFeature<? extends F> feature)
	{
		this.<LongConsumer>getListenerList(feature.ordinal()).ifPresent(list -> list.remove(listener));
	}

	private <C> IListenerList<C> getOrCreateListenerList(int ordinal, Supplier<IListenerList<C>> supplier)
	{
		return this.<C>getListenerList(ordinal).orElse(mapCreateList(ordinal, supplier));
	}

	@SuppressWarnings("unchecked")
	private <C> Optional<IListenerList<C>> getListenerList(int ordinal)
	{
		final var res = (IListenerList<C>) listenerMap[ordinal];
		if (res == null)
		{
			return Optional.empty();
		}
		else
		{
			return Optional.of(res);
		}
	}

	private <T extends IListenerList<?>> T mapCreateList(int ordinal, Supplier<T> supplier)
	{
		final var newList = supplier.get();
		listenerMap[ordinal] = newList;
		return newList;
	}

	private static abstract class IListenerList<C>
	{
		protected final List<C> listeners = new ArrayList<>(4);

		public final void add(C listener)
		{
			listeners.add(listener);
		}

		public final void remove(C listener)
		{
			listeners.remove(listener);
		}
	}

	private static final class ListenerList<T> extends IListenerList<Consumer<? super T>>
	{
		public void notify(T value)
		{
			for (int i = 0; i < listeners.size(); i++)
			{
				final var listener = listeners.get(i);
				listener.accept(value);
			}
		}
	}

	private static final class IntListenerList extends IListenerList<IntConsumer>
	{
		public void notify(int value)
		{
			for (int i = 0; i < listeners.size(); i++)
			{
				final var listener = listeners.get(i);
				listener.accept(value);
			}
		}
	}

	private static final class LongListenerList extends IListenerList<LongConsumer>
	{
		public void notify(long value)
		{
			for (int i = 0; i < listeners.size(); i++)
			{
				final var listener = listeners.get(i);
				listener.accept(value);
			}
		}
	}
}
