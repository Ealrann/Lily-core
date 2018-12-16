package org.sheepy.common.api.input.event;

import org.sheepy.common.model.types.EMouseButton;

public class MouseButtonEvent implements IInputEvent
{
	public final EMouseButton button;
	public final boolean pressed;

	public MouseButtonEvent(EMouseButton button, boolean pressed)
	{
		this.button = button;
		this.pressed = pressed;
	}
}
