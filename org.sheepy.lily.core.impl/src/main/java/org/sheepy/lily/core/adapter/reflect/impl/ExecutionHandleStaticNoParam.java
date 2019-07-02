package org.sheepy.lily.core.adapter.reflect.impl;

import org.sheepy.lily.core.adapter.reflect.ExecutionHandle;
import org.sheepy.lily.core.adapter.reflect.ExecutionHandle.Builder.Operation;
import org.sheepy.lily.core.api.adapter.IAdapter;

public final class ExecutionHandleStaticNoParam<T extends IAdapter> implements ExecutionHandle
{

	private final Operation operation;

	public ExecutionHandleStaticNoParam(Operation operation)
	{
		this.operation = operation;
	}

	@Override
	public void invoke(Object... parameters)
	{
		operation.execute();
	}
}
