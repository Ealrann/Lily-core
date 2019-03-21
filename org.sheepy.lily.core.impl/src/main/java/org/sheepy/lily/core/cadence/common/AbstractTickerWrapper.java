package org.sheepy.lily.core.cadence.common;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbstractTickerWrapper
{
	public static final Comparator<AbstractTickerWrapper> COMPARATOR = new Comparator<>()
	{
		@Override
		public int compare(AbstractTickerWrapper o1, AbstractTickerWrapper o2)
		{
			return Integer.compare(o2.getPriority(), o1.getPriority());
		}
	};

	protected final float frequency;
	protected final long tickerStep;

	protected long accumulator = 0;

	public final AtomicBoolean stop = new AtomicBoolean(false);

	public AbstractTickerWrapper(float frequency)
	{
		this.frequency = frequency;
		// We planify the next tick
		if (frequency > 0)
		{
			tickerStep = (long) (1e9 / frequency);
		}
		else
		{
			// If frequency <= 0, each accumulation leads to a tick.
			tickerStep = -1;
		}
	}

	public void accumulate(long stepNano)
	{
		accumulator += stepNano;
	}

	public boolean shouldTick()
	{
		return accumulator > 0 && accumulator >= tickerStep;
	}

	public final void tick()
	{
		if (tickerStep <= 0)
		{
			// if frequency <= 0, we use the accumulated time
			doTick(accumulator);
			accumulator = 0;
		}
		else
		{
			doTick(tickerStep);
			accumulator -= tickerStep;
		}
	}

	public abstract void doTick(long stepNano);

	public abstract String getLabel();

	public abstract Object getTicker();

	public abstract float getFrequency();

	public abstract int getPriority();
}