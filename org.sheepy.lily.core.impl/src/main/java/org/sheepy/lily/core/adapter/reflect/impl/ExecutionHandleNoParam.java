package org.sheepy.lily.core.adapter.reflect.impl;

import org.sheepy.lily.core.adapter.reflect.ExecutionHandle;
import org.sheepy.lily.core.adapter.reflect.util.ReflectUtil;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.util.Operation;

import java.lang.invoke.LambdaConversionException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;

public final class ExecutionHandleNoParam implements ExecutionHandle
{
	private final Operation operation;

	private ExecutionHandleNoParam(Operation operation)
	{
		this.operation = operation;
	}

	@Override
	public void invoke(Object... parameters)
	{
		operation.execute();
	}

	@Override
	public Object getLambdaFunction()
	{
		return operation;
	}

	public static final class Builder extends ExecutionHandle.Builder
	{
		private final MethodHandle factory;

		public Builder(Lookup lookup, MethodHandle methodHandle, Class<?> type) throws LambdaConversionException
		{
			factory = ReflectUtil.createOperationFactory(lookup, methodHandle, type);
		}

		@Override
		public ExecutionHandle build(IAdapter adapter)
		{
			try
			{
				final var operation = (Operation) factory.invoke(adapter);
				return new ExecutionHandleNoParam(operation);

			}
			catch (final Throwable e)
			{
				e.printStackTrace();
				return null;
			}
		}
	}

	public static final class StaticBuilder extends ExecutionHandle.Builder
	{
		private final ExecutionHandle handle;

		public StaticBuilder(Lookup lookup, MethodHandle methodHandle) throws Throwable
		{
			final var operation = ReflectUtil.createOperation(lookup, methodHandle);
			handle = new ExecutionHandleNoParam(operation);
		}

		@Override
		public ExecutionHandle build(IAdapter adapter)
		{
			return handle;
		}
	}
}
