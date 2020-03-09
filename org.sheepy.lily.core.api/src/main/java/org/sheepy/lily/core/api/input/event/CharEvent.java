package org.sheepy.lily.core.api.input.event;

import org.sheepy.lily.core.api.input.IInputManager;
import org.sheepy.lily.core.api.notification.INotifier;

public class CharEvent implements IInputEvent
{
	public final int codepoint;

	public CharEvent(int codepoint)
	{
		this.codepoint = codepoint;
	}

	@Override
	public void notify(final INotifier.Internal<IInputFeature> notifier)
	{
		notifier.notify(IInputManager.Features.CharEvent, this);
	}
}
