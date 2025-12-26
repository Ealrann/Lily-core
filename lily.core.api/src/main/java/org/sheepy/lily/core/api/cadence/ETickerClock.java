package org.sheepy.lily.core.api.cadence;

import org.sheepy.lily.core.model.application.Application;

public enum ETickerClock
{
	/** Clock based on {@link java.lang.System#nanoTime()} */
	RealWorld,

	/**
	 * Clock based on a factor of real clock:
	 * {@link Application#getTimeConfiguration()}
	 */
	ApplicationWorld
}
