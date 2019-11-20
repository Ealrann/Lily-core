package org.sheepy.lily.core.adapter.reflect.impl;

import java.lang.invoke.LambdaConversionException;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.util.function.ObjLongConsumer;

import org.sheepy.lily.core.adapter.reflect.ExecutionHandle;
import org.sheepy.lily.core.api.adapter.IAdapter;

public final class ExecutionHandle2ParamObjLong implements ExecutionHandle
{
	private static final MethodType METHOD_TYPE = MethodType.methodType(Void.TYPE,
																		Object.class,
																		Long.TYPE);

	private final ObjLongConsumer<Object> consumer;

	private ExecutionHandle2ParamObjLong(ObjLongConsumer<Object> consumer)
	{
		this.consumer = consumer;
	}

	@Override
	public void invoke(Object... parameters)
	{
		consumer.accept(parameters[0], (long) parameters[1]);
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
				throws LambdaConversionException
		{
			final var factoryType = MethodType.methodType(ObjLongConsumer.class, type);
			final var targetType = methodHandle.type().dropParameterTypes(0, 1);
			final var site = LambdaMetafactory.metafactory(	lookup,
															"accept",
															factoryType,
															METHOD_TYPE,
															methodHandle,
															targetType);
			factory = site.getTarget();
		}

		@Override
		public ExecutionHandle build(IAdapter adapter)
		{
			try
			{
				final var consumer = (ObjLongConsumer<Object>) factory.invoke(adapter);
				return new ExecutionHandle2ParamObjLong(consumer);

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

		public StaticBuilder(Lookup lookup, MethodHandle methodHandle) throws Throwable
		{
			final var site = LambdaMetafactory.metafactory(	lookup,
															"accept",
															MethodType.methodType(ObjLongConsumer.class),
															METHOD_TYPE,
															methodHandle,
															methodHandle.type());

			final var consumer = (ObjLongConsumer<Object>) site.getTarget().invoke();
			handle = new ExecutionHandle2ParamObjLong(consumer);
		}

		@Override
		public ExecutionHandle build(IAdapter adapter)
		{
			return handle;
		}
	}
}
