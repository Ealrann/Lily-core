package org.sheepy.lily.core.api.engine;

import org.sheepy.lily.core.api.input.IInputManager;

public interface IInputEngineAdapter extends IEngineAdapter
{
	IInputManager getInputManager();
}
