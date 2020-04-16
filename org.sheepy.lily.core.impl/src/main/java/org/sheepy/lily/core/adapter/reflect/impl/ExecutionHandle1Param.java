package org.sheepy.lily.core.adapter.reflect.impl;

import org.sheepy.lily.core.api.util.ExecutionHandle;
import org.sheepy.lily.core.adapter.reflect.ExecutionHandleBuilder;
import org.sheepy.lily.core.adapter.reflect.util.ReflectionUtil;
import org.sheepy.lily.core.api.adapter.IAdapter;

import java.lang.invoke.LambdaConversionException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.util.function.Consumer;

public final class ExecutionHandle1Param implements ExecutionHandle
{
	private final Consumer<Object> consumer;

	private ExecutionHandle1Param(Consumer<Object> consumer)
	{
		this.consumer = consumer;
	}

	@Override
	public void invoke(Object... parameters)
	{
		consumer.accept(parameters[0]);
	}

	@Override
	public Object getLambdaFunction()
	{
		return consumer;
	}

	public static final class Builder extends ExecutionHandleBuilder
	{
		private final MethodHandle factory;

		public Builder(Lookup lookup, MethodHandle methodHandle, Class<?> type) throws LambdaConversionException
		{
			factory = ReflectionUtil.createConsumerFactory(lookup, methodHandle, type);
		}

		@Override
		@SuppressWarnings("unchecked")
		public ExecutionHandle build(IAdapter adapter)
		{
			try
			{
				final var consumer = (Consumer<Object>) factory.invoke(adapter);
				return new ExecutionHandle1Param(consumer);

			}
			catch (final Throwable e)
			{
				e.printStackTrace();
				return null;
			}
		}
	}

	public static final class StaticBuilder extends ExecutionHandleBuilder
	{
		private final ExecutionHandle handle;

		public StaticBuilder(Lookup lookup, MethodHandle methodHandle) throws Throwable
		{
			final var consumer = ReflectionUtil.createConsumer(lookup, methodHandle);
			handle = new ExecutionHandle1Param(consumer);
		}

		@Override
		public ExecutionHandle build(IAdapter adapter)
		{
			return handle;
		}
	}
}
