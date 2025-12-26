package org.sheepy.lily.core.cadence.tick.wrapper;

import org.logoce.lmf.core.lang.LMObject;
import org.sheepy.lily.core.cadence.tick.TickHandle;

public interface ITickerWrapper
{
	void accumulate(final long stepNs, final long appStepNs);
	long discharge();
	boolean shouldTick();
	TickHandle getTickHandle();
	String getLabel();
	LMObject getTarget();
	int getPriority();
	boolean isStopped();
	void stop();

	static ITickerWrapper build(final TickHandle tickHandle)
	{
		if (tickHandle.getFrequency() > 0)
		{
			return new FixedTickerWrapper(tickHandle);
		}
		else
		{
			return new DynamicTickerWrapper(tickHandle);
		}
	}
}
