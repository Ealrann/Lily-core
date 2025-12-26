package org.sheepy.lily.core.api.input.event;

import org.sheepy.lily.core.api.input.IInputManager;

public final class CharEvent extends InputEvent<CharEvent>
{
	public final int codepoint;

	public CharEvent(int codepoint)
	{
		super(IInputManager.Features.CharEvent);
		this.codepoint = codepoint;
	}
}
