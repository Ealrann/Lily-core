package org.sheepy.common.api.variable;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.IAdapter;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.util.FeatureDefinition;
import org.sheepy.common.model.variable.AbstractVariableResolver;

public interface IVariableResolverAdapter<T extends AbstractVariableResolver> extends IAdapter
{
	Object getValue(T variableResolver);
	void setValue(T variableResolver, Object object);

	EObject getTarget(T variableResolver);
	FeatureDefinition getFeatureDefinition(T variableResolver);

	@SuppressWarnings("unchecked")
	static <T extends AbstractVariableResolver> IVariableResolverAdapter<T> adapt(AbstractVariableResolver part)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(part, IVariableResolverAdapter.class);
	}
}
