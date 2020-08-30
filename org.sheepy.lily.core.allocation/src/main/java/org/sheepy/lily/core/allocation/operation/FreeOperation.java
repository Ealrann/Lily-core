package org.sheepy.lily.core.allocation.operation;

import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.Optional;
import java.util.stream.Stream;

public final class FreeOperation implements IOperationNode
{
	private final ILilyEObject target;
	private final AllocationInstance<?> allocation;

	public FreeOperation(final ILilyEObject target, final AllocationInstance<?> allocation)
	{
		this.allocation = allocation;
		this.target = target;
	}

	@Override
	public Stream<IOperationNode> preChildren()
	{
		return allocation.getPreChildrenManager().prepareCleanup(true);
	}

	@Override
	public void operate(final IAllocationContext context)
	{
		allocation.free(target, context);
	}

	@Override
	public Stream<IOperationNode> postChildren()
	{
		return allocation.getPostChildrenManager().prepareCleanup(true);
	}

	@Override
	public Optional<IAllocationContext> providedContext()
	{
		return allocation.getPostChildrenManager().getProvidedContext();
	}
}
