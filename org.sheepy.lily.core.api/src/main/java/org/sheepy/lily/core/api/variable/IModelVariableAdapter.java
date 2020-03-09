package org.sheepy.lily.core.api.variable;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.INotifier;
import org.sheepy.lily.core.model.variable.IModelVariable;

import java.nio.ByteBuffer;

public interface IModelVariableAdapter<T extends IModelVariable> extends INotifier<IModelVariableAdapter.Features>,
																		 IAdapter
{
	enum Features implements Feature<Object, Features>
	{
		Value
	}

	int bytes();
	void getValue(T variable, ByteBuffer buffer);
	void setValue(T variable, String value);
}
