package org.sheepy.lily.core.cadence.common;

import org.sheepy.lily.core.api.cadence.ITicker;

public class TickerWrapper extends AbstractTickerWrapper
{
	private final ITicker ticker;
	private final float frequency;

	public TickerWrapper(ITicker ticker, int frequency)
	{
		super(frequency);

		this.frequency = frequency;
		this.ticker = ticker;
	}

	@Override
	public void doTick(long stepNano)
	{
		ticker.tick(stepNano);
	}

	@Override
	public String getLabel()
	{
		return ticker.getLabel();
	}

	@Override
	public Object getTicker()
	{
		return ticker;
	}

	@Override
	public float getFrequency()
	{
		return frequency;
	}
}
