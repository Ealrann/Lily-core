package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;

public final class AllocationService implements IAllocationService
{
	@Override
	public Allocator buildAllocator(final ILilyEObject target,
									final IAllocationContext context,
									final Class<? extends IExtender> type)
	{
		return new Allocator(target, context, type);
	}
}
