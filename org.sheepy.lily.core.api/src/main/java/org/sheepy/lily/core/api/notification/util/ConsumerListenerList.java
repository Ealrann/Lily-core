package org.sheepy.lily.core.api.notification.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class ConsumerListenerList<Type>
{
	private final List<Object> listeners = new ArrayList<>();

	@SuppressWarnings("unchecked")
	public void notify(final Type value)
	{
		for (int i = 0; i < listeners.size(); i++)
		{
			final var listener = listeners.get(i);
			if (listener instanceof Runnable runner)
			{
				runner.run();
			}
			else
			{
				((Consumer<? super Type>) listener).accept(value);
			}
		}
	}

	public void listen(Consumer<? super Type> listener)
	{
		listeners.add(listener);
	}

	public void listenNoParam(Runnable listener)
	{
		listeners.add(listener);
	}

	public void sulk(Consumer<? super Type> listener)
	{
		listeners.remove(listener);
	}

	public void sulkNoParam(Runnable listener)
	{
		listeners.remove(listener);
	}
}
