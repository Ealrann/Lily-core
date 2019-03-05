package org.sheepy.lily.core.variable;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.util.FeatureDefinition;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.variable.ChainResolver;
import org.sheepy.lily.core.model.variable.ChainVariableResolver;

@Adapter(scope = ChainVariableResolver.class)
public class ChainVariableResolverAdapter
		extends AbstractVariableResolverAdapter<ChainVariableResolver>
{
	private final Map<String, FeatureDefinition> definitionMap = new HashMap<>();
	private final ChainVariableResolver resolver;

	public ChainVariableResolverAdapter(ChainVariableResolver resolver)
	{
		this.resolver = resolver;
		for (ChainResolver chainResolver : resolver.getSubResolvers())
		{
			var variableDefinition = chainResolver.getVariableDefinition();
			var featureDefinition = new FeatureDefinition(variableDefinition);
			definitionMap.put(variableDefinition, featureDefinition);
		}
	}

	@Override
	public Object getValue(ChainVariableResolver variableResolver)
	{
		EObject resolvedTarget = resolveTargetObject(variableResolver);
		var subResolvers = variableResolver.getSubResolvers();
		var lastResolver = subResolvers.get(subResolvers.size() - 1);
		var featureDefinition = definitionMap.get(lastResolver.getVariableDefinition());
		Object value = resolvedTarget.eGet(featureDefinition.feature);

		return value;
	}

	@Override
	public void setValue(ChainVariableResolver variableResolver, Object object)
	{
		EObject resolvedTarget = resolveTargetObject(variableResolver);
		var subResolvers = variableResolver.getSubResolvers();
		var lastResolver = subResolvers.get(subResolvers.size() - 1);
		var featureDefinition = definitionMap.get(lastResolver.getVariableDefinition());

		resolvedTarget.eSet(featureDefinition.feature, object);
	}

	private EObject resolveTargetObject(ChainVariableResolver variableResolver)
	{
		var firstResolver = variableResolver.getFirstResolver();
		var firstAdapter = IVariableResolverAdapter.adapt(firstResolver);
		EObject resolvedTarget = (EObject) firstAdapter.getValue(firstResolver);

		for (int i = 0; i < variableResolver.getSubResolvers().size() - 1; i++)
		{
			ChainResolver chainResolver = variableResolver.getSubResolvers().get(i);

			var resolvedDefinition = definitionMap.get(chainResolver.getVariableDefinition());
			Object value = resolvedTarget.eGet(resolvedDefinition.feature);

			resolvedTarget = (EObject) value;
		}

		return resolvedTarget;
	}

	@Override
	protected FeatureDefinition getFeatureDefinition()
	{
		var subResolvers = resolver.getSubResolvers();
		var lastResolver = subResolvers.get(subResolvers.size() - 1);
		var featureDefinition = definitionMap.get(lastResolver.getVariableDefinition());
		return featureDefinition;
	}

	@Override
	protected EObject getResolvedTarget()
	{
		return resolveTargetObject(resolver);
	}
}
