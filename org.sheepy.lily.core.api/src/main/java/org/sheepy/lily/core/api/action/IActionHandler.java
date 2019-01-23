package org.sheepy.common.api.action;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.action.context.ExecutionContext;
import org.sheepy.common.api.service.IService;

public interface IActionHandler extends IService
{
	void handle(ExecutionContext context);
	EClass getSupportedAction();

	boolean handleSubClasses();

	static List<IActionHandler> HANDLERS = StreamSupport
			.stream(ServiceLoader.load(IActionHandler.class).spliterator(), false)
			.collect(Collectors.toList());
}
