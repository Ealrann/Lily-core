package org.sheepy.lily.core.variable;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.util.FeatureDefinition;
import org.sheepy.lily.core.model.variable.DirectVariableResolver;

@Adapter(scope = DirectVariableResolver.class)
public class DirectVariableResolverAdapter
		extends AbstractVariableResolverAdapter<DirectVariableResolver>
{
	private final FeatureDefinition resolvedDefinition;
	private final DirectVariableResolver resolver;

	public DirectVariableResolverAdapter(DirectVariableResolver resolver)
	{
		this.resolver = resolver;
		String variableDefinition = resolver.getVariableDefinition();
		resolvedDefinition = new FeatureDefinition(variableDefinition);
	}

	@Override
	public Object getValue(DirectVariableResolver variableResolver)
	{
		EObject target = variableResolver.getTarget();
		return target.eGet(resolvedDefinition.feature);
	}

	@Override
	public void setValue(DirectVariableResolver variableResolver, Object object)
	{
		EObject target = variableResolver.getTarget();
		target.eSet(resolvedDefinition.feature, object);
	}

	@Override
	protected FeatureDefinition getFeatureDefinition()
	{
		return resolvedDefinition;
	}

	@Override
	protected EObject getResolvedTarget()
	{
		return resolver.getTarget();
	}
}
