package org.sheepy.lily.core.allocation.operator.internal;

import org.sheepy.lily.core.allocation.treeiterator.AllocationTreeIterator;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.util.Iterator;

public class RootLayer<T extends AllocationTreeIterator<T>> implements ILayer<T>
{
	private final Iterator<OperationWrapper<T>> wrappers;
	private final IAllocationContext context;

	private OperationWrapper<T> current = null;
	private boolean first = true;

	public RootLayer(Iterator<OperationWrapper<T>> wrappers, IAllocationContext context)
	{
		this.wrappers = wrappers;
		this.context = context;

		if (context != null)
		{
			context.beforeChildrenAllocation();
		}
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
		if (first || current.onLastPhase())
		{
			current = wrappers.hasNext() ? wrappers.next() : null;
			first = false;
		}
		else
		{
			current.nextPhase();
		}
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
