package org.sheepy.lily.core.variable;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.variable.IModelVariableAdapter;
import org.sheepy.lily.core.model.variable.FloatVariable;
import org.sheepy.lily.core.model.variable.VariablePackage;

import java.nio.ByteBuffer;
import java.util.List;

@Adapter(scope = FloatVariable.class)
public final class FloatVariableAdapter extends Notifier<IModelVariableAdapter.Features> implements
																						 IModelVariableAdapter<FloatVariable>
{
	private FloatVariableAdapter()
	{
		super(List.of(Features.Value));
	}

	@NotifyChanged(featureIds = VariablePackage.FLOAT_VARIABLE__VALUE)
	private void valueChanged(Notification notification)
	{
		final var newValue = notification.getNewValue();
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
		variable.setValue(Integer.parseInt(value));
	}

	@Override
	public void getValue(final FloatVariable variable, final ByteBuffer buffer)
	{
		buffer.putFloat(variable.getValue());
	}
}
