package org.sheepy.lily.core.api.util;

public class UPSMeter
{
	private final int updateEveryMs;

	private long startDate;
	private long endDate;
	private int tickCount;

	public UPSMeter(int updateEveryMs)
	{
		this.updateEveryMs = updateEveryMs;

		reset();
	}

	public void reset()
	{
		startDate = System.currentTimeMillis();
		endDate = startDate + updateEveryMs;
		tickCount = 0;
	}

	public void tick()
	{
		tickCount++;

		final long currentDate = System.currentTimeMillis();

		if (currentDate > endDate)
		{
			final long deltaTime = currentDate - startDate;
			final float UPS = 1000f * tickCount / deltaTime;

			System.out.printf("%.2f%n", UPS);

			reset();
		}
	}
}
