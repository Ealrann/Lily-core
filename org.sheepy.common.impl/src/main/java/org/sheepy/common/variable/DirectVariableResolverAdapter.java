package org.sheepy.common.variable;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.impl.AbstractStatefullAdapter;
import org.sheepy.common.api.util.ResolvedVariableFeature;
import org.sheepy.common.api.variable.IVariableResolverAdapter;
import org.sheepy.common.model.variable.DirectVariableResolver;
import org.sheepy.common.model.variable.VariablePackage;

public class DirectVariableResolverAdapter extends AbstractStatefullAdapter
		implements IVariableResolverAdapter<DirectVariableResolver>
{

	private ResolvedVariableFeature resolvedDefinition;

	@Override
	public void setTarget(Notifier newTarget)
	{
		super.setTarget(newTarget);

		DirectVariableResolver variableResolver = (DirectVariableResolver) target;
		String variableDefinition = variableResolver.getVariableDefinition();
		resolvedDefinition = new ResolvedVariableFeature(variableDefinition);
	}

	@Override
	public String getValue(DirectVariableResolver variableResolver)
	{
		EObject target = variableResolver.getTarget();

		Object value = target.eGet(resolvedDefinition.feature);

		String res = "";
		if (value != null)
		{
			res = String.valueOf(value);
		}

		return res;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return VariablePackage.Literals.DIRECT_VARIABLE_RESOLVER == eClass;
	}
}
