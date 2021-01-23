package org.logoce.adapter.api;

import org.logoce.extender.api.IAdaptable;
import org.logoce.extender.api.IAdapterManager;

public abstract class BasicAdaptable implements IAdaptable
{
	private final BasicAdapterManager adapterManager = new BasicAdapterManager(this);

	@Override
	public IAdapterManager adapterManager()
	{
		return adapterManager;
	}
}
