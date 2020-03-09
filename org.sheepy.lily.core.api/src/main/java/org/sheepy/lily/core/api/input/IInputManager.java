package org.sheepy.lily.core.api.input;

import org.joml.Vector2fc;
import org.sheepy.lily.core.api.input.event.*;
import org.sheepy.lily.core.api.notification.INotifier;

public interface IInputManager extends INotifier<IInputFeature>
{
	interface Features
	{
		int COUNT = 7;

		IInputFeature.InputFeature<CharEvent> CharEvent = new IInputFeature.InputFeature<>(0);
		IInputFeature.InputFeature<KeyEvent> KeyEvent = new IInputFeature.InputFeature<>(1);
		IInputFeature.InputFeature<MouseClickEvent> MouseClickEvent = new IInputFeature.InputFeature<>(2);
		IInputFeature.InputFeature<CursorLocationEvent> CursorLocationEvent = new IInputFeature.InputFeature<>(3);
		IInputFeature.InputFeature<ScrollEvent> ScrollEvent = new IInputFeature.InputFeature<>(4);
		IInputFeature.InputFeature<Boolean> MouseOverUIEvent = new IInputFeature.InputFeature<>(5);
		IInputFeature.InputFeature<Void> AfterPollInputs = new IInputFeature.InputFeature<>(6);
	}

	void showCursor(boolean show);
	boolean isMouseOnUI();

	Vector2fc getCursorPosition();
	void setCursorPosition(Vector2fc position);

	void pollInputs();
}
