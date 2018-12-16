package org.sheepy.common.api.cadence;

import java.util.Collection;
import java.util.ServiceLoader;

import org.sheepy.common.api.service.IService;

public interface IStatistics extends IService
{
	void printTickersTime();

	void addTickerTime(String label, long durationNs);

	void update();

	void addAccumulatedDuration(String label, long duration);
	void sumAccumulatedDuration(String label, long duration);

	long getMedianDurationUs(String label);

	long getMedianDurationMaxUs(String label);

	Collection<String> getAccumulatorsLabels();

	static final IStatistics INSTANCE = ServiceLoader.load(IStatistics.class).findFirst().get();
}
