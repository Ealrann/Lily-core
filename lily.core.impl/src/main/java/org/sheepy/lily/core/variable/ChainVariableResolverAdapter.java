package org.sheepy.lily.core.variable;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.sheepy.lily.core.api.util.FeatureDefinition;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.variable.ChainResolver;
import org.sheepy.lily.core.model.variable.ChainVariableResolver;
import org.sheepy.lily.core.model.variable.IVariableResolver;

import java.util.HashMap;
import java.util.Map;

@ModelExtender(scope = ChainVariableResolver.class)
@Adapter
public final class ChainVariableResolverAdapter extends AbstractDefinedVariableResolverAdapter<ChainVariableResolver>
{
	private final Map<String, FeatureDefinition> definitionMap = new HashMap<>();
	private final ChainVariableResolver resolver;

	public ChainVariableResolverAdapter(final ChainVariableResolver resolver)
	{
		this.resolver = resolver;
		for (final var chainResolver : resolver.subResolvers())
		{
			final var variableDefinition = chainResolver.variableDefinition();
			definitionMap.put(variableDefinition, new FeatureDefinition(variableDefinition));
		}
	}

	@Override
	public Object getValue(final ChainVariableResolver variableResolver)
	{
		final var resolvedTarget = resolveTargetObject(variableResolver);
		final var lastResolver = last(variableResolver);
		final var featureDefinition = definitionMap.get(lastResolver.variableDefinition());

		return resolvedTarget.get(featureDefinition.feature.id());
	}

	@Override
	public void setValue(final ChainVariableResolver variableResolver, final Object object)
	{
		final var resolvedTarget = resolveTargetObject(variableResolver);
		final var lastResolver = last(variableResolver);
		final var featureDefinition = definitionMap.get(lastResolver.variableDefinition());

		resolvedTarget.set(featureDefinition.feature.id(), object);
	}

	private IFeaturedObject resolveTargetObject(final ChainVariableResolver variableResolver)
	{
		final var firstResolver = variableResolver.firstResolver();
		var resolvedTarget = resolveTarget(firstResolver);

		final var subResolvers = variableResolver.subResolvers();
		for (int i = 0; i < subResolvers.size() - 1; i++)
		{
			final ChainResolver chainResolver = subResolvers.get(i);
			final var resolvedDefinition = definitionMap.get(chainResolver.variableDefinition());
			final var next = resolvedTarget.get(resolvedDefinition.feature.id());
			resolvedTarget = (IFeaturedObject) next;
		}

		return resolvedTarget;
	}

	private static <T extends IVariableResolver> IFeaturedObject resolveTarget(final T resolver)
	{
		final var firstAdapter = resolver.<IVariableResolverAdapter<T>>adaptNotNullGeneric(IVariableResolverAdapter.class);
		return (IFeaturedObject) firstAdapter.getValue(resolver);
	}

	private static ChainResolver last(final ChainVariableResolver variableResolver)
	{
		final var subResolvers = variableResolver.subResolvers();
		return subResolvers.get(subResolvers.size() - 1);
	}

	@Override
	protected FeatureDefinition getFeatureDefinition()
	{
		final var lastResolver = last(resolver);
		return definitionMap.get(lastResolver.variableDefinition());
	}

	@Override
	protected IFeaturedObject getResolvedTarget()
	{
		return resolveTargetObject(resolver);
	}
}
