package org.sheepy.lily.core.cadence.common;

import org.sheepy.lily.core.adapter.ITickDescriptor;

public class AdapterTickerWrapper extends AbstractTickerWrapper
{
	private final ITickDescriptor tickDescriptor;
	private final int frequency;

	public AdapterTickerWrapper(int frequency, ITickDescriptor tickDescriptor)
	{
		super(frequency);
		this.frequency = frequency;
		this.tickDescriptor = tickDescriptor;
	}

	@Override
	public void doTick(long stepNano)
	{
		tickDescriptor.tick(frequency);
	}

	@Override
	public String getLabel()
	{
		return tickDescriptor.getName();
	}

	@Override
	public Object getTicker()
	{
		return tickDescriptor;
	}

	@Override
	public float getFrequency()
	{
		return frequency;
	}

}
