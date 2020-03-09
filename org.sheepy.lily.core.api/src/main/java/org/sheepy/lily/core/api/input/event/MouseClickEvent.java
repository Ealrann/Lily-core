package org.sheepy.lily.core.api.input.event;

import org.joml.Vector2fc;
import org.sheepy.lily.core.api.input.IInputManager;
import org.sheepy.lily.core.api.notification.INotifier;
import org.sheepy.lily.core.model.types.EMouseButton;

public class MouseClickEvent implements IInputEvent
{
	public final EMouseButton button;
	public final boolean pressed;
	public final Vector2fc mouseLocation;

	public MouseClickEvent(Vector2fc mouseLocation, EMouseButton button, boolean pressed)
	{
		this.mouseLocation = mouseLocation;
		this.button = button;
		this.pressed = pressed;
	}

	@Override
	public void notify(final INotifier.Internal<IInputFeature> notifier)
	{
		notifier.notify(IInputManager.Features.MouseClickEvent, this);
	}
}
