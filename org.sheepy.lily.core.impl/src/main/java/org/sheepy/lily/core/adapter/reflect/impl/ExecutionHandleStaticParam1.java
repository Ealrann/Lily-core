package org.sheepy.lily.core.adapter.reflect.impl;

import java.util.function.Consumer;

import org.sheepy.lily.core.adapter.reflect.ExecutionHandle;

public final class ExecutionHandleStaticParam1 implements ExecutionHandle 
{

	private final Consumer<Object> consumer;

	public ExecutionHandleStaticParam1(Consumer<Object> consumer)
	{
		this.consumer = consumer;
	}

	@Override
	public void invoke(Object... parameters)
	{
		consumer.accept(parameters[0]);
	}
}
