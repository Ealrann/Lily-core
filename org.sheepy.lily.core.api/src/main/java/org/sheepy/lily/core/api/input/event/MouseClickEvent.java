package org.sheepy.lily.core.api.input.event;

import org.joml.Vector2fc;
import org.sheepy.lily.core.api.input.IInputManager;
import org.sheepy.lily.core.model.types.EMouseButton;

public class MouseClickEvent extends InputEvent<MouseClickEvent>
{
	public final EMouseButton button;
	public final boolean pressed;
	public final Vector2fc mouseLocation;

	public MouseClickEvent(Vector2fc mouseLocation, EMouseButton button, boolean pressed)
	{
		super(IInputManager.Features.MouseClickEvent);
		this.mouseLocation = mouseLocation;
		this.button = button;
		this.pressed = pressed;
	}
}
