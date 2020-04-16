package org.sheepy.lily.core.adapter.reflect.impl;

import org.sheepy.lily.core.api.util.ExecutionHandle;
import org.sheepy.lily.core.adapter.reflect.ExecutionHandleBuilder;
import org.sheepy.lily.core.api.adapter.IAdapter;

import java.lang.invoke.LambdaConversionException;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final class ExecutionHandle1ParamLong implements ExecutionHandle
{
	private final LongConsumer consumer;

	private ExecutionHandle1ParamLong(LongConsumer consumer)
	{
		this.consumer = consumer;
	}

	@Override
	public void invoke(Object... parameters)
	{
		consumer.accept((long) parameters[0]);
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
			final var factoryType = MethodType.methodType(LongConsumer.class, type);
			final var targetType = methodHandle.type().dropParameterTypes(0, 1);
			final var site = LambdaMetafactory.metafactory(lookup,
														   "accept",
														   factoryType,
														   MethodType.methodType(Void.TYPE, Long.TYPE),
														   methodHandle,
														   targetType);
			factory = site.getTarget();
		}

		@Override
		public ExecutionHandle build(IAdapter adapter)
		{
			try
			{
				final var consumer = (LongConsumer) factory.invoke(adapter);
				return new ExecutionHandle1ParamLong(consumer);

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
			final var site = LambdaMetafactory.metafactory(lookup,
														   "accept",
														   MethodType.methodType(Consumer.class),
														   MethodType.methodType(Void.TYPE, Long.TYPE),
														   methodHandle,
														   methodHandle.type());

			final var consumer = (LongConsumer) site.getTarget().invoke();
			handle = new ExecutionHandle1ParamLong(consumer);
		}

		@Override
		public ExecutionHandle build(IAdapter adapter)
		{
			return handle;
		}
	}
}
