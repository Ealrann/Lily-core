package org.sheepy.lily.core.api.engine;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.input.IInputManager;
import org.sheepy.lily.core.model.application.IEngine;

public interface IEngineAdapter extends IAdapter
{
	IInputManager getInputManager();

	static IEngineAdapter adapt(IEngine engine)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(engine, IEngineAdapter.class);
	}
}
