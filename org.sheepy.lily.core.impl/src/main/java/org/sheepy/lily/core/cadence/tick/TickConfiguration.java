package org.sheepy.lily.core.cadence.tick;

import org.sheepy.lily.core.api.cadence.ETickerClock;
import org.sheepy.lily.core.api.cadence.Tick;

public final class TickConfiguration
{
	public final Double tickFrequency;
	public final Integer tickPriority;
	public final ETickerClock clock;

	public TickConfiguration(Double tickFrequency, Integer tickPriority, ETickerClock clock)
	{
		this.tickFrequency = tickFrequency;
		this.tickPriority = tickPriority;
		this.clock = clock;
	}

	public TickConfiguration(final Tick annotation)
	{
		tickFrequency = computeFrequency(annotation);
		tickPriority = annotation.priority();
		clock = annotation.clock();
	}

	private static double computeFrequency(final Tick tickAnnotation)
	{
		final int frequency = tickAnnotation.frequency();
		final var frequencyRef = tickAnnotation.frequencyRef();

		return (double) frequency / frequencyRef.toSeconds(1);
	}
}
