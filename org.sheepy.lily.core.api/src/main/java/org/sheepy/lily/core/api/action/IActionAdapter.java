package org.sheepy.lily.core.api.action;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.core.model.action.Action;

public interface IActionAdapter<T extends Action> extends IAdapter
{
	void execute(T action);
}
