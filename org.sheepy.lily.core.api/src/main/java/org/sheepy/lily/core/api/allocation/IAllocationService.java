package org.sheepy.lily.core.api.allocation;

import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.ServiceLoader;

public interface IAllocationService
{
	void ensureAllocation(ILilyEObject target, IAllocationContext context);
	void free(ILilyEObject target, IAllocationContext context);

	IAllocationService INSTANCE = ServiceLoader.load(IAllocationService.class).findFirst().orElse(null);
}
