package org.sheepy.lily.core.api.input.event;

import org.sheepy.lily.core.model.types.EMouseButton;

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
