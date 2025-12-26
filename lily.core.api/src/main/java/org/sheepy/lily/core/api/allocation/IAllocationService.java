package org.sheepy.lily.core.api.allocation;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.model.IFeaturedObject;

import java.util.ServiceLoader;

public interface IAllocationService
{
	IAllocator buildAllocator(IFeaturedObject target, IAllocationContext context, Class<? extends IAdapter> type);

	IAllocationService INSTANCE = ServiceLoader.load(IAllocationService.class).findFirst().orElse(null);
}
