package org.sheepy.lily.core.cadence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	public void addTime(String parent, String label, long durationNs)
	{
		final var parentAccumulator = getOrCreateAccumulator(parent);
		final var accumulator = getOrCreateAccumulator(label);

		if (accumulator.parent == null)
		{
			accumulator.parent = parent;
			parentAccumulator.children.add(label);
		}

		accumulator.tick(durationNs);
	}

	@Override
	public void addTime(String label, long durationNs)
	{
		final var accumulator = getOrCreateAccumulator(label);
		accumulator.tick(durationNs);
	}

	private AccumulatorTime getOrCreateAccumulator(String label)
	{
		var accumulator = accumulatorsTime.get(label);
		if (accumulator == null)
		{
			accumulator = new AccumulatorTime(label);
			accumulatorsTime.put(label, accumulator);
		}
		return accumulator;
	}

	@Override
	public void printTimes()
	{
		System.out.println("===============================================");
		System.out.println("Tickers times :");

		System.out.format("                Name                 | Avg (ms) | Max (ms) | Total (ms)\n");
		System.out.format("-----------------------------------------------------------------------\n");
		final String messagePattern = "%-36s | %8.1f | %8.1f | %8.1f\n";

		for (final var accu : accumulatorsTime.values())
		{
			if (accu.parent == null)
			{
				printTimes(messagePattern, accu, 0);
			}
		}

		System.out.println("===============================================");
	}

	private void printTimes(final String message, AccumulatorTime accu, int depth)
	{
		final double total = accu.totalNs / 1e6;
		final double average = accu.averageNs / 1e6;
		final double max = accu.maxNS / 1e6;
		final String name = formatName(accu, depth);

		System.out.format(message, name, average, max, total);

		final List<String> children = accu.children;
		for (final String child : children)
		{
			printTimes(message, accumulatorsTime.get(child), depth + 1);
		}
	}

	private static String formatName(AccumulatorTime accu, int depth)
	{
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < depth; i++)
		{
			if (i == depth - 1) sb.append("|-");
			else sb.append("  ");
		}
		sb.append(accu.name);
		return sb.toString();
	}

	private static class AccumulatorTime
	{
		private static final int TICK_STACK_COUNT = 20;

		public final String name;
		public String parent = null;
		public final List<String> children = new ArrayList<>();

		private final long[] tickStack = new long[TICK_STACK_COUNT];

		public long averageNs = 0;
		public long totalNs = 0;
		public long maxNS = 0;
		public int index = 0;

		public AccumulatorTime(String name)
		{
			this.name = name;
		}

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
