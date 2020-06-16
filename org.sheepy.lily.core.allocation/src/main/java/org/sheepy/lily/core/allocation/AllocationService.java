package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.model.ILilyEObject;

public final class AllocationService implements IAllocationService
{
	@Override
	public void ensureAllocation(ILilyEObject target, IAllocationContext context)
	{
		target.adapters()
			  .adaptHandlesOfType(AllocationHandle.class)
			  .forEach(handle -> ensureHandleAllocation(context, handle));
	}

	private static void ensureHandleAllocation(final IAllocationContext context, final AllocationHandle<?> handle)
	{
		handle.cleanup(context, false);
		handle.ensureAllocation(context);
	}

	@Override
	public void free(ILilyEObject target, IAllocationContext context)
	{
		target.adapters().adaptHandlesOfType(AllocationHandle.class).forEach(handle -> handle.cleanup(context, true));
	}
}
