package org.sheepy.lily.core.variable;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.sheepy.lily.core.api.adapter.NotifyChanged;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.notification.Notification;
import org.sheepy.lily.core.api.adapter.NotifierAdapter;
import org.sheepy.lily.core.api.variable.IModelVariableAdapter;
import org.sheepy.lily.core.model.variable.IntVariable;

import java.nio.ByteBuffer;
import java.util.List;

@ModelExtender(scope = IntVariable.class)
@Adapter(singleton = true)
public final class IntVariableAdapter extends NotifierAdapter<IModelVariableAdapter.Features> implements IModelVariableAdapter<IntVariable>
{
	private IntVariableAdapter()
	{
		super(List.of(Features.Value));
	}

	@NotifyChanged(featureIds = IntVariable.FeatureIDs.VALUE)
	private void valueChanged(Notification notification)
	{
		final var newValue = notification.newValue();
		notify(IModelVariableAdapter.Features.Value, newValue);
	}

	@Override
	public int bytes()
	{
		return Integer.BYTES;
	}

	@Override
	public void setValue(final IntVariable variable, final String value)
	{
		variable.value(Integer.parseInt(value));
	}

	@Override
	public void getValue(final IntVariable variable, final ByteBuffer buffer)
	{
		buffer.putInt(variable.value());
	}
}
