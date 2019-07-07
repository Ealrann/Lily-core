package org.sheepy.lily.core.adapter.reflect.impl;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.util.function.Consumer;

import org.sheepy.lily.core.adapter.reflect.ExecutionHandle;
import org.sheepy.lily.core.adapter.reflect.util.ReflectUtil;
import org.sheepy.lily.core.api.adapter.IAdapter;

public final class ExecutionHandleNoParam<T extends IAdapter> extends AbstractExecutionHandle<T>
{
	private final Consumer<T> consumer;

	private ExecutionHandleNoParam(T adapter, Consumer<T> consumer)
	{
		super(adapter);
		this.consumer = consumer;
	}

	@Override
	public void invoke(Object... parameters)
	{
		consumer.accept(adapter);
	}

	public static final class Builder<T extends IAdapter> extends ExecutionHandle.Builder<T>
	{
		private final Consumer<T> consumer;

		public Builder(Lookup lookup, MethodHandle methodHandle)
		{
			this.consumer = ReflectUtil.createConsumer(lookup, methodHandle);
		}

		@Override
		public ExecutionHandle build(T adapter)
		{
			return new ExecutionHandleNoParam<>(adapter, consumer);
		}
	}
}
