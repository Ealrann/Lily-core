package org.sheepy.lily.core.api.input.event;

import org.sheepy.lily.core.api.input.IInputManager;
import org.sheepy.lily.core.api.notification.INotifier;

public class CursorLocationEvent implements IInputEvent
{
	public final float x;
	public final float y;

	public CursorLocationEvent(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public void notify(final INotifier.Internal<IInputFeature> notifier)
	{
		notifier.notify(IInputManager.Features.CursorLocationEvent, this);
	}
}
