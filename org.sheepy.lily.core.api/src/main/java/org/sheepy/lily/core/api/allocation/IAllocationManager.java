package org.sheepy.lily.core.api.allocation;

import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.ServiceLoader;

public interface IAllocationManager
{
	void ensureAllocation(ILilyEObject target, IAllocationContext context);
	void cleanup(ILilyEObject target, IAllocationContext context);
	void free(ILilyEObject target, IAllocationContext context);

	IAllocationManager INSTANCE = ServiceLoader.load(IAllocationManager.class).findFirst().orElse(null);
}
