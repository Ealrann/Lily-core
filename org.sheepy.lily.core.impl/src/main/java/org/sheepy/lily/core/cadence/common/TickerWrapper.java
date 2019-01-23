package org.sheepy.lily.core.cadence.common;

import org.sheepy.lily.core.api.cadence.ITicker;

public class TickerWrapper extends AbstractCadencedWrapper
{
	public ITicker ticker;

	protected float frequency;

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
	
	public float getFrequency()
	{
		return frequency;
	}
}
