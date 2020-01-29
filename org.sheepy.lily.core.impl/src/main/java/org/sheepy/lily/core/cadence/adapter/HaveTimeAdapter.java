package org.sheepy.lily.core.cadence.adapter;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.cadence.ICadenceConditionAdapter;
import org.sheepy.lily.core.api.cadence.ICadenceContext;
import org.sheepy.lily.core.model.cadence.HaveTime;
import org.sheepy.lily.core.model.cadence.ICadenceCondition;

@Adapter(scope = HaveTime.class)
public class HaveTimeAdapter implements ICadenceConditionAdapter
{
	@Override
	public boolean check(ICadenceCondition condition, ICadenceContext context)
	{
		return context.endTimeNs() < System.nanoTime();
	}
}
