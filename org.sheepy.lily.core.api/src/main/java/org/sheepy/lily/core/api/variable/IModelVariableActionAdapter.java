package org.sheepy.lily.core.api.variable;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.model.variable.IModelVariableAction;

public interface IModelVariableActionAdapter extends IExtender
{
	void execute(IModelVariableAction action);
}
