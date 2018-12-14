package org.sheepy.common.api.adapter.impl;

import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.adapter.ISingletonAdapter;

public abstract class AbstractSingletonAdapter implements ISingletonAdapter
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
	public boolean isAdapterForType(Class<? extends ISingletonAdapter> type)
	{
		return ((Class<?>) type).isInstance(this);
	}
}
