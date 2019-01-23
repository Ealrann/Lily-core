package org.sheepy.common.action;

import java.util.List;

import org.sheepy.common.api.action.IActionHandler;
import org.sheepy.common.api.service.ServiceManager;
import org.sheepy.common.model.action.Action;

public class ActionHandlerRegistry
{
	private List<IActionHandler> handlers = null;

	public IActionHandler getHandler(Action action)
	{
		if (handlers == null)
		{
			handlers = ServiceManager.getServices(IActionHandler.class);
		}

		for (IActionHandler handler : handlers)
		{
			if (handler.getSupportedAction() == action.eClass()
					|| handler.getSupportedAction().isSuperTypeOf(action.eClass()))
			{
				return handler;
			}
		}
		return null;
	}
}
