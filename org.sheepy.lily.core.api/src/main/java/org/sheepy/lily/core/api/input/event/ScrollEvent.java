package org.sheepy.lily.core.api.input.event;

import org.sheepy.lily.core.api.input.IInputManager;
import org.sheepy.lily.core.api.notification.INotifier;

public class ScrollEvent implements IInputEvent
{
	public final float xOffset;
	public final float yOffset;

	public ScrollEvent(float xOffset, float yOffset)
	{
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	@Override
	public void notify(final INotifier.Internal<IInputFeature> notifier)
	{
		notifier.notify(IInputManager.Features.ScrollEvent, this);
	}
}
