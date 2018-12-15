package org.sheepy.common.api.action;

import java.util.ServiceLoader;

import org.sheepy.common.api.action.context.ExecutionContext;
import org.sheepy.common.api.service.IService;

public interface IActionDispatcher extends IService
{
	void postAction(ExecutionContext executionContext);
	// void postActions(Collection<IExecutionContext> executionContexts);

	// void bindActionHandler(IActionHandler handler);
	// void unbindActionHandler(IActionHandler handler);

	static IActionDispatcher INSTANCE = ServiceLoader.load(IActionDispatcher.class).findFirst()
			.get();
}
