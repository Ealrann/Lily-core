package org.sheepy.lily.core.api.cadence;

import java.util.ServiceLoader;

public interface IStatistics
{
	void addTime(String label, long durationNs);

	void addTime(String parent, String label, long durationNs);

	void printTimes();

	void clear();

	IStatistics INSTANCE = ServiceLoader.load(IStatistics.class)
										.findFirst()
										.orElse(null);
}
