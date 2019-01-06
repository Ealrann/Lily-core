package org.sheepy.common.variable;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.impl.AbstractStatefullAdapter;
import org.sheepy.common.api.util.FeatureDefinition;
import org.sheepy.common.api.variable.IVariableResolverAdapter;
import org.sheepy.common.model.variable.DirectVariableResolver;
import org.sheepy.common.model.variable.VariablePackage;

public class DirectVariableResolverAdapter extends AbstractStatefullAdapter
		implements IVariableResolverAdapter<DirectVariableResolver>
{
	private FeatureDefinition resolvedDefinition;

	@Override
	public void setTarget(Notifier newTarget)
	{
		super.setTarget(newTarget);

		DirectVariableResolver variableResolver = (DirectVariableResolver) target;
		String variableDefinition = variableResolver.getVariableDefinition();
		resolvedDefinition = new FeatureDefinition(variableDefinition);
	}

	@Override
	public Object getValue(DirectVariableResolver variableResolver)
	{
		EObject target = variableResolver.getTarget();
		Object value = target.eGet(resolvedDefinition.feature);

		return value;
	}

	@Override
	public void setValue(DirectVariableResolver variableResolver, Object object)
	{
		EObject target = variableResolver.getTarget();
		target.eSet(resolvedDefinition.feature, object);
	}

	@Override
	public EObject getTarget(DirectVariableResolver variableResolver)
	{
		return variableResolver.getTarget();
	}

	@Override
	public FeatureDefinition getFeatureDefinition(DirectVariableResolver variableResolver)
	{
		return resolvedDefinition;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return VariablePackage.Literals.DIRECT_VARIABLE_RESOLVER == eClass;
	}
}
