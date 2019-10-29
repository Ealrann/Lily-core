package org.sheepy.lily.core.variable;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
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
		final String variableDefinition = resolver.getVariableDefinition();
		resolvedDefinition = new FeatureDefinition(variableDefinition);
	}

	@Override
	public Object getValue(DirectVariableResolver variableResolver)
	{
		final EObject target = variableResolver.getTarget();
		return target.eGet(resolvedDefinition.feature);
	}

	@Override
	public void setValue(DirectVariableResolver variableResolver, Object object)
	{
		final EObject target = variableResolver.getTarget();
		target.eSet(resolvedDefinition.feature, object);
	}

	@Override
	protected FeatureDefinition getFeatureDefinition()
	{
		return resolvedDefinition;
	}

	@Override
	protected ILilyEObject getResolvedTarget()
	{
		return (ILilyEObject) resolver.getTarget();
	}
}
