package org.sheepy.lily.core.api.input.event;

import org.sheepy.lily.core.api.input.IInputManager.IInputListener;

public interface IInputEvent
{
	void fireEvent(IInputListener listener);
}
