package org.sheepy.lily.core.api.input.event;

import org.sheepy.lily.core.api.input.IInputManager;
import org.sheepy.lily.core.api.notification.INotifier;

import java.util.function.Consumer;

public abstract class InputEvent<T extends InputEvent<T>>
{
	private final IInputManager.Features<Consumer<T>> feature;

	public InputEvent(IInputManager.Features<Consumer<T>> feature)
	{
		this.feature = feature;
	}

	@SuppressWarnings("unchecked")
	public final void notify(INotifier.Internal<IInputManager.Features<?>> notifier)
	{
		notifier.notify(feature, (T) this);
	}
}
