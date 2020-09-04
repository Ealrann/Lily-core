package org.sheepy.lily.core.allocation.operation;

import org.sheepy.lily.core.allocation.spliterator.AllocationTreeIterator;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.util.Optional;

public interface IOperation<T extends AllocationTreeIterator<T>>
{
	default Optional<IAllocationContext> providedContext()
	{
		return Optional.empty();
	}

	void operate(IAllocationContext context);

	default void loadPreChildrenIterator(T iterator)
	{
	}

	default void loadPostChildrenIterator(T iterator)
	{
	}
}
