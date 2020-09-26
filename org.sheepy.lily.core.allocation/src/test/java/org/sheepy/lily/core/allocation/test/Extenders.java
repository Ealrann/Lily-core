package org.sheepy.lily.core.allocation.test;

import org.sheepy.lily.core.allocation.test.adapters.*;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderProvider;

import java.lang.invoke.MethodHandles;
import java.util.List;

public final class Extenders implements IExtenderProvider
{
	@Override
	public List<Class<? extends IExtender>> classifiers()
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
