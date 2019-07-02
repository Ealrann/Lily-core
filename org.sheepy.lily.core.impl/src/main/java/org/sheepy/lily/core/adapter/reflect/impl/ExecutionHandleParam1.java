package org.sheepy.lily.core.adapter.reflect.impl;

import java.util.function.BiConsumer;

import org.sheepy.lily.core.api.adapter.IAdapter;

public final class ExecutionHandleParam1<T extends IAdapter> extends AbstractExecutionHandle<T>
{

	private final BiConsumer<T, Object> consumer;

	public ExecutionHandleParam1(T adapter, BiConsumer<T, Object> consumer)
	{
		super(adapter);
		this.consumer = consumer;
	}

	@Override
	public void invoke(Object... parameters)
	{
		consumer.accept(adapter, parameters[0]);
	}
}
