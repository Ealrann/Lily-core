package org.sheepy.lily.core.api.input.event;

import org.sheepy.lily.core.api.input.IInputManager;

public class ScrollEvent extends InputEvent<ScrollEvent>
{
	public final float xOffset;
	public final float yOffset;

	public ScrollEvent(float xOffset, float yOffset)
	{
		super(IInputManager.Features.ScrollEvent);
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
