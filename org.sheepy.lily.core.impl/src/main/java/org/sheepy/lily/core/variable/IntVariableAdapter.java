package org.sheepy.lily.core.variable;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.core.api.variable.IModelVariableAdapter;
import org.sheepy.lily.core.model.variable.IntVariable;
import org.sheepy.lily.core.model.variable.VariablePackage;

@Statefull
@Adapter(scope = IntVariable.class)
public final class IntVariableAdapter implements IModelVariableAdapter<IntVariable>
{
	private final IntVariable variable;

	private IntVariableAdapter(IntVariable variable)
	{
		this.variable = variable;
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

	@Override
	public int intValue(final IntVariable variable)
	{
		return variable.getValue();
	}

	@Override
	public void setValue(final String value)
	{
		variable.setValue(Integer.parseInt(value));
	}

	@Override
	public void addListener(final INotificationListener listener, final int... features)
	{
		for (var feature : features)
		{
			final var eFeature = Features.values()[feature];
			switch (eFeature)
			{
				case Value:
					variable.addListener(listener, VariablePackage.INT_VARIABLE__VALUE);
					break;
			}
		}
	}

	@Override
	public void removeListener(final INotificationListener listener, final int... features)
	{
		for (var feature : features)
		{
			final var eFeature = Features.values()[feature];
			switch (eFeature)
			{
				case Value:
					variable.removeListener(listener, VariablePackage.INT_VARIABLE__VALUE);
					break;
			}
		}
	}
}
