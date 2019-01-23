package org.sheepy.lily.core.api.input.event;

public class CharEvent implements IInputEvent
{
	public final int codepoint;

	public CharEvent(int codepoint)
	{
		this.codepoint = codepoint;
	}
}