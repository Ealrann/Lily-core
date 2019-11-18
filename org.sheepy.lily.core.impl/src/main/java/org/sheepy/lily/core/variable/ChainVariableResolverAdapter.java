package org.sheepy.lily.core.variable;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.util.FeatureDefinition;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.variable.ChainVariableResolver;

@Adapter(scope = ChainVariableResolver.class)
public class ChainVariableResolverAdapter
		extends AbstractDefinedVariableResolverAdapter<ChainVariableResolver>
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
		final Object value = resolvedTarget.eGet(featureDefinition.feature);

		return value;
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
		final var firstAdapter = firstResolver.adaptNotNull(IVariableResolverAdapter.class);
		@SuppressWarnings("unchecked")
		var resolvedTarget = (ILilyEObject) firstAdapter.getValue(firstResolver);

		for (int i = 0; i < variableResolver.getSubResolvers().size() - 1; i++)
		{
			final var chainResolver = variableResolver.getSubResolvers().get(i);
			final var resolvedDefinition = definitionMap.get(chainResolver.getVariableDefinition());
			resolvedTarget = (ILilyEObject) resolvedTarget.eGet(resolvedDefinition.feature);
		}

		return resolvedTarget;
	}

	@Override
	protected FeatureDefinition getFeatureDefinition()
	{
		final var subResolvers = resolver.getSubResolvers();
		final var lastResolver = subResolvers.get(subResolvers.size() - 1);
		final var featureDefinition = definitionMap.get(lastResolver.getVariableDefinition());
		return featureDefinition;
	}

	@Override
	protected ILilyEObject getResolvedTarget()
	{
		return resolveTargetObject(resolver);
	}
}
