package org.sheepy.lily.core.variable.action;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.variable.IModelVariableActionAdapter;
import org.sheepy.lily.core.api.variable.IModelVariableAdapter;
import org.sheepy.lily.core.model.variable.IModelVariableAction;
import org.sheepy.lily.core.model.variable.SetVariableAction;

@Adapter(scope = SetVariableAction.class)
public class SetVariableActionAdapter implements IModelVariableActionAdapter
{
	@Override
	public void execute(final IModelVariableAction action)
	{
		final var setAction = (SetVariableAction) action;
		final var adapter = setAction.getVariable().adapt(IModelVariableAdapter.class);
		adapter.setValue(setAction.getValue());
	}
}
