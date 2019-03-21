package org.sheepy.lily.core.api.input;

import java.util.EventListener;

import org.joml.Vector2f;
import org.sheepy.lily.core.api.input.event.CharEvent;
import org.sheepy.lily.core.api.input.event.KeyEvent;
import org.sheepy.lily.core.api.input.event.MouseButtonEvent;
import org.sheepy.lily.core.api.input.event.MouseLocationEvent;
import org.sheepy.lily.core.api.input.event.ScrollEvent;

public interface IInputManager
{

	void showCursor(boolean show);

	Vector2f getCursorPosition();
	void setCursorPosition(Vector2f position);

	void addListener(IInputListener listener);
	void removeListener(IInputListener listener);

	void pollInputs();

	interface IInputListener extends EventListener
	{
		default void onCharEvent(CharEvent event)
		{}

		default void onKeyEvent(KeyEvent event)
		{}

		default void onMouseClickEvent(Vector2f location, MouseButtonEvent event)
		{}

		default void onMouseLocationEvent(MouseLocationEvent event)
		{}

		default void onScrollEvent(ScrollEvent event)
		{}
	}

}
