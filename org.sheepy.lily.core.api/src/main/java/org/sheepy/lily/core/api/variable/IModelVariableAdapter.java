package org.sheepy.lily.core.api.variable;

import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.model.variable.IModelVariable;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

public interface IModelVariableAdapter<T extends IModelVariable> extends INotifierAdapter<IModelVariableAdapter.Features>
{
	interface Features extends IFeatures<Features>
	{
		Feature<Consumer<Object>, Features> Value = Feature.newFeature();
	}

	int bytes();
	void getValue(T variable, ByteBuffer buffer);
	void setValue(T variable, String value);

	@SuppressWarnings("unchecked")
	static Class<? extends INotifierAdapter<IModelVariableAdapter.Features>> notifierClass()
	{
		return (Class<? extends INotifierAdapter<IModelVariableAdapter.Features>>) (Class<?>) IModelVariableAdapter.class;
	}
}
