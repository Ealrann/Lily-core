package org.sheepy.lily.core.api.action;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.model.action.Action;

public interface IActionAdapter<T extends Action> extends IAdapter
{
	void execute(T action);
}
