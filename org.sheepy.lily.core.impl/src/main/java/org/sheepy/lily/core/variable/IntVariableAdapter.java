package org.sheepy.lily.core.variable;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.logoce.notification.api.Notifier;
import org.sheepy.lily.core.api.variable.IModelVariableAdapter;
import org.sheepy.lily.core.model.variable.IntVariable;
import org.sheepy.lily.core.model.variable.VariablePackage;

import java.nio.ByteBuffer;
import java.util.List;

@ModelExtender(scope = IntVariable.class)
@Adapter(singleton = true)
public final class IntVariableAdapter extends Notifier<IModelVariableAdapter.Features> implements IModelVariableAdapter<IntVariable>
{
	private IntVariableAdapter()
	{
		super(List.of(Features.Value));
	}

	@NotifyChanged(featureIds = VariablePackage.INT_VARIABLE__VALUE)
	private void valueChanged(Notification notification)
	{
		final var newValue = notification.getNewValue();
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
		variable.setValue(Integer.parseInt(value));
	}

	@Override
	public void getValue(final IntVariable variable, final ByteBuffer buffer)
	{
		buffer.putInt(variable.getValue());
	}
}
