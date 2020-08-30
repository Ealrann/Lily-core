package org.sheepy.lily.core.allocation.operator;

import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;

public record OperationContext(ILilyEObject target, IAllocationContext rootContext, Class<? extends IExtender> type)
{
}
