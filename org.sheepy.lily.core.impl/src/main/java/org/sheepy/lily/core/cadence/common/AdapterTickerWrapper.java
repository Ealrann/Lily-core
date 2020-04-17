package org.sheepy.lily.core.cadence.common;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.cadence.tick.TickHandle;

public class AdapterTickerWrapper extends AbstractTickerWrapper
{
	private final TickHandle tickDescriptor;
	private final int priority;

	public AdapterTickerWrapper(TickHandle tickDescriptor)
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

	public EObject getTarget()
	{
		return tickDescriptor.target;
	}

	@Override
	public int getPriority()
	{
		return priority;
	}
}
