package org.sheepy.lily.core.reflect.execution;

import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.lang.invoke.LambdaConversionException;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final class ConsumerHandle1ParamLong implements ConsumerHandle
{
	private final LongConsumer consumer;

	private ConsumerHandle1ParamLong(LongConsumer consumer)
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

	public static final class Builder extends ConsumerHandleBuilder
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
		public ConsumerHandle build(Object target)
		{
			try
			{
				final var consumer = (LongConsumer) factory.invoke(target);
				return new ConsumerHandle1ParamLong(consumer);

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
			final var site = LambdaMetafactory.metafactory(lookup,
														   "accept",
														   MethodType.methodType(Consumer.class),
														   MethodType.methodType(Void.TYPE, Long.TYPE),
														   methodHandle,
														   methodHandle.type());

			final var consumer = (LongConsumer) site.getTarget().invoke();
			handle = new ConsumerHandle1ParamLong(consumer);
		}

		@Override
		public ConsumerHandle build(Object target)
		{
			return handle;
		}
	}
}
