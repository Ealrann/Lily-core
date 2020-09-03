package org.sheepy.lily.core.allocation.operator.internal;

import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.util.Iterator;

public final class AllocationLayer
{
	private final Iterator<OperationWrapper> nodes;
	private final IAllocationContext context;
	private final boolean prepareContext;

	private OperationWrapper current = null;

	public AllocationLayer(final Iterator<OperationWrapper> nodes,
						   final IAllocationContext context,
						   final boolean prepareContext)
	{
		this.nodes = nodes;
		this.context = context;
		this.prepareContext = prepareContext;

		if (prepareContext && context != null)
		{
			context.beforeChildrenAllocation();
		}
		next();
	}

	public IAllocationContext context()
	{
		return context;
	}

	public boolean done()
	{
		return current == null;
	}

	public OperationWrapper get()
	{
		return current;
	}

	public void next()
	{
		current = nodes.hasNext() ? nodes.next() : null;
	}

	public void close()
	{
		if (prepareContext && context != null)
		{
			context.afterChildrenAllocation();
		}
	}
}
