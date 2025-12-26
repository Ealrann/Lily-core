package org.sheepy.lily.core.cadence.tick.wrapper;

import org.sheepy.lily.core.cadence.tick.TickHandle;

public final class FixedTickerWrapper extends AbstractTickerWrapper
{
	private final long tickerStep;

	public FixedTickerWrapper(final TickHandle tickHandle)
	{
		super(tickHandle);

		final var frequency = tickHandle.getFrequency();
		assert frequency > 0;

		tickerStep = (long) (1e9 / frequency);
	}

	@Override
	public long discharge()
	{
		accumulator -= tickerStep;
		return tickerStep;
	}

	@Override
	public boolean shouldTick()
	{
		return accumulator >= tickerStep;
	}
}
