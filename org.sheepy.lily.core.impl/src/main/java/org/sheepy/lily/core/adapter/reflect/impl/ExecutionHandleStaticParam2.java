package org.sheepy.lily.core.adapter.reflect.impl;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.util.function.BiConsumer;

import org.sheepy.lily.core.adapter.reflect.ExecutionHandle;
import org.sheepy.lily.core.adapter.reflect.util.ReflectUtil;
import org.sheepy.lily.core.api.adapter.IAdapter;

public final class ExecutionHandleStaticParam2 implements ExecutionHandle
{
	private final BiConsumer<Object, Object> consumer;

	private ExecutionHandleStaticParam2(BiConsumer<Object, Object> consumer)
	{
		this.consumer = consumer;
	}

	@Override
	public void invoke(Object... parameters)
	{
		consumer.accept(parameters[0], parameters[1]);
	}

	public static final class Builder<T extends IAdapter> extends ExecutionHandle.Builder<T>
	{
		private final BiConsumer<Object, Object> consumer;

		public Builder(Lookup lookup, MethodHandle methodHandle)
		{
			this.consumer = ReflectUtil.createBiConsumer(lookup, methodHandle);
		}

		@Override
		public ExecutionHandle build(T adapter)
		{
			return new ExecutionHandleStaticParam2(consumer);
		}
	}
}
