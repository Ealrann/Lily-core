package org.sheepy.lily.core.allocation.operation;

import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.allocation.spliterator.UpdateTreeIterator;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.Optional;

public final class UpdateOperation implements IOperation<UpdateTreeIterator>
{
	private final ILilyEObject target;
	private final AllocationInstance<?> allocation;

	public UpdateOperation(final ILilyEObject target, final AllocationInstance<?> allocation)
	{
		this.allocation = allocation;
		this.target = target;
	}

	@Override
	public void loadPreChildrenIterator(UpdateTreeIterator iterator)
	{
		iterator.load(target, allocation.getPreChildrenManager());
	}

	@Override
	public void operate(final IAllocationContext context)
	{
		allocation.update(target);
	}

	@Override
	public void loadPostChildrenIterator(UpdateTreeIterator iterator)
	{
		iterator.load(target, allocation.getPostChildrenManager());
	}

	@Override
	public Optional<IAllocationContext> providedContext()
	{
		return allocation.getPostChildrenManager().getProvidedContext();
	}
}
