package org.sheepy.lily.core.adapter.reflect.impl;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.util.function.BiConsumer;

import org.sheepy.lily.core.adapter.reflect.ExecutionHandle;
import org.sheepy.lily.core.adapter.reflect.util.ReflectUtil;
import org.sheepy.lily.core.api.adapter.IAdapter;

public final class ExecutionHandleParam1<T extends IAdapter> extends AbstractExecutionHandle<T>
{
	private final BiConsumer<T, Object> consumer;

	private ExecutionHandleParam1(T adapter, BiConsumer<T, Object> consumer)
	{
		super(adapter);
		this.consumer = consumer;
	}

	@Override
	public void invoke(Object... parameters)
	{
		consumer.accept(adapter, parameters[0]);
	}

	public static final class Builder<T extends IAdapter> extends ExecutionHandle.Builder<T>
	{
		private final BiConsumer<T, Object> consumer;

		public Builder(Lookup lookup, MethodHandle methodHandle)
		{
			this.consumer = ReflectUtil.createBiConsumer(lookup, methodHandle);
		}

		@Override
		public ExecutionHandle build(T adapter)
		{
			return new ExecutionHandleParam1<>(adapter, consumer);
		}
	}
}
