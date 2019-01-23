package org.sheepy.lily.core.api.input.event;

public class MouseLocationEvent implements IInputEvent
{
	public final float x;
	public final float y;

	public MouseLocationEvent(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
}
