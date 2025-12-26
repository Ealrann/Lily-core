package org.sheepy.lily.core.api.input;

import org.joml.Vector2fc;
import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.api.util.ModelUtil;
import org.logoce.lmf.core.api.notification.IFeature;
import org.logoce.lmf.core.api.notification.IFeatures;
import org.logoce.lmf.core.api.notification.INotifier;
import org.sheepy.lily.core.api.input.event.*;
import org.sheepy.lily.core.model.application.Application;

import java.util.function.Consumer;

public interface IInputManager extends INotifier<IInputManager.Features>, IAdapter
{
	static IInputManager get(IFeaturedObject from)
	{
		if (!(from instanceof LMObject lmObject)) return null;

		final LMObject root = ModelUtil.root(lmObject);
		if (root instanceof Application application)
		{
			return application.adapt(IInputManager.class);
		}
		return null;
	}

	interface Features extends IFeatures<Features>
	{
		IFeature<Consumer<CharEvent>, Features> CharEvent = IFeature.newFeature();
		IFeature<Consumer<KeyEvent>, Features> KeyEvent = IFeature.newFeature();
		IFeature<Consumer<MouseClickEvent>, Features> MouseClickEvent = IFeature.newFeature();
		IFeature<Consumer<CursorLocationEvent>, Features> CursorLocationEvent = IFeature.newFeature();
		IFeature<Consumer<ScrollEvent>, Features> ScrollEvent = IFeature.newFeature();
		IFeature<Consumer<Boolean>, Features> MouseOverUIEvent = IFeature.newFeature();
		IFeature<Runnable, Features> AfterPollInputs = IFeature.newFeature();
	}

	void showCursor(boolean show);
	boolean isMouseOnUI();

	Vector2fc getCursorPosition();
	void setCursorPosition(Vector2fc position);

	void pollInputs();
}
