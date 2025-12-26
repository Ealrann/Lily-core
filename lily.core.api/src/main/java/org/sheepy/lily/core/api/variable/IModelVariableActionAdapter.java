package org.sheepy.lily.core.api.variable;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.sheepy.lily.core.model.variable.IModelVariableAction;

public interface IModelVariableActionAdapter extends IAdapter
{
	void execute(IModelVariableAction action);
}
