package org.sheepy.lily.core.variable;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.variable.IModelVariableAdapter;
import org.sheepy.lily.core.model.variable.VariablePackage;
import org.sheepy.lily.core.model.variable.Vector3fVariable;

import java.nio.ByteBuffer;

@Adapter(scope = Vector3fVariable.class)
public final class Vector3fVariableAdapter extends Notifier<IModelVariableAdapter.Features> implements
																							IModelVariableAdapter<Vector3fVariable>
{
	private static final int BYTES = 3 * Float.BYTES;

	private Vector3fVariableAdapter()
	{
		super(Features.values().length);
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
		return BYTES;
	}

	@Override
	public void setValue(final Vector3fVariable variable, final String value)
	{
	}

	@Override
	public void getValue(final Vector3fVariable variable, final ByteBuffer buffer)
	{
		variable.getVector().get(buffer);
		buffer.position(buffer.position() + BYTES);
	}
}
