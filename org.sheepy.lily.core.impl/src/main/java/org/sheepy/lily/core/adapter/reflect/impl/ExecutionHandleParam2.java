package org.sheepy.lily.core.adapter.reflect.impl;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;

import org.sheepy.lily.core.adapter.reflect.ExecutionHandle;
import org.sheepy.lily.core.adapter.reflect.util.ReflectUtil;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.util.TriConsumer;

public final class ExecutionHandleParam2<T extends IAdapter> extends AbstractExecutionHandle<T>
{
	private final TriConsumer<T, Object, Object> consumer;

	private ExecutionHandleParam2(T adapter, TriConsumer<T, Object, Object> consumer)
	{
		super(adapter);
		this.consumer = consumer;
	}

	@Override
	public void invoke(Object... parameters)
	{
		consumer.accept(adapter, parameters[0], parameters[1]);
	}

	public static final class Builder<T extends IAdapter> extends ExecutionHandle.Builder<T>
	{
		private final TriConsumer<T, Object, Object> consumer;

		public Builder(Lookup lookup, MethodHandle methodHandle)
		{
			this.consumer = ReflectUtil.createTriConsumer(lookup, methodHandle);
		}

		@Override
		public ExecutionHandle build(T adapter)
		{
			return new ExecutionHandleParam2<>(adapter, consumer);
		}
	}
}
