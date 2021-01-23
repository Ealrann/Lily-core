package org.sheepy.lily.core.variable.action;

import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.variable.IModelVariableActionAdapter;
import org.sheepy.lily.core.api.variable.IModelVariableAdapter;
import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.core.model.variable.IModelVariableAction;
import org.sheepy.lily.core.model.variable.SetVariableAction;

@ModelExtender(scope = SetVariableAction.class)
@Adapter(singleton = true)
public final class SetVariableActionAdapter implements IModelVariableActionAdapter
{
	@Override
	public void execute(final IModelVariableAction action)
	{
		final var setAction = (SetVariableAction) action;
		final var variable = setAction.getVariable();
		final var value = setAction.getValue();
		setValue(variable, value);
	}

	private static <T extends IModelVariable> void setValue(T variable, String value)
	{
		final var adapter = variable.<IModelVariableAdapter<T>>adaptGeneric(IModelVariableAdapter.class);
		adapter.setValue(variable, value);
	}
}
