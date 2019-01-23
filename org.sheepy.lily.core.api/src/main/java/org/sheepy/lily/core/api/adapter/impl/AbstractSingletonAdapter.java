package org.sheepy.lily.core.api.adapter.impl;

import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.IAdapter;

public abstract class AbstractSingletonAdapter implements IAdapter
{
	protected IServiceAdapterFactory adapterFactory;

	public AbstractSingletonAdapter()
	{
		super();
	}

	@Override
	public final void setAdapterFactory(IServiceAdapterFactory adapterFactory)
	{
		this.adapterFactory = adapterFactory;
	}

	@Override
	public final IServiceAdapterFactory getAdapterFactory()
	{
		return adapterFactory;
	}

	@Override
	public boolean isAdapterForType(Class<? extends IAdapter> type)
	{
		return ((Class<?>) type).isInstance(this);
	}
}
