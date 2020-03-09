package org.sheepy.lily.core.variable;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.variable.IModelVariableAdapter;
import org.sheepy.lily.core.model.variable.IntVariable;
import org.sheepy.lily.core.model.variable.VariablePackage;

import java.nio.ByteBuffer;

@Adapter(scope = IntVariable.class)
public final class IntVariableAdapter extends Notifier<IModelVariableAdapter.Features> implements IModelVariableAdapter<IntVariable>
{
	private IntVariableAdapter()
	{
		super(IModelVariableAdapter.Features.values().length);
	}

	@NotifyChanged(featureIds = VariablePackage.INT_VARIABLE__VALUE)
	private void valueChanged(Notification notification)
	{
		notify(IModelVariableAdapter.Features.Value, notification.getNewValue());
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
