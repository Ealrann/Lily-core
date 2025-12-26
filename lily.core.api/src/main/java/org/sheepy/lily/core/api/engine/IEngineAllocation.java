package org.sheepy.lily.core.api.engine;

import org.logoce.lmf.core.api.extender.IAdapter;

public interface IEngineAllocation extends IAdapter
{
	void step();
	void waitIdle();
}
