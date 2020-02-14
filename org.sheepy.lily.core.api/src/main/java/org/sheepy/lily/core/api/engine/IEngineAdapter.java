package org.sheepy.lily.core.api.engine;

import org.sheepy.lily.core.api.adapter.IAdapter;

public interface IEngineAdapter extends IAdapter
{
	void start();
	void stop();
	
	void step();
}
