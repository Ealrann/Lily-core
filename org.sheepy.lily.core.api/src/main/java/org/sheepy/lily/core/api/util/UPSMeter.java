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

		long currentDate = System.currentTimeMillis();

		if (currentDate > endDate)
		{
			long deltaTime = currentDate - startDate;
			float UPS = (tickCount * 1000f) / deltaTime;

			System.out.println(((int) UPS) + " ups");

			reset();
		}
	}
}
