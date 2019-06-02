package org.sheepy.lily.core.api.input.event;

import org.sheepy.lily.core.api.input.IInputManager.IInputListener;

public class CharEvent implements IInputEvent
{
	public final int codepoint;

	public CharEvent(int codepoint)
	{
		this.codepoint = codepoint;
	}

	@Override
	public void fireEvent(IInputListener listener)
	{
		listener.onCharEvent(this);
	}
}
