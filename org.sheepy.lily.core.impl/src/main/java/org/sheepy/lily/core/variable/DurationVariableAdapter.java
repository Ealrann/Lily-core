package org.sheepy.lily.core.variable;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.annotation.Tick;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.variable.IDurationVariableAdapter;
import org.sheepy.lily.core.api.variable.IModelVariableAdapter;
import org.sheepy.lily.core.model.variable.DurationVariable;

import java.nio.ByteBuffer;

@Statefull
@Adapter(scope = DurationVariable.class, lazy = false)
public final class DurationVariableAdapter extends Notifier<IModelVariableAdapter.Features> implements
																							IDurationVariableAdapter
{
	private long startMs = 0;
	private int durationMs = 0;

	private DurationVariableAdapter()
	{
		super(IModelVariableAdapter.Features.values().length);
	}

	@Load
	private void load()
	{
		resetDuration();
	}

	@Tick
	private void tick()
	{
		durationMs = (int) (System.currentTimeMillis() - startMs);
		notify(IModelVariableAdapter.Features.Value, durationMs);
	}

	@Override
	public void getValue(final DurationVariable variable, final ByteBuffer buffer)
	{
		buffer.putInt(durationMs);
	}

	@Override
	public void setValue(final DurationVariable variable, final String value)
	{
		resetDuration();
		durationMs = Integer.parseInt(value);
		startMs -= durationMs;
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
}
