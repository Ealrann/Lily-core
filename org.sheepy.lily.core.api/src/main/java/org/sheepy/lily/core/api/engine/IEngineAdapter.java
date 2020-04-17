package org.sheepy.lily.core.api.engine;

import org.sheepy.lily.core.api.extender.IExtender;

public interface IEngineAdapter extends IExtender
{
	void start();
	void stop();
	
	void step();
}
