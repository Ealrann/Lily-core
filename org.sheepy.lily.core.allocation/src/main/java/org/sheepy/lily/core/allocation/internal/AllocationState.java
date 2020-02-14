package org.sheepy.lily.core.allocation.internal;

import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.util.ArrayList;
import java.util.List;

public final class AllocationState<T extends IAllocationContext>
{
	public final IAllocable<T> allocable;
	private final List<IDependencyListener> listeners = new ArrayList<>();

	private AllocationState<?> parent;
	private boolean dirty = false;
	private boolean branchDirty = true;
	private EAllocationStatus status = EAllocationStatus.NotAllocated;

	public AllocationState(IAllocable<T> allocable)
	{
		this.allocable = allocable;
	}

	public void setParent(AllocationState<?> parent)
	{
		this.parent = parent;
	}

	public void tryAllocate(final AllocationConfiguration<T> configuration)
	{
		if (status == EAllocationStatus.NotAllocated)
		{
			if (configuration.isAllocable())
			{
				dirty = false;
				if (configuration.areDependenciesAllocated())
				{
					allocate(configuration.context);
				}
				else
				{
					status = EAllocationStatus.AllocationDelayed;
				}
			}
			else
			{
				status = EAllocationStatus.CannotAllocate;
			}
		}
	}

	public void allocate(final T context)
	{
		status = EAllocationStatus.Allocated;
		allocable.allocate(context);
		fireChange(IDependencyListener.EChangeNature.Allocated);
	}

	public void free(final T context, final boolean dirtyOnly)
	{
		if (status != EAllocationStatus.NotAllocated && (!dirtyOnly || dirty))
		{
			if (status == EAllocationStatus.Allocated)
			{
				allocable.free(context);
				fireChange(IDependencyListener.EChangeNature.Free);
			}
			status = EAllocationStatus.NotAllocated;
		}
	}

	public void fireChange(IDependencyListener.EChangeNature nature)
	{
		for (final var listener : listeners)
		{
			listener.onChange(nature);
		}
	}

	public void markDirty()
	{
		if (!dirty)
		{
			dirty = true;
			if (parent != null)
			{
				parent.markBranchAsDirty();
			}
			fireChange(IDependencyListener.EChangeNature.Dirty);
		}
	}

	public void markBranchAsDirty()
	{
		if (this.branchDirty == false)
		{
			this.branchDirty = true;
			if (parent != null)
			{
				parent.markBranchAsDirty();
			}
		}
	}

	public boolean isBranchDirty()
	{
		return branchDirty;
	}

	public void setBranchDirty(boolean dirty)
	{
		this.branchDirty = dirty;
	}

	public EAllocationStatus getStatus()
	{
		return status;
	}

	public boolean is(EAllocationStatus status)
	{
		return status == this.status;
	}

	public boolean isDirty()
	{
		return dirty;
	}

	public void addListener(IDependencyListener listener)
	{
		listeners.add(listener);
	}

	public void removeListener(IDependencyListener listener)
	{
		listeners.remove(listener);
	}

	@Override
	public String toString()
	{
		return allocable.getClass().getSimpleName();
	}
}
