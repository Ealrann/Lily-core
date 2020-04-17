package org.sheepy.lily.core.reflect.execution;

import org.sheepy.lily.core.reflect.util.ReflectionUtil;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.lang.invoke.LambdaConversionException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.util.function.Consumer;

public final class ConsumerHandle1Param implements ConsumerHandle
{
	private final Consumer<Object> consumer;

	private ConsumerHandle1Param(Consumer<Object> consumer)
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

	public static final class Builder extends ConsumerHandleBuilder
	{
		private final MethodHandle factory;

		public Builder(Lookup lookup, MethodHandle methodHandle, Class<?> type) throws LambdaConversionException
		{
			factory = ReflectionUtil.createConsumerFactory(lookup, methodHandle, type);
		}

		@Override
		@SuppressWarnings("unchecked")
		public ConsumerHandle build(Object target)
		{
			try
			{
				final var consumer = (Consumer<Object>) factory.invoke(target);
				return new ConsumerHandle1Param(consumer);

			}
			catch (final Throwable e)
			{
				e.printStackTrace();
				return null;
			}
		}
	}

	public static final class StaticBuilder extends ConsumerHandleBuilder
	{
		private final ConsumerHandle handle;

		public StaticBuilder(Lookup lookup, MethodHandle methodHandle) throws Throwable
		{
			final var consumer = ReflectionUtil.createConsumer(lookup, methodHandle);
			handle = new ConsumerHandle1Param(consumer);
		}

		@Override
		public ConsumerHandle build(Object target)
		{
			return handle;
		}
	}
}
