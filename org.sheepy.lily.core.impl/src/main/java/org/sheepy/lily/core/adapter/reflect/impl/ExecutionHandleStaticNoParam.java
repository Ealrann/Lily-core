package org.sheepy.lily.core.adapter.reflect.impl;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;

import org.sheepy.lily.core.adapter.reflect.ExecutionHandle;
import org.sheepy.lily.core.adapter.reflect.util.ReflectUtil;
import org.sheepy.lily.core.api.adapter.IAdapter;

public final class ExecutionHandleStaticNoParam implements ExecutionHandle
{
	private final Operation operation;

	private ExecutionHandleStaticNoParam(Operation operation)
	{
		this.operation = operation;
	}

	@Override
	public void invoke(Object... parameters)
	{
		operation.execute();
	}

	public static final class Builder<T extends IAdapter> extends ExecutionHandle.Builder<T>
	{
		private final Operation operation;

		public Builder(Lookup lookup, MethodHandle methodHandle)
		{
			this.operation = ReflectUtil.createOperation(lookup, methodHandle);
		}

		@Override
		public ExecutionHandle build(T adapter)
		{
			return new ExecutionHandleStaticNoParam(operation);
		}
	}
}
