package org.sheepy.common.api.adapter.impl;

import org.sheepy.common.api.adapter.ISingletonAdapter;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;

public abstract class AbstractAdapter implements ISingletonAdapter
{
	protected IServiceAdapterFactory adapterFactory;

	public AbstractAdapter()
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
	public ISingletonAdapter clone()
	{
		try
		{
			return (ISingletonAdapter) super.clone();
		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isAdapterForType(Class<? extends ISingletonAdapter> type)
	{
		return ((Class<?>) type).isInstance(this);
	}
}
