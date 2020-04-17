package org.sheepy.lily.core.cadence.adapter;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.cadence.ICadenceConditionAdapter;
import org.sheepy.lily.core.api.cadence.ICadenceContext;
import org.sheepy.lily.core.api.cadence.ICadenceTaskAdapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.cadence.ExecuteIf;
import org.sheepy.lily.core.model.cadence.ICadenceTask;

@ModelExtender(scope = ExecuteIf.class)
@Adapter(singleton = true)
public final class ExecuteIfAdapter implements ICadenceTaskAdapter
{
	@Override
	public void execute(ICadenceTask task, ICadenceContext context)
	{
		final var execIf = (ExecuteIf) task;

		if (checkConditions(execIf, context))
		{
			for (final var subTask : execIf.getTasks())
			{
				final var subAdapter = subTask.adaptNotNull(ICadenceTaskAdapter.class);
				subAdapter.execute(subTask, context);
			}
		}
	}

	private static boolean checkConditions(ExecuteIf execIf, ICadenceContext context)
	{
		boolean res = true;

		for (final var condition : execIf.getConditions())
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
