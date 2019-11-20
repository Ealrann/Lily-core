package org.sheepy.lily.core.adapter.reflect.impl;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.util.function.BiConsumer;

import org.sheepy.lily.core.adapter.reflect.ExecutionHandle;
import org.sheepy.lily.core.adapter.reflect.util.ReflectUtil;
import org.sheepy.lily.core.api.adapter.IAdapter;

public final class ExecutionHandle2Param implements ExecutionHandle
{
	private final BiConsumer<Object, Object> consumer;

	private ExecutionHandle2Param(BiConsumer<Object, Object> consumer)
	{
		this.consumer = consumer;
	}

	@Override
	public void invoke(Object... parameters)
	{
		consumer.accept(parameters[0], parameters[1]);
	}

	@Override
	public Object getLambdaFunction()
	{
		return consumer;
	}

	public static final class Builder extends ExecutionHandle.Builder
	{
		private final MethodHandle factory;

		public Builder(Lookup lookup, MethodHandle methodHandle, Class<?> type)
		{
			factory = ReflectUtil.createBiConsumerFactory(lookup, methodHandle, type);
		}

		@Override
		public ExecutionHandle build(IAdapter adapter)
		{
			try
			{
				final var consumer = (BiConsumer<Object, Object>) factory.invoke(adapter);
				return new ExecutionHandle2Param(consumer);

			} catch (final Throwable e)
			{
				e.printStackTrace();
				return null;
			}
		}
	}

	public static final class StaticBuilder extends ExecutionHandle.Builder
	{
		private final ExecutionHandle handle;

		public StaticBuilder(Lookup lookup, MethodHandle methodHandle)
		{
			final var consumer = ReflectUtil.createBiConsumer(lookup, methodHandle);
			handle = new ExecutionHandle2Param(consumer);
		}

		@Override
		public ExecutionHandle build(IAdapter adapter)
		{
			return handle;
		}
	}
}
