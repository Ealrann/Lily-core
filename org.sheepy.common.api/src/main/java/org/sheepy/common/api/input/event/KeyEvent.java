package org.sheepy.common.api.input.event;

import org.sheepy.common.model.types.EKeyState;

public class KeyEvent implements IInputEvent
{
	public final int key;
	public final EKeyState state;
	public final int mode;

	public KeyEvent(int key, EKeyState state, int mode)
	{
		this.key = key;
		this.state = state;
		this.mode = mode;
	}
}