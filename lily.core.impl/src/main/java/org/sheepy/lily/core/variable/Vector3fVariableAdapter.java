package org.sheepy.lily.core.variable;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.sheepy.lily.core.api.adapter.NotifyChanged;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.notification.Notification;
import org.sheepy.lily.core.api.adapter.NotifierAdapter;
import org.sheepy.lily.core.api.variable.IModelVariableAdapter;
import org.sheepy.lily.core.model.variable.Vector3fVariable;

import java.nio.ByteBuffer;
import java.util.List;

@ModelExtender(scope = Vector3fVariable.class)
@Adapter(singleton = true)
public final class Vector3fVariableAdapter extends NotifierAdapter<IModelVariableAdapter.Features> implements
																							IModelVariableAdapter<Vector3fVariable>
{
	private static final int BYTES = 3 * Float.BYTES;

	private Vector3fVariableAdapter()
	{
		super(List.of(Features.Value));
	}

	@NotifyChanged(featureIds = Vector3fVariable.FeatureIDs.VECTOR)
	private void valueChanged(Notification notification)
	{
		final var newValue = notification.newValue();
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
		variable.vector().get(buffer);
		buffer.position(buffer.position() + BYTES);
	}
}
