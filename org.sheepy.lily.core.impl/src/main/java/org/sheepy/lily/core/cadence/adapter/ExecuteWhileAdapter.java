package org.sheepy.lily.core.cadence.adapter;

import org.logoce.adapter.api.Adapter;
import org.sheepy.lily.core.api.cadence.ICadenceConditionAdapter;
import org.sheepy.lily.core.api.cadence.ICadenceContext;
import org.sheepy.lily.core.api.cadence.ICadenceTaskAdapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.model.cadence.ExecuteWhile;
import org.sheepy.lily.core.model.cadence.ICadenceTask;

@ModelExtender(scope = ExecuteWhile.class)
@Adapter(singleton = true)
public final class ExecuteWhileAdapter implements ICadenceTaskAdapter
{
	@Override
	public void execute(ICadenceTask task, ICadenceContext context)
	{
		final var execWhile = (ExecuteWhile) task;

		while (checkConditions(execWhile, context))
		{
			for (final var subTask : execWhile.getTasks())
			{
				final var subAdapter = subTask.adaptNotNull(ICadenceTaskAdapter.class);
				subAdapter.execute(subTask, context);
			}
		}
	}

	private static boolean checkConditions(ExecuteWhile execWhile, ICadenceContext context)
	{
		boolean res = true;

		for (final var condition : execWhile.getConditions())
		{
			final var conditionAdapter = condition.adapt(ICadenceConditionAdapter.class);
			if (conditionAdapter.check(condition, context))
			{
				res = false;
				break;
			}
		}

		return res;
	}
}
