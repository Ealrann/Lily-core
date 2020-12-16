package org.sheepy.lily.core.api.input.event;

import org.sheepy.lily.core.api.input.IInputManager;
import org.logoce.notification.api.Feature;
import org.logoce.notification.api.INotifier;

import java.util.function.Consumer;

public abstract class InputEvent<T extends InputEvent<T>>
{
	private final Feature<Consumer<T>, IInputManager.Features> feature;

	public InputEvent(Feature<Consumer<T>, IInputManager.Features> feature)
	{
		this.feature = feature;
	}

	@SuppressWarnings("unchecked")
	public final void notify(INotifier.Internal<IInputManager.Features> notifier)
	{
		notifier.notify(feature, (T) this);
	}
}
