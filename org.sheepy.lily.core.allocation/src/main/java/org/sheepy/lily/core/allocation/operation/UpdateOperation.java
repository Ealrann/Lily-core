package org.sheepy.lily.core.allocation.operation;

import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.Optional;
import java.util.stream.Stream;

public final class UpdateOperation implements IOperationNode
{
	private final ILilyEObject target;
	private final AllocationInstance<?> allocation;

	public UpdateOperation(final ILilyEObject target, final AllocationInstance<?> allocation)
	{
		this.allocation = allocation;
		this.target = target;
	}

	@Override
	public Stream<IOperationNode> preChildren()
	{
		return allocation.getPreChildrenManager().prepareUpdate(target);
	}

	@Override
	public void operate(final IAllocationContext context)
	{
		allocation.update(target);
	}

	@Override
	public Stream<IOperationNode> postChildren()
	{
		return allocation.getPostChildrenManager().prepareUpdate(target);
	}

	@Override
	public Optional<IAllocationContext> providedContext()
	{
		return allocation.getPostChildrenManager().getProvidedContext();
	}
}
