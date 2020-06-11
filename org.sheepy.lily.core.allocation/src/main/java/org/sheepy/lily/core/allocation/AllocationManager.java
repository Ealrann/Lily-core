package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationManager;
import org.sheepy.lily.core.api.model.ILilyEObject;

public final class AllocationManager implements IAllocationManager
{
	@Override
	public void ensureAllocation(ILilyEObject target, IAllocationContext context)
	{
		target.adapters()
			  .adaptHandlesOfType(AllocationHandle.class)
			  .forEach(handle -> handle.ensureAllocation(null, context));
	}

	@Override
	public void free(ILilyEObject target, IAllocationContext context)
	{
		target.adapters().adaptHandlesOfType(AllocationHandle.class).forEach(handle -> handle.free(context));
	}
}
