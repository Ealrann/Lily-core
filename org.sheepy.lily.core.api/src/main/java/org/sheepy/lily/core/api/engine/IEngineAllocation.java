package org.sheepy.lily.core.api.engine;

import org.logoce.extender.api.IAdapter;

public interface IEngineAllocation extends IAdapter
{
	void step();
	void waitIdle();
}
