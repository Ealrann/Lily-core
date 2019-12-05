package org.sheepy.lily.core.api.action.context;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.model.action.Action;
import org.sheepy.lily.core.model.types.Parameter;

public class ActionExecutionContext
{
	private final Action action;
	private final Parameter parameter;
	private final EObject object;

	public ActionExecutionContext(EObject object, Action action, Parameter parameter)
	{
		this.action = action;
		this.parameter = parameter;
		this.object = object;
	}

	public EObject getObject()
	{
		return object;
	}

	public Action getAction()
	{
		return action;
	}

	public Object getParameter()
	{
		return parameter;
	}
}
