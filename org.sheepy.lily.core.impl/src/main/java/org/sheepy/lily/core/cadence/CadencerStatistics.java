package org.sheepy.lily.core.cadence;

import java.util.HashMap;
import java.util.Map.Entry;

import org.sheepy.lily.core.api.cadence.IStatistics;

public class CadencerStatistics implements IStatistics
{
	private final HashMap<String, AccumulatorTime> accumulatorsTime = new HashMap<>();

	@Override
	public void clear()
	{
		accumulatorsTime.clear();
	}

	@Override
	public void addTime(String label, long durationNs)
	{
		var accumulator = accumulatorsTime.get(label);
		if (accumulator == null)
		{
			accumulator = new AccumulatorTime();
			accumulatorsTime.put(label, accumulator);
		}

		accumulator.tick(durationNs);
	}

	@Override
	public void printTimes()
	{
		System.out.println("===============================================");
		System.out.println("Tickers times :");

		final String messagePattern = "%30s: Average: %5.2f ms, Max: %5.2f ms, Total: %5.2f ms \n";

		for (final Entry<String, AccumulatorTime> e : accumulatorsTime.entrySet())
		{
			final var label = e.getKey();
			final var accu = e.getValue();
			final double total = accu.totalNs / 1e6;
			final double average = accu.averageNs / 1e6;
			final double max = accu.maxNS / 1e6;
			System.out.format(messagePattern, label, average, max, total);
		}
		System.out.println("===============================================");
	}

	private static class AccumulatorTime
	{
		private static final int TICK_STACK_COUNT = 10;
		Long[] tickStack = new Long[TICK_STACK_COUNT];
		long averageNs = 0;
		long totalNs = 0;
		long maxNS = 0;

		private int index = 0;

		public void tick(long durationNs)
		{
			if (durationNs > maxNS)
			{
				maxNS = durationNs;
			}

			tickStack[index] = durationNs;

			index++;

			if (index >= TICK_STACK_COUNT)
			{
				summerize();
				index = 0;
			}
		}

		private void summerize()
		{
			long total = 0;
			for (int i = 0; i < TICK_STACK_COUNT; i++)
			{
				total += tickStack[i];
			}

			totalNs += total;

			final long average = total / TICK_STACK_COUNT;
			if (averageNs == 0)
			{
				averageNs = average;
			}
			else
			{
				averageNs = (averageNs + average) / 2;
			}
		}
	}
}
