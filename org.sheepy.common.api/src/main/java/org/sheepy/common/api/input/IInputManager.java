package org.sheepy.common.api.input;

import java.util.EventListener;

import org.sheepy.common.api.input.event.CharEvent;
import org.sheepy.common.api.input.event.KeyEvent;
import org.sheepy.common.api.input.event.MouseButtonEvent;
import org.sheepy.common.api.input.event.MouseLocationEvent;
import org.sheepy.common.api.input.event.ScrollEvent;
import org.sheepy.common.api.types.SVector2f;

public interface IInputManager
{
	SVector2f getMouseLocation();

	void addListener(IInputListener listener);
	void removeListener(IInputListener listener);

	void pollInputs();

	interface IInputListener extends EventListener
	{
		default void onCharEvent(CharEvent event)
		{}

		default void onKeyEvent(KeyEvent event)
		{}

		default void onMouseClickEvent(SVector2f location, MouseButtonEvent event)
		{}

		default void onMouseLocationEvent(MouseLocationEvent event)
		{}

		default void onScrollEvent(ScrollEvent event)
		{}
	}
}
