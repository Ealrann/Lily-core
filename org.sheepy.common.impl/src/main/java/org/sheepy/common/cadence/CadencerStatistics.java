package org.sheepy.common.cadence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import org.sheepy.common.api.cadence.IStatistics;

public class CadencerStatistics implements IStatistics
{
	// in ms
	private final int statDuration = 1000;
	private long currentStatTime = 0;

	private final HashMap<String, Long> tickersTime = new HashMap<>();

	private final HashMap<String, AccumulatorTime> accumulatorsTime = new HashMap<>();

	private class AccumulatorTime
	{
		ArrayList<Long> list = new ArrayList<>();
		long durationUs = 0;
		long durationMaxUs = 0;
		long total = 0;
	}

	private final HashSet<String> accumulatedThisTurn = new HashSet<>();

	@Override
	public void update()
	{
		accumulatedThisTurn.clear();

		if (System.currentTimeMillis() > currentStatTime + statDuration)
		{

			for (Entry<String, AccumulatorTime> e : accumulatorsTime.entrySet())
			{
				ArrayList<Long> times = e.getValue().list;

				long sum = 0;
				long max = 0;
				for (int i = 0; i<  times.size(); i++)
				{
					Long l = times.get(i);
					l /= 1000;
					sum += l;
					if (l > max)
					{
						max = l;
					}
				}
				e.getValue().durationMaxUs = max;
				if (times.isEmpty() == false)
					e.getValue().durationUs = sum / times.size();
				else
					e.getValue().durationUs = 0;
				e.getValue().total += sum;

				times.clear();
			}

			currentStatTime = System.currentTimeMillis();
		}
	}

	@Override
	public void addTickerTime(String label, long durationNs)
	{
		Long totalDuration = tickersTime.get(label);
		if (totalDuration == null)
		{
			tickersTime.put(label, durationNs);
		}
		else
		{
			tickersTime.put(label, totalDuration + durationNs);
		}
	}

	@Override
	public void printTickersTime()
	{
		System.out.println("===============================================");
		System.out.println("Tickers times :");

		for (Entry<String, AccumulatorTime> e : accumulatorsTime.entrySet())
		{
			System.out.format("%s ; %d ms \n", e.getKey(),
					e.getValue().total / 1000);
		}

		for (Entry<String, Long> entry : tickersTime.entrySet())
		{
			System.out.format("%s : %d ms\n", entry.getKey(),
					entry.getValue() / 1_000_000);
		}
		System.out.println("===============================================");
	}

	@Override
	public Collection<String> getAccumulatorsLabels()
	{
		return accumulatorsTime.keySet();
	}

	@Override
	public void addAccumulatedDuration(String label, long duration)
	{
		AccumulatorTime ac = accumulatorsTime.get(label);
		if (ac == null)
		{
			ac = new AccumulatorTime();
			accumulatorsTime.put(label, ac);
		}

		ac.list.add(duration);
		accumulatedThisTurn.add(label);
	}

	@Override
	public void sumAccumulatedDuration(String label, long duration)
	{
		if (accumulatedThisTurn.contains(label) == false)
		{
			addAccumulatedDuration(label, duration);
		}
		else
		{
			AccumulatorTime ac = accumulatorsTime.get(label);
			if (ac == null)
			{
				ac = new AccumulatorTime();
				accumulatorsTime.put(label, ac);
			}

			long last = ac.list.get(ac.list.size() - 1);
			ac.list.set(ac.list.size() - 1, last + duration);
		}
	}

	@Override
	public long getMedianDurationUs(String label)
	{
		AccumulatorTime ac = accumulatorsTime.get(label);
		if (ac != null)
		{
			return ac.durationUs;
		}
		return -1;
	}

	@Override
	public long getMedianDurationMaxUs(String label)
	{
		AccumulatorTime ac = accumulatorsTime.get(label);
		if (ac != null)
		{
			return ac.durationMaxUs;
		}
		return -1;
	}
}
