package org.sheepy.lily.core.allocation.operator;

import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.core.api.model.ILilyEObject;

public record OperationContext(ILilyEObject target, IAllocationContext rootContext, Class<? extends IAdapter> type)
{
}
