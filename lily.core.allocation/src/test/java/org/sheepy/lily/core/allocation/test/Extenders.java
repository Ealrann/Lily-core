package org.sheepy.lily.core.allocation.test;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.extender.IAdapterProvider;
import org.sheepy.lily.core.allocation.test.adapters.*;

import java.lang.invoke.MethodHandles;
import java.util.List;

public final class Extenders implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(RootAllocation.class,
					   ContainerAllocation.class,
					   NodeAllocation.class,
					   BoxAllocation.class,
					   LeafAllocation.class);
	}

	@Override
	public MethodHandles.Lookup lookup()
	{
		return MethodHandles.lookup();
	}
}

