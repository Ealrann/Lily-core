package org.sheepy.lily.core.api.variable;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.core.model.variable.IVariableResolver;

public interface IVariableResolverAdapter<T extends IVariableResolver> extends IAdapter
{
	Object getValue(T variableResolver);

	void setValue(T variableResolver, Object object);

	void addListener(INotificationListener listener);

	void removeListener(INotificationListener listener);
}
