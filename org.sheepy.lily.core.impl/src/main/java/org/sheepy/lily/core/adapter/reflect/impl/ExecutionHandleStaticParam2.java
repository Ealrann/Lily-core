package org.sheepy.lily.core.adapter.reflect.impl;

import java.util.function.BiConsumer;

import org.sheepy.lily.core.adapter.reflect.ExecutionHandle;

public final class ExecutionHandleStaticParam2 implements ExecutionHandle
{

	private final BiConsumer<Object, Object> consumer;

	public ExecutionHandleStaticParam2(BiConsumer<Object, Object> consumer)
	{
		this.consumer = consumer;
	}

	@Override
	public void invoke(Object... parameters)
	{
		consumer.accept(parameters[0], parameters[1]);
	}
}
