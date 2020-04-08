package org.sheepy.lily.core.api.notification.util;

import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public final class ListenerMap<Type extends IFeatures<Type>> implements INotifier.Internal<Type>
{
	private final List<Object>[] listenerMap;
	private final List<Feature<?, Type>> features;

	@SuppressWarnings("unchecked")
	public ListenerMap(List<Feature<?, Type>> features)
	{
		this.listenerMap = new List[features.size()];
		this.features = features;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <Callback> void notify(final Feature<? super Callback, Type> feature, final Consumer<Callback> caller)
	{
		final var list = listenerMap[features.indexOf(feature)];
		if (list != null)
		{
			for (int i = 0; i < list.size(); i++)
			{
				final var listener = list.get(i);
				if (listener instanceof Runnable)
				{
					((Runnable) listener).run();
				}
				else
				{
					caller.accept((Callback) listener);
				}
			}
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> void notify(final Feature<Consumer<T>, Type> feature, final T value)
	{
		final var list = listenerMap[features.indexOf(feature)];
		if (list != null)
		{
			for (int i = 0; i < list.size(); i++)
			{
				final var listener = list.get(i);
				if (listener instanceof Runnable)
				{
					((Runnable) listener).run();
				}
				else
				{
					((Consumer<? super T>) listener).accept(value);
				}
			}
		}
	}

	@Override
	public void notify(final Feature<IntConsumer, Type> feature, final int value)
	{
		final var list = listenerMap[features.indexOf(feature)];
		if (list != null)
		{
			for (int i = 0; i < list.size(); i++)
			{
				final var listener = list.get(i);
				if (listener instanceof Runnable)
				{
					((Runnable) listener).run();
				}
				else
				{
					((IntConsumer) listener).accept(value);
				}
			}
		}
	}

	@Override
	public void notify(final Feature<LongConsumer, Type> feature, final long value)
	{
		final var list = listenerMap[features.indexOf(feature)];
		if (list != null)
		{
			for (int i = 0; i < list.size(); i++)
			{
				final var listener = list.get(i);
				if (listener instanceof Runnable)
				{
					((Runnable) listener).run();
				}
				else
				{
					((LongConsumer) listener).accept(value);
				}
			}
		}
	}

	@Override
	public void notify(final Feature<Runnable, Type> feature)
	{
		final var list = listenerMap[features.indexOf(feature)];
		if (list != null)
		{
			for (int i = 0; i < list.size(); i++)
			{
				final var listener = list.get(i);
				((Runnable) listener).run();
			}
		}
	}

	@Override
	public <Callback> void listen(Callback listener, Feature<? super Callback, Type> feature)
	{
		getOrCreateList(feature).add(listener);
	}

	@Override
	public void listenNoParam(Runnable listener, Feature<?, Type> feature)
	{
		getOrCreateList(feature).add(listener);
	}

	@Override
	public <Callback> void listen(Callback listener, Collection<? extends Feature<? super Callback, Type>> features)
	{
		for (var feature : features)
		{
			listen(listener, feature);
		}
	}

	@Override
	public void listenNoParam(Runnable listener, Collection<? extends Feature<?, Type>> features)
	{
		for (var feature : features)
		{
			listenNoParam(listener, feature);
		}
	}

	@Override
	public <Callback> void sulk(Callback listener, Feature<? super Callback, Type> feature)
	{
		getList(feature).ifPresent(list -> list.remove(listener));
	}

	@Override
	public void sulkNoParam(Runnable listener, Feature<?, Type> feature)
	{
		getList(feature).ifPresent(list -> list.remove(listener));
	}

	@Override
	public <Callback> void sulk(Callback listener, Collection<? extends Feature<? super Callback, Type>> features)
	{
		for (var feature : features)
		{
			sulk(listener, feature);
		}
	}

	@Override
	public void sulkNoParam(Runnable listener, Collection<? extends Feature<?, Type>> features)
	{
		for (var feature : features)
		{
			sulkNoParam(listener, feature);
		}
	}

	private List<Object> getOrCreateList(Feature<?, Type> feature)
	{
		final int ordinal = features.indexOf(feature);
		final var res = listenerMap[ordinal];
		if (res != null)
		{
			return res;
		}
		else
		{
			final var newList = new ArrayList<>();
			listenerMap[ordinal] = newList;
			return newList;
		}
	}

	private Optional<List<Object>> getList(Feature<?, Type> feature)
	{
		final int ordinal = features.indexOf(feature);
		final var res = listenerMap[ordinal];
		if (res != null)
		{
			return Optional.of(res);
		}
		else
		{
			return Optional.empty();
		}
	}
}
