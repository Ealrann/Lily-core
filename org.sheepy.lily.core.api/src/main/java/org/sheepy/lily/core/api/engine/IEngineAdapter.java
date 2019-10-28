package org.sheepy.lily.core.api.engine;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.input.IInputManager;

public interface IEngineAdapter extends IAdapter
{
	void start();
	void stop();

	IInputManager getInputManager();
}
