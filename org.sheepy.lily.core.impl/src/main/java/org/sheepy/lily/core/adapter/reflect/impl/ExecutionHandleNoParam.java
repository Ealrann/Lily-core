package org.sheepy.lily.core.adapter.reflect.impl;

import java.util.function.Consumer;

import org.sheepy.lily.core.api.adapter.IAdapter;

public final class ExecutionHandleNoParam<T extends IAdapter> extends AbstractExecutionHandle<T>
{

	private final Consumer<T> consumer;

	public ExecutionHandleNoParam(T adapter, Consumer<T> consumer)
	{
		super(adapter);
		this.consumer = consumer;
	}

	@Override
	public void invoke(Object... parameters)
	{
		consumer.accept(adapter);
	}
}
