package org.sheepy.lily.core.cadence.tick;

import org.sheepy.lily.core.api.cadence.ETickerClock;
import org.sheepy.lily.core.api.cadence.Tick;

public record TickConfiguration(Double tickFrequency, Integer tickPriority, ETickerClock clock)
{
	public TickConfiguration(final Tick annotation)
	{
		this(computeFrequency(annotation), annotation.priority(), annotation.clock());
	}

	private static double computeFrequency(final Tick tickAnnotation)
	{
		final int frequency = tickAnnotation.frequency();
		final var frequencyRef = tickAnnotation.frequencyRef();

		return (double) frequency / frequencyRef.toSeconds(1);
	}
}
