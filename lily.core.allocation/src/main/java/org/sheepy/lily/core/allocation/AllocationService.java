package org.sheepy.lily.core.allocation;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationService;

public final class AllocationService implements IAllocationService
{
	@Override
	public Allocator buildAllocator(final IFeaturedObject target,
									final IAllocationContext context,
									final Class<? extends IAdapter> type)
	{
		return new Allocator(target, context, type);
	}
}
