package org.sheepy.lily.core.variable;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.sheepy.lily.core.api.adapter.NotifyChanged;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.notification.Notification;
import org.sheepy.lily.core.api.adapter.NotifierAdapter;
import org.sheepy.lily.core.api.variable.IModelVariableAdapter;
import org.sheepy.lily.core.model.variable.FloatVariable;

import java.nio.ByteBuffer;
import java.util.List;

@ModelExtender(scope = FloatVariable.class)
@Adapter(singleton = true)
public final class FloatVariableAdapter extends NotifierAdapter<IModelVariableAdapter.Features> implements
																						 IModelVariableAdapter<FloatVariable>
{
	private FloatVariableAdapter()
	{
		super(List.of(Features.Value));
	}

	@NotifyChanged(featureIds = FloatVariable.FeatureIDs.VALUE)
	private void valueChanged(Notification notification)
	{
		final var newValue = notification.newValue();
		notify(Features.Value, newValue);
	}

	@Override
	public int bytes()
	{
		return Float.BYTES;
	}

	@Override
	public void setValue(final FloatVariable variable, final String value)
	{
		variable.value(Integer.parseInt(value));
	}

	@Override
	public void getValue(final FloatVariable variable, final ByteBuffer buffer)
	{
		buffer.putFloat(variable.value());
	}
}
