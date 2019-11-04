package org.sheepy.lily.core.api.adapter;

import java.util.ServiceLoader;

public interface IAdapterRegistry
{
	void register(Class<? extends IAdapter> classifier);

	static final IAdapterRegistry INSTANCE = ServiceLoader	.load(IAdapterRegistry.class)
															.findFirst()
															.get();
}
