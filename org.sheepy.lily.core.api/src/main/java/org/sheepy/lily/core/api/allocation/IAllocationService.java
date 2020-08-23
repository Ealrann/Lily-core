package org.sheepy.lily.core.api.allocation;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.ServiceLoader;

public interface IAllocationService
{
	<T extends IExtender> IAllocationInstance<T> allocate(ILilyEObject target,
														  IAllocationContext context,
														  Class<T> type);

	void updateAllocation(ILilyEObject target, IAllocationContext context, Class<? extends IExtender> type);
	<T extends IExtender> void setMainAllocation(IAllocationInstance<T> allocation);

	IAllocationService INSTANCE = ServiceLoader.load(IAllocationService.class).findFirst().orElse(null);
}
