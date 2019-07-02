package org.sheepy.lily.core.adapter.reflect.impl;

import org.sheepy.lily.core.adapter.reflect.ExecutionHandle;
import org.sheepy.lily.core.api.adapter.IAdapter;

public abstract class AbstractExecutionHandle<T extends IAdapter> implements ExecutionHandle
{
	protected final T adapter;

	public AbstractExecutionHandle(T adapter)
	{
		this.adapter = adapter;
	}
}
