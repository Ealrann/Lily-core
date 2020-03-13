package org.sheepy.lily.core.api.input.event;

import org.sheepy.lily.core.api.input.IInputManager;

public class CursorLocationEvent extends InputEvent<CursorLocationEvent>
{
	public final float x;
	public final float y;

	public CursorLocationEvent(float x, float y)
	{
		super(IInputManager.Features.CursorLocationEvent);
		this.x = x;
		this.y = y;
	}
}
