package org.sheepy.common.api.variable;

import org.sheepy.common.api.adapter.IAdapter;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.model.variable.IVariableResolver;

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
		return IServiceAdapterFactory.INSTANCE.adapt(part, IVariableResolverAdapter.class);
	}
}
