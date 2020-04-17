package org.sheepy.lily.core.cadence.adapter;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.cadence.ICadenceConditionAdapter;
import org.sheepy.lily.core.api.cadence.ICadenceContext;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.cadence.HaveTime;
import org.sheepy.lily.core.model.cadence.ICadenceCondition;

@ModelExtender(scope = HaveTime.class)
@Adapter(singleton = true)
public class HaveTimeAdapter implements ICadenceConditionAdapter
{
	@Override
	public boolean check(ICadenceCondition condition, ICadenceContext context)
	{
		return context.endTimeNs() < System.nanoTime();
	}
}
