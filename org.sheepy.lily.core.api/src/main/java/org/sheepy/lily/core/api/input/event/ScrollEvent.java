package org.sheepy.lily.core.api.input.event;

public class ScrollEvent implements IInputEvent
{
	public final float xOffset;
	public final float yOffset;

	public ScrollEvent(float xOffset, float yOffset)
	{
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}