package org.sheepy.lily.core.adapter.impl;

import org.sheepy.lily.core.api.adapter.IAdapter;

class AdapterDescriptor<T extends IAdapter>
{
	public final AdapterDomain<T> domain;
	public final AdapterExecutor<T> executor;

	public AdapterDescriptor(AdapterDomain<T> domain, AdapterExecutor<T> executor)
	{
		this.domain = domain;
		this.executor = executor;
	}

	public boolean isNamedAdapter()
	{
		return domain.targetName.isEmpty() == false;
	}
}
