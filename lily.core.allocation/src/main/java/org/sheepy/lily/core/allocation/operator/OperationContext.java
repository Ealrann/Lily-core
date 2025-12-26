package org.sheepy.lily.core.allocation.operator;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

public record OperationContext(IFeaturedObject target, IAllocationContext rootContext, Class<? extends IAdapter> type)
{
}
