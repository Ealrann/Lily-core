package org.sheepy.lily.core.cadence.adapter;

import org.logoce.adapter.api.Adapter;
import org.sheepy.lily.core.api.cadence.ICadenceConditionAdapter;
import org.sheepy.lily.core.api.cadence.ICadenceContext;
import org.logoce.extender.api.ModelExtender;
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
