package org.sheepy.common.api.variable;

import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.adapter.IAdapter;
import org.sheepy.common.model.variable.AbstractVariableResolver;

public interface IVariableResolverAdapter<T extends AbstractVariableResolver>
		extends IAdapter
{
	String getValue(T variableResolver);

	@SuppressWarnings("unchecked")
	static <T extends AbstractVariableResolver> IVariableResolverAdapter<T> adapt(AbstractVariableResolver part)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(part, IVariableResolverAdapter.class);
	}
}
