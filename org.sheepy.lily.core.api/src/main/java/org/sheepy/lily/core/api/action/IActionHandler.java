package org.sheepy.lily.core.api.action;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.core.api.action.context.ActionExecutionContext;
import org.sheepy.lily.core.api.service.IService;

public interface IActionHandler extends IService
{
	void handle(ActionExecutionContext context);
	EClass getSupportedAction();

	boolean handleSubClasses();

	static List<IActionHandler> HANDLERS = StreamSupport
			.stream(ServiceLoader.load(IActionHandler.class).spliterator(), false)
			.collect(Collectors.toList());
}
