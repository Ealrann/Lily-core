package org.sheepy.lily.core.api.action;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.model.action.Action;

public interface IActionAdapter<T extends Action> extends IExtender
{
	void execute(T action);
}
