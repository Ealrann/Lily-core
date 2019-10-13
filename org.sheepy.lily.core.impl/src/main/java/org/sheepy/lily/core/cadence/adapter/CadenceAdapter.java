package org.sheepy.lily.core.cadence.adapter;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.cadence.ICadenceAdapter;
import org.sheepy.lily.core.api.cadence.ICadenceContext;
import org.sheepy.lily.core.api.cadence.ICadenceTaskAdapter;
import org.sheepy.lily.core.model.cadence.Cadence;

@Statefull
@Adapter(scope = Cadence.class)
public final class CadenceAdapter implements ICadenceAdapter
{
	private final Cadence cadence;
	private final long stepNs;

	public CadenceAdapter(Cadence cadence)
	{
		this.cadence = cadence;
		final var freq = cadence.getFrequency();
		if (freq > 0)
		{
			stepNs = (long) (1e9 / freq);
		}
		else
		{
			stepNs = 0;
		}
	}

	@Override
	public void run()
	{
		final long start = System.nanoTime();

		final var context = new CadenceContext(start, start + stepNs);

		for (final var task : cadence.getTasks())
		{
			final var taskAdapter = task.adapt(ICadenceTaskAdapter.class);
			taskAdapter.execute(task, context);
		}
	}

	private static final class CadenceContext implements ICadenceContext
	{
		private final long start;
		private final long end;

		CadenceContext(long start, long end)
		{
			this.start = start;
			this.end = end;
		}

		@Override
		public long startTimeNs()
		{
			return start;
		}

		@Override
		public long endTimeNs()
		{
			return end;
		}
	}
}
