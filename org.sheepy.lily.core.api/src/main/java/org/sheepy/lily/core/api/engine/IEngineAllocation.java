package org.sheepy.lily.core.api.engine;

import org.sheepy.lily.core.api.extender.IExtender;

public interface IEngineAllocation extends IExtender
{
	void step();
	void waitIdle();
}
