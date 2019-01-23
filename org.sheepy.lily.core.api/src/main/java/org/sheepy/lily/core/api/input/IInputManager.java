package org.sheepy.lily.core.api.input;

import java.util.EventListener;

import org.sheepy.lily.core.api.input.event.CharEvent;
import org.sheepy.lily.core.api.input.event.KeyEvent;
import org.sheepy.lily.core.api.input.event.MouseButtonEvent;
import org.sheepy.lily.core.api.input.event.MouseLocationEvent;
import org.sheepy.lily.core.api.input.event.ScrollEvent;
import org.sheepy.lily.core.api.types.SVector2f;

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
