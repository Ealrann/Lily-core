package org.sheepy.lily.core.api.cadence;

public enum ETickerClock
{
	/** Clock based on {@link java.lang.System#nanoTime()} */
	RealWorld,

	/**
	 * Clock based on a factor of real clock:
	 * {@link org.sheepy.lily.core.model.application.Application#getTimeFactor()}
	 */
	ApplicationWorld
}
