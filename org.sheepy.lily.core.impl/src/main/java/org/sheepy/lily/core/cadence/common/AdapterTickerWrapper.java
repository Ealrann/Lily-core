package org.sheepy.lily.core.cadence.common;

import org.sheepy.lily.core.adapter.ITickDescriptor;

public class AdapterTickerWrapper extends AbstractTickerWrapper
{
	private final ITickDescriptor tickDescriptor;
	private final int priority;

	public AdapterTickerWrapper(ITickDescriptor tickDescriptor)
	{
		super(tickDescriptor.getClock(), tickDescriptor.getFrequency());
		this.tickDescriptor = tickDescriptor;
		priority = tickDescriptor.getPriority();
	}

	@Override
	public void doTick(long stepNano)
	{
		tickDescriptor.tick(stepNano);
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
	public int getPriority()
	{
		return priority;
	}
}
