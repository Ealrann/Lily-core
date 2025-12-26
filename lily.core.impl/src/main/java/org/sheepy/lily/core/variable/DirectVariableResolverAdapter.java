package org.sheepy.lily.core.variable;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.sheepy.lily.core.api.util.FeatureDefinition;
import org.sheepy.lily.core.model.variable.DirectVariableResolver;

@ModelExtender(scope = DirectVariableResolver.class)
@Adapter
public final class DirectVariableResolverAdapter extends AbstractDefinedVariableResolverAdapter<DirectVariableResolver>
{
	private final FeatureDefinition resolvedDefinition;
	private final DirectVariableResolver resolver;

	public DirectVariableResolverAdapter(final DirectVariableResolver resolver)
	{
		this.resolver = resolver;
		resolvedDefinition = new FeatureDefinition(resolver.variableDefinition());
	}

	@Override
	public Object getValue(final DirectVariableResolver variableResolver)
	{
		final var target = (IFeaturedObject) variableResolver.target();
		return target.get(resolvedDefinition.feature.id());
	}

	@Override
	public void setValue(final DirectVariableResolver variableResolver, final Object object)
	{
		final var target = (IFeaturedObject) variableResolver.target();
		target.set(resolvedDefinition.feature.id(), object);
	}

	@Override
	protected FeatureDefinition getFeatureDefinition()
	{
		return resolvedDefinition;
	}

	@Override
	protected IFeaturedObject getResolvedTarget()
	{
		return (IFeaturedObject) resolver.target();
	}
}
