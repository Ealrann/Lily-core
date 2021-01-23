package org.sheepy.lily.core.cadence.adapter;

import org.logoce.adapter.api.Adapter;
import org.sheepy.lily.core.api.cadence.ICadenceConditionAdapter;
import org.sheepy.lily.core.api.cadence.ICadenceContext;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.model.cadence.CountUntil;
import org.sheepy.lily.core.model.cadence.ICadenceCondition;

@ModelExtender(scope = CountUntil.class)
@Adapter(singleton = true)
public class CountUntilAdapter implements ICadenceConditionAdapter
{
	@Override
	public boolean check(ICadenceCondition condition, ICadenceContext context)
	{
		final var countUntil = (CountUntil) condition;
		final int count = countUntil.getCurrentCount();
		countUntil.setCurrentCount(count + 1);

		return count < countUntil.getTotalCount();
	}
}
