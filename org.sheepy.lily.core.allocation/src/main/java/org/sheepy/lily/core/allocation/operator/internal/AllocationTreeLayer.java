package org.sheepy.lily.core.allocation.operator.internal;

import org.sheepy.lily.core.allocation.treeiterator.AllocationTreeIterator;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

public final class AllocationTreeLayer<T extends AllocationTreeIterator<T>> implements ILayer<T>
{
	private final T treeIterator;
	private final OperationWrapper<T> operationWrapper;

	private IAllocationContext context;
	private boolean prepareContext;
	private boolean done;
	private boolean first;

	public AllocationTreeLayer(T treeIterator, final boolean reverse)
	{
		this.treeIterator = treeIterator;
		operationWrapper = new OperationWrapper<>(reverse);
	}

	public void load(final IAllocationContext context, final boolean prepareContext)
	{
		this.context = context;
		this.prepareContext = prepareContext;
		this.done = false;
		this.first = true;
		if (prepareContext && context != null)
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
		return done;
	}

	@Override
	public OperationWrapper<T> get()
	{
		return operationWrapper;
	}

	@Override
	public void next()
	{
		if (first || operationWrapper.onLastPhase())
		{
			treeIterator.tryAdvance().ifPresentOrElse(operationWrapper::load, this::setDone);
			first = false;
		}
		else
		{
			operationWrapper.nextPhase();
		}
	}

	private void setDone()
	{
		this.done = true;
	}

	@Override
	public void close()
	{
		if (prepareContext && context != null)
		{
			context.afterChildrenAllocation();
		}
	}

	public T iterator()
	{
		return treeIterator;
	}
}
