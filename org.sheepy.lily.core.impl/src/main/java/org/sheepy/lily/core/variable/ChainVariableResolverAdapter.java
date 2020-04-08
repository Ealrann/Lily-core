package org.sheepy.lily.core.variable;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.util.FeatureDefinition;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.variable.ChainVariableResolver;
import org.sheepy.lily.core.model.variable.IVariableResolver;

import java.util.HashMap;
import java.util.Map;

@Adapter(scope = ChainVariableResolver.class)
public class ChainVariableResolverAdapter extends AbstractDefinedVariableResolverAdapter<ChainVariableResolver>
{
	private final Map<String, FeatureDefinition> definitionMap = new HashMap<>();
	private final ChainVariableResolver resolver;

	public ChainVariableResolverAdapter(ChainVariableResolver resolver)
	{
		this.resolver = resolver;
		for (final var chainResolver : resolver.getSubResolvers())
		{
			final var variableDefinition = chainResolver.getVariableDefinition();
			final var featureDefinition = new FeatureDefinition(variableDefinition);
			definitionMap.put(variableDefinition, featureDefinition);
		}
	}

	@Override
	public Object getValue(ChainVariableResolver variableResolver)
	{
		final var resolvedTarget = resolveTargetObject(variableResolver);
		final var subResolvers = variableResolver.getSubResolvers();
		final var lastResolver = subResolvers.get(subResolvers.size() - 1);
		final var featureDefinition = definitionMap.get(lastResolver.getVariableDefinition());

		return resolvedTarget.eGet(featureDefinition.feature);
	}

	@Override
	public void setValue(ChainVariableResolver variableResolver, Object object)
	{
		final EObject resolvedTarget = resolveTargetObject(variableResolver);
		final var subResolvers = variableResolver.getSubResolvers();
		final var lastResolver = subResolvers.get(subResolvers.size() - 1);
		final var featureDefinition = definitionMap.get(lastResolver.getVariableDefinition());

		resolvedTarget.eSet(featureDefinition.feature, object);
	}

	private ILilyEObject resolveTargetObject(ChainVariableResolver variableResolver)
	{
		final var firstResolver = variableResolver.getFirstResolver();
		var resolvedTarget = resolveTarget(firstResolver);

		final var subResolvers = variableResolver.getSubResolvers();
		for (int i = 0; i < subResolvers.size() - 1; i++)
		{
			final var chainResolver = subResolvers.get(i);
			final var resolvedDefinition = definitionMap.get(chainResolver.getVariableDefinition());
			resolvedTarget = (ILilyEObject) resolvedTarget.eGet(resolvedDefinition.feature);
		}

		return resolvedTarget;
	}

	private static <T extends IVariableResolver> ILilyEObject resolveTarget(T resolver)
	{
		final var firstAdapter = resolver.<IVariableResolverAdapter<T>>adaptNotNullGeneric(IVariableResolverAdapter.class);
		return (ILilyEObject) firstAdapter.getValue(resolver);
	}

	@Override
	protected FeatureDefinition getFeatureDefinition()
	{
		final var subResolvers = resolver.getSubResolvers();
		final var lastResolver = subResolvers.get(subResolvers.size() - 1);
		return definitionMap.get(lastResolver.getVariableDefinition());
	}

	@Override
	protected ILilyEObject getResolvedTarget()
	{
		return resolveTargetObject(resolver);
	}
}
