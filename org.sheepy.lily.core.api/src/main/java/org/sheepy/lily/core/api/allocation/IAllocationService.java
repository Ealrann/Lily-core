package org.sheepy.lily.core.api.allocation;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.ServiceLoader;

public interface IAllocationService
{
	IAllocator buildAllocator(ILilyEObject target, IAllocationContext context, Class<? extends IAdapter> type);

	IAllocationService INSTANCE = ServiceLoader.load(IAllocationService.class).findFirst().orElse(null);
}
