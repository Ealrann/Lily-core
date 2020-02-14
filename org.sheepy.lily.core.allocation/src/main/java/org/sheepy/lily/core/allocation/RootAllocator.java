package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IRootAllocator;

public class RootAllocator<T extends IAllocationContext> implements IRootAllocator<T>
{
	private final AllocationManager<T> rootWrapper;
	private final T context;
	private final AllocationManagerFactory<T> factory;

	private boolean isAllocated = false;

	public RootAllocator(IAllocable<T> root, T context)
	{
		this(new AllocationManagerFactory<>(), context, root);
	}

	public RootAllocator(RootAllocator<T> parentAllocator, IAllocable<T> root, T context)
	{
		this(parentAllocator.factory, context, root);
	}

	private RootAllocator(AllocationManagerFactory<T> factory, T context, IAllocable<T> root)
	{
		this.context = context;
		this.factory = factory;
		this.rootWrapper = factory.newRoot(root);
	}

	@Override
	public void allocate()
	{
		try
		{
			rootWrapper.configure(context);
			if (context != null) context.beforeChildrenAllocation();
			rootWrapper.allocate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (context != null) context.afterChildrenAllocation();
		}
		isAllocated = true;
	}

	@Override
	public void free()
	{
		rootWrapper.free();
		isAllocated = false;
	}

	@Override
	public boolean isAllocationDirty()
	{
		return rootWrapper.isBranchDirty();
	}

	@Override
	public void reloadDirtyElements()
	{
		rootWrapper.freeDirtyElements();
		rootWrapper.allocate();
	}

	@Override
	public boolean isAllocated()
	{
		return isAllocated;
	}

	@Override
	public String toString()
	{
		return rootWrapper.toString();
	}
}
