package org.sheepy.common.api.action;

import org.sheepy.common.api.action.context.ExecutionContext;
import org.sheepy.common.api.service.IService;
import org.sheepy.common.api.service.ServiceManager;

public interface IActionDispatcher extends IService
{
	void postAction(ExecutionContext executionContext);
	// void postActions(Collection<IExecutionContext> executionContexts);

	// void bindActionHandler(IActionHandler handler);
	// void unbindActionHandler(IActionHandler handler);

	static IActionDispatcher getService()
	{
		return ServiceManager.getService(IActionDispatcher.class);
	}
}
