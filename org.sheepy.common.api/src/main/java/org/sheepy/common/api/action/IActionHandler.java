package org.sheepy.common.api.action;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.action.context.ExecutionContext;
import org.sheepy.common.api.service.IService;

public interface IActionHandler extends IService
{
	void handle(ExecutionContext context);
	EClass getSupportedAction();

	boolean handleSubClasses();
}
