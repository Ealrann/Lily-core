package org.sheepy.lily.core.allocation.operation;

import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.allocation.spliterator.CleanupTreeIterator;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.util.Optional;

public final class CleanupOperation implements IOperation<CleanupTreeIterator>
{
	private final AllocationInstance<?> allocation;

	public CleanupOperation(final AllocationInstance<?> allocation)
	{
		this.allocation = allocation;
	}

	@Override
	public void loadPreChildrenIterator(final CleanupTreeIterator iterator)
	{
		iterator.load(allocation.getPreChildrenManager(), false);
	}

	@Override
	public void operate(final IAllocationContext context)
	{
	}

	@Override
	public void loadPostChildrenIterator(final CleanupTreeIterator iterator)
	{
		iterator.load(allocation.getPostChildrenManager(), false);
	}

	@Override
	public Optional<IAllocationContext> providedContext()
	{
		return allocation.getPostChildrenManager().getProvidedContext();
	}
}
