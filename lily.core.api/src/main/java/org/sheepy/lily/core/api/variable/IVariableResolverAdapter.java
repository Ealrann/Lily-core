package org.sheepy.lily.core.api.variable;

import org.logoce.lmf.core.api.notification.IFeature;
import org.logoce.lmf.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.core.model.variable.IVariableResolver;

import java.util.function.Consumer;

public interface IVariableResolverAdapter<T extends IVariableResolver>
	extends INotifierAdapter<IVariableResolverAdapter.Features>
{
	interface Features extends IFeatures<Features>
	{
		IFeature<Consumer<Object>, Features> Value = IFeature.newFeature();
	}

	Object getValue(T variableResolver);

	void setValue(T variableResolver, Object object);

	default void listen(final Consumer<Object> listener)
	{
		listen(listener, IVariableResolverAdapter.Features.Value);
	}

	default void sulk(final Consumer<Object> listener)
	{
		sulk(listener, IVariableResolverAdapter.Features.Value);
	}
}
