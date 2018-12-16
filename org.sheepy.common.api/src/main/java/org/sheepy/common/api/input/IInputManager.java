package org.sheepy.common.api.input;

import java.util.EventListener;
import java.util.ServiceLoader;

import org.sheepy.common.api.service.IService;
import org.sheepy.common.api.types.SVector2f;
import org.sheepy.common.model.types.EMouseButton;

public interface IInputManager extends IService
{
	SVector2f getMouseLocation();

	void addMouseListener(IMouseListener listener);
	void removeMouseListener(IMouseListener listener);
	
	void pollInputs();

	interface IMouseListener extends EventListener
	{
		void onMouseClick(SVector2f location, MouseEvent event);
	}

	static class MouseEvent
	{
		public final EMouseButton button;
		public final boolean pressed;

		public MouseEvent(EMouseButton button, boolean pressed)
		{
			this.button = button;
			this.pressed = pressed;
		}
	}

	static IInputManager INSTANCE = ServiceLoader.load(IInputManager.class).findFirst()
			.orElseGet(() -> null);
}
