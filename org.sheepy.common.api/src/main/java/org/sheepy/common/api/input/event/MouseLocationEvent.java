package org.sheepy.common.api.input.event;

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
