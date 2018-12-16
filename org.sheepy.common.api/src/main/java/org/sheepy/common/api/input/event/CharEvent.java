package org.sheepy.common.api.input.event;

public class CharEvent implements IInputEvent
{
	public final int codepoint;

	public CharEvent(int codepoint)
	{
		this.codepoint = codepoint;
	}
}