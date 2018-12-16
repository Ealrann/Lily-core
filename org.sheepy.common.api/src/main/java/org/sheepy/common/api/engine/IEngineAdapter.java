package org.sheepy.common.api.engine;

import org.sheepy.common.api.adapter.IAdapter;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.input.IInputManager;
import org.sheepy.common.model.application.IEngine;

public interface IEngineAdapter extends IAdapter
{
	IInputManager getInputManager();

	static IEngineAdapter adapt(IEngine engine)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(engine, IEngineAdapter.class);
	}
}
