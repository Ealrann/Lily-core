package org.sheepy.common.api.adapter.impl;

import org.sheepy.common.api.adapter.IServiceAdapter;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;

public abstract class AbstractServiceAdapter implements IServiceAdapter
{
	protected IServiceAdapterFactory adapterFactory;

	public AbstractServiceAdapter()
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
	public IServiceAdapter clone()
	{
		try
		{
			return (IServiceAdapter) super.clone();
		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isAdapterForType(Class<? extends IServiceAdapter> type)
	{
		return ((Class<?>) type).isInstance(this);
	}
}
