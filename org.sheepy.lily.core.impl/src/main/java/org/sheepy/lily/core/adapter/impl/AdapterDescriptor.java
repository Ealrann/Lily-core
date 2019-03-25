package org.sheepy.lily.core.adapter.impl;

class AdapterDescriptor
{
	public final AdapterDomain domain;
	public final AdapterExecutor executor;

	public AdapterDescriptor(AdapterDomain domain, AdapterExecutor executor)
	{
		this.domain = domain;
		this.executor = executor;
	}

	public boolean isNamedAdapter()
	{
		return domain.targetName.isEmpty() == false;
	}
}
