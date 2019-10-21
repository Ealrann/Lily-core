package org.sheepy.lily.core.api.cadence;

import java.util.ServiceLoader;

import org.sheepy.lily.core.api.service.IService;

public interface IStatistics extends IService
{
	void addTime(String label, long durationNs);
	void addTime(String parent, String label, long durationNs);

	void printTimes();

	void clear();

	static final IStatistics INSTANCE = ServiceLoader.load(IStatistics.class).findFirst().get();
}
