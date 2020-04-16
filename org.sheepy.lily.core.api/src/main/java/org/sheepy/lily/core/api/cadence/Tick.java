package org.sheepy.lily.core.api.cadence;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.TimeUnit;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Tick
{
	/**
	 * Frequency in Hz (in real world clock)
	 * <p>
	 * 0 means tick every frame.
	 */
	int frequency() default 0;

	TimeUnit frequencyRef() default TimeUnit.SECONDS;

	ETickerClock clock() default ETickerClock.RealWorld;

	int priority() default 0;
}
