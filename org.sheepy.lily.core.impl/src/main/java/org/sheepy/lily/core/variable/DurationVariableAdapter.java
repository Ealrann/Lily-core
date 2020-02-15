package org.sheepy.lily.core.variable;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.annotation.Tick;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.notification.impl.IntNotification;
import org.sheepy.lily.core.api.variable.IDurationVariableAdapter;
import org.sheepy.lily.core.model.variable.DurationVariable;

@Statefull
@Adapter(scope = DurationVariable.class, lazy = false)
public final class DurationVariableAdapter extends Notifier implements IDurationVariableAdapter
{
	private long startMs = 0;
	private int durationMs = 0;

	private DurationVariableAdapter()
	{
		super(Features.values().length);
	}

	@Load
	private void load()
	{
		resetDuration();
	}

	@Tick
	private void tick()
	{
		final int oldDuration = durationMs;
		durationMs = (int) (System.currentTimeMillis() - startMs);
		fireNotification(new IntNotification(this, Features.Value, oldDuration, durationMs));
	}

	@Override
	public void setValue(final String value)
	{
		resetDuration();
		durationMs = Integer.parseInt(value);
		startMs -= durationMs;
	}

	@Override
	public int intValue(final DurationVariable variable)
	{
		return durationMs;
	}

	@Override
	public void resetDuration()
	{
		startMs = System.currentTimeMillis();
	}

	@Override
	public int bytes()
	{
		return Integer.BYTES;
	}

	@Override
	public Type type()
	{
		return Type.Int;
	}
}
