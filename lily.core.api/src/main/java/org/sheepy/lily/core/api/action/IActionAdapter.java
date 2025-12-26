package org.sheepy.lily.core.api.action;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.sheepy.lily.core.model.action.Action;

public interface IActionAdapter<T extends Action> extends IAdapter
{
	void execute(T action);
}
