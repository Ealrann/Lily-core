package org.sheepy.lily.core.cadence.tick.wrapper;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.cadence.tick.TickHandle;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbstractTickerWrapper implements ITickerWrapper
{
	private final TickHandle tickHandle;
	private final AtomicBoolean stop = new AtomicBoolean(false);

	protected long accumulator = 0;

	public AbstractTickerWrapper(final TickHandle tickHandle)
	{
		this.tickHandle = tickHandle;
	}

	@Override
	public final void accumulate(final long stepNs, final long appStepNs)
	{
		accumulator += switch (tickHandle.getClock())
				{
					case RealWorld -> stepNs;
					case ApplicationWorld -> appStepNs;
				};
	}

	@Override
	public final TickHandle getTickHandle()
	{
		return tickHandle;
	}

	@Override
	public final String getLabel()
	{
		return tickHandle.getName();
	}

	@Override
	public final EObject getTarget()
	{
		return tickHandle.target;
	}

	@Override
	public final int getPriority()
	{
		return tickHandle.getPriority();
	}

	@Override
	public final boolean isStopped()
	{
		return stop.get();
	}

	@Override
	public final void stop()
	{
		stop.set(true);
	}
}
