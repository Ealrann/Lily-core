package org.sheepy.lily.core.cadence.adapter;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.cadence.ICadenceConditionAdapter;
import org.sheepy.lily.core.api.cadence.ICadenceContext;
import org.sheepy.lily.core.model.cadence.CountUntil;
import org.sheepy.lily.core.model.cadence.ICadenceCondition;

@Adapter(scope = CountUntil.class)
public class CountUntilAdapter implements ICadenceConditionAdapter
{
	@Override
	public boolean check(ICadenceCondition condition, ICadenceContext context)
	{
		final var countUntil = (CountUntil) condition;
		final int count = countUntil.getCurrentCount();
		countUntil.setCurrentCount(count + 1);

		return count >= countUntil.getTotalCount();
	}
}
