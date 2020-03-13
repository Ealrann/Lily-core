package org.sheepy.lily.core.api.input.event;

import org.sheepy.lily.core.api.input.IInputManager;
import org.sheepy.lily.core.model.types.EKeyState;

public class KeyEvent extends InputEvent<KeyEvent>
{
	public final int key;
	public final EKeyState state;
	public final int mode;

	public KeyEvent(int key, EKeyState state, int mode)
	{
		super(IInputManager.Features.KeyEvent);
		this.key = key;
		this.state = state;
		this.mode = mode;
	}
}
