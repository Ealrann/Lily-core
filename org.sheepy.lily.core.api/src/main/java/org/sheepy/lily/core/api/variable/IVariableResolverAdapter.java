package org.sheepy.lily.core.api.variable;

import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.logoce.notification.api.Feature;
import org.logoce.notification.api.IFeatures;
import org.sheepy.lily.core.model.variable.IVariableResolver;

import java.util.function.Consumer;

public interface IVariableResolverAdapter<T extends IVariableResolver> extends INotifierAdapter<IVariableResolverAdapter.Features>
{
	interface Features extends IFeatures<Features>
	{
		Feature<Consumer<Object>, Features> Value = Feature.newFeature();
	}

	Object getValue(T variableResolver);

	void setValue(T variableResolver, Object object);

	default void listen(Consumer<Object> listener)
	{
		listen(listener, IVariableResolverAdapter.Features.Value);
	}

	default void sulk(Consumer<Object> listener)
	{
		sulk(listener, IVariableResolverAdapter.Features.Value);
	}
}
