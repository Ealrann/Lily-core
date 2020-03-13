package org.sheepy.lily.core.api.input;

import org.joml.Vector2fc;
import org.sheepy.lily.core.api.input.event.*;
import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeature;
import org.sheepy.lily.core.api.notification.INotifier;

import java.util.function.Consumer;

public interface IInputManager extends INotifier<IInputManager.Features<?>>
{
	interface Features<T> extends IFeature<T, Features<?>>
	{
		int COUNT = 7;

		Features<Consumer<CharEvent>> CharEvent = new InputObjectFeature<>(0);
		Features<Consumer<KeyEvent>> KeyEvent = new InputObjectFeature<>(1);
		Features<Consumer<MouseClickEvent>> MouseClickEvent = new InputObjectFeature<>(2);
		Features<Consumer<CursorLocationEvent>> CursorLocationEvent = new InputObjectFeature<>(3);
		Features<Consumer<ScrollEvent>> ScrollEvent = new InputObjectFeature<>(4);
		Features<Consumer<Boolean>> MouseOverUIEvent = new InputObjectFeature<>(5);
		Features<Runnable> AfterPollInputs = new InputFeature(6);

		final class InputObjectFeature<T> extends Feature<Consumer<T>, IInputManager.Features<?>> implements Features<Consumer<T>>
		{
			public InputObjectFeature(final int ordinal)
			{
				super(ordinal);
			}
		}

		final class InputFeature extends Feature<Runnable, IInputManager.Features<?>> implements Features<Runnable>
		{
			public InputFeature(final int ordinal)
			{
				super(ordinal);
			}
		}
	}

	void showCursor(boolean show);
	boolean isMouseOnUI();

	Vector2fc getCursorPosition();
	void setCursorPosition(Vector2fc position);

	void pollInputs();
}
