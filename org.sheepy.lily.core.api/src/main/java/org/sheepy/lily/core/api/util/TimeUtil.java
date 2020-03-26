package org.sheepy.lily.core.api.util;

import org.sheepy.lily.core.model.types.ETimeUnit;

import java.util.concurrent.TimeUnit;

public final class TimeUtil
{
	public static TimeUnit resolveUnit(ETimeUnit unit)
	{
		return switch (unit)
				{
					case DAYS -> TimeUnit.DAYS;
					case HOURS -> TimeUnit.HOURS;
					case MICROSECONDS -> TimeUnit.MICROSECONDS;
					case MILLISECONDS -> TimeUnit.MILLISECONDS;
					case MINUTES -> TimeUnit.MINUTES;
					case NANOSECONDS -> TimeUnit.NANOSECONDS;
					case SECONDS -> TimeUnit.SECONDS;
				};
	}
}
