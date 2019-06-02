package org.sheepy.lily.core.api.input.event;

import org.joml.Vector2fc;
import org.sheepy.lily.core.api.input.IInputManager.IInputListener;
import org.sheepy.lily.core.model.types.EMouseButton;

public class MouseButtonEvent implements IInputEvent
{
	public final EMouseButton button;
	public final boolean pressed;
	public final Vector2fc mouseLocation;

	public MouseButtonEvent(Vector2fc mouseLocation, EMouseButton button, boolean pressed)
	{
		this.mouseLocation = mouseLocation;
		this.button = button;
		this.pressed = pressed;
	}

	@Override
	public void fireEvent(IInputListener listener)
	{
		listener.onMouseClickEvent(this);
	}
}
