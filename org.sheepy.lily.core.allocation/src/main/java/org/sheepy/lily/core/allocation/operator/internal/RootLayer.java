package org.sheepy.lily.core.allocation.operator.internal;

import org.sheepy.lily.core.allocation.spliterator.AllocationTreeIterator;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.util.Iterator;

public class RootLayer<T extends AllocationTreeIterator<T>> implements ILayer<T>
{
	private final Iterator<OperationWrapper<T>> wrappers;
	private final IAllocationContext context;

	private OperationWrapper<T> current = null;

	public RootLayer(Iterator<OperationWrapper<T>> wrappers, IAllocationContext context)
	{
		this.wrappers = wrappers;
		this.context = context;

		if (context != null)
		{
			context.beforeChildrenAllocation();
		}

		next();
	}

	@Override
	public IAllocationContext context()
	{
		return context;
	}

	@Override
	public boolean done()
	{
		return current == null;
	}

	@Override
	public OperationWrapper<T> get()
	{
		return current;
	}

	@Override
	public void next()
	{
		current = wrappers.hasNext() ? wrappers.next() : null;
	}

	@Override
	public void close()
	{
		if (context != null)
		{
			context.afterChildrenAllocation();
		}
	}
}
