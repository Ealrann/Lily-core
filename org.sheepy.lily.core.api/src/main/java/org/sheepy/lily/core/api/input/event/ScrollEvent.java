package org.sheepy.lily.core.api.input.event;

import org.sheepy.lily.core.api.input.IInputManager.IInputListener;

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
	public void fireEvent(IInputListener listener)
	{
		listener.onScrollEvent(this);
	}
}
