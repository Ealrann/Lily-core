package org.sheepy.lily.core.reflect.execution;

import org.sheepy.lily.core.reflect.util.ReflectionUtil;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.lang.invoke.LambdaConversionException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.util.function.BiConsumer;

public final class ConsumerHandle2Param implements ConsumerHandle
{
	private final BiConsumer<Object, Object> consumer;

	private ConsumerHandle2Param(BiConsumer<Object, Object> consumer)
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

	public static final class Builder extends ConsumerHandleBuilder
	{
		private final MethodHandle factory;

		public Builder(Lookup lookup, MethodHandle methodHandle, Class<?> type) throws LambdaConversionException
		{
			factory = ReflectionUtil.createBiConsumerFactory(lookup, methodHandle, type);
		}

		@Override
		@SuppressWarnings("unchecked")
		public ConsumerHandle build(Object target)
		{
			try
			{
				final var consumer = (BiConsumer<Object, Object>) factory.invoke(target);
				return new ConsumerHandle2Param(consumer);

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
			final var consumer = ReflectionUtil.createBiConsumer(lookup, methodHandle);
			handle = new ConsumerHandle2Param(consumer);
		}

		@Override
		public ConsumerHandle build(Object target)
		{
			return handle;
		}
	}
}
