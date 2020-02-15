package org.sheepy.lily.core.api.variable;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.model.variable.IModelVariableAction;

public interface IModelVariableActionAdapter extends IAdapter
{
	void execute(IModelVariableAction action);
}
