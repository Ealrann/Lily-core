package org.sheepy.lily.core.api.engine;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.input.IInputManager;
import org.sheepy.lily.core.model.application.IEngine;

public interface IEngineAdapter extends IAdapter
{
	void start();
	void stop();

	IInputManager getInputManager();

	static IEngineAdapter adapt(IEngine engine)
	{
		return IAdapterFactoryService.INSTANCE.adapt(engine, IEngineAdapter.class);
	}
}
