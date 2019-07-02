package org.sheepy.lily.core.adapter.reflect.impl;

import org.sheepy.lily.core.adapter.reflect.ExecutionHandle.Builder.TriConsumer;
import org.sheepy.lily.core.api.adapter.IAdapter;

public final class ExecutionHandleParam2<T extends IAdapter> extends AbstractExecutionHandle<T>
{
	private final TriConsumer<T, Object, Object> consumer;

	public ExecutionHandleParam2(T adapter, TriConsumer<T, Object, Object> consumer)
	{
		super(adapter);
		this.consumer = consumer;
	}

	@Override
	public void invoke(Object... parameters)
	{
		consumer.accept(adapter, parameters[0], parameters[1]);
	}
}
