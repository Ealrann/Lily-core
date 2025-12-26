package org.sheepy.lily.core.cadence.tick.wrapper;

import org.sheepy.lily.core.cadence.tick.TickHandle;

public final class DynamicTickerWrapper extends AbstractTickerWrapper
{
	public DynamicTickerWrapper(final TickHandle tickHandle)
	{
		super(tickHandle);
	}

	@Override
	public long discharge()
	{
		final var discharged = accumulator;
		accumulator = 0;
		return discharged;
	}

	@Override
	public boolean shouldTick()
	{
		return accumulator > 0;
	}
}
