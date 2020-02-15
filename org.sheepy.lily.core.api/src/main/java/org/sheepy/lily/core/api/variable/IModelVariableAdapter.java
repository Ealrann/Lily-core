package org.sheepy.lily.core.api.variable;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.notification.INotifier;
import org.sheepy.lily.core.model.variable.IModelVariable;

public interface IModelVariableAdapter<T extends IModelVariable> extends INotifier, IAdapter
{
	enum Features
	{
		Value
	}

	enum Type
	{
		Int
	}

	int bytes();
	Type type();
	void setValue(String value);

	default int intValue(T variable)
	{
		return 0;
	}
}
