package org.sheepy.lily.core.api.input.event;

import org.sheepy.lily.core.api.input.IInputManager.IInputListener;

public class MouseLocationEvent implements IInputEvent
{
	public final float x;
	public final float y;

	public MouseLocationEvent(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public void fireEvent(IInputListener listener)
	{
		listener.onMouseLocationEvent(this);
	}
}
