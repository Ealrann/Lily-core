package org.sheepy.lily.core.api.input;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.joml.Vector2fc;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.input.event.*;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.logoce.notification.api.Feature;
import org.logoce.notification.api.IFeatures;
import org.logoce.notification.api.INotifier;
import org.sheepy.lily.core.model.application.Application;

import java.util.function.Consumer;

public interface IInputManager extends INotifier<IInputManager.Features>, IExtender
{
	static IInputManager get(ILilyEObject from)
	{
		final var application = (Application) EcoreUtil.getRootContainer(from);
		return application.adapt(IInputManager.class);
	}

	interface Features extends IFeatures<Features>
	{
		Feature<Consumer<CharEvent>, Features> CharEvent = Feature.newFeature();
		Feature<Consumer<KeyEvent>, Features> KeyEvent = Feature.newFeature();
		Feature<Consumer<MouseClickEvent>, Features> MouseClickEvent = Feature.newFeature();
		Feature<Consumer<CursorLocationEvent>, Features> CursorLocationEvent = Feature.newFeature();
		Feature<Consumer<ScrollEvent>, Features> ScrollEvent = Feature.newFeature();
		Feature<Consumer<Boolean>, Features> MouseOverUIEvent = Feature.newFeature();
		Feature<Runnable, Features> AfterPollInputs = Feature.newFeature();
	}

	void showCursor(boolean show);
	boolean isMouseOnUI();

	Vector2fc getCursorPosition();
	void setCursorPosition(Vector2fc position);

	void pollInputs();
}
