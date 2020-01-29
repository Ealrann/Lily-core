package org.sheepy.lily.core.api.util;

import java.util.concurrent.TimeUnit;

import org.sheepy.lily.core.model.types.ETimeUnit;

public final class TimeUtil
{

	public static TimeUnit resolveUnit(ETimeUnit unit)
	{
		switch (unit)
		{
		case DAYS:
			return TimeUnit.DAYS;
		case HOURS:
			return TimeUnit.HOURS;
		case MICROSECONDS:
			return TimeUnit.MICROSECONDS;
		case MILLISECONDS:
			return TimeUnit.MILLISECONDS;
		case MINUTES:
			return TimeUnit.MINUTES;
		case NANOSECONDS:
			return TimeUnit.NANOSECONDS;
		case SECONDS:
			return TimeUnit.SECONDS;
		default:
			return null;
		}
	}
}
