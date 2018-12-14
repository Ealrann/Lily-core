package org.sheepy.common.api.action.context;

import org.sheepy.common.model.action.Action;
import org.sheepy.common.model.root.LObject;
import org.sheepy.common.model.types.Parameter;

public class ExecutionContext
{
	private final Action action;
	private final Parameter parameter;
	private final LObject unit;

	public ExecutionContext(LObject unit, Action action, Parameter parameter)
	{
		this.action = action;
		this.parameter = parameter;
		this.unit = unit;
	}
	
	public LObject getLUnit()
	{
		return unit;
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
