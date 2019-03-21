package org.sheepy.lily.core.api.variable;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.model.variable.IVariableResolver;

public interface IVariableResolverAdapter<T extends IVariableResolver> extends IAdapter
{
	Object getValue(T variableResolver);

	void setValue(T variableResolver, Object object);

	void addListener(IVariableListener listener);

	void removeListener(IVariableListener listener);

	interface IVariableListener
	{
		void onVariableChange(Object oldValue, Object newValue);
	}

	@SuppressWarnings("unchecked")
	static <T extends IVariableResolver> IVariableResolverAdapter<T> adapt(T part)
	{
		return IAdapterFactoryService.INSTANCE.adapt(part, IVariableResolverAdapter.class);
	}
}
