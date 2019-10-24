package org.sheepy.lily.core.adapter;

import org.sheepy.lily.core.api.cadence.ETickerClock;

public interface ITickDescriptor
{
	void tick(long stepNs);

	double getFrequency();
	int getPriority();
	ETickerClock getClock();
	String getName();
}
