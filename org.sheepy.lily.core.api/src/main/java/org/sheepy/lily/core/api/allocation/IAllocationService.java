package org.sheepy.lily.core.api.allocation;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.ServiceLoader;

public interface IAllocationService
{
	IAllocator buildAllocator(ILilyEObject target, IAllocationContext context, Class<? extends IExtender> type);

	IAllocationService INSTANCE = ServiceLoader.load(IAllocationService.class).findFirst().orElse(null);
}
