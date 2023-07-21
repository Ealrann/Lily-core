package org.sheepy.lily.core.action;

import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.action.IActionAdapter;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.variable.BooleanChangeAction;
import org.sheepy.lily.core.model.variable.IVariableResolver;

@ModelExtender(scope = BooleanChangeAction.class)
@Adapter
public class BooleanChangeActionAdapter implements IActionAdapter<BooleanChangeAction>
{
	@Override
	public void execute(final BooleanChangeAction action)
	{
		final var resolver = (IVariableResolver) action.getVariableResolver();
		if (resolver != null)
		{
			final IVariableResolverAdapter<IVariableResolver> resolverAdapter = resolver.adaptNotNullGeneric(
					IVariableResolverAdapter.class);
			final var value = (Boolean) resolverAdapter.getValue(resolver);
			resolverAdapter.setValue(resolver, !value);
		}
	}
}
