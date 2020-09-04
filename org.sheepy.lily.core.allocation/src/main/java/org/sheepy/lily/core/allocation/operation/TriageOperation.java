package org.sheepy.lily.core.allocation.operation;

import org.sheepy.lily.core.allocation.children.instance.ChildHandleAllocator;
import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.allocation.spliterator.TriageTreeIterator;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.util.Optional;

public class TriageOperation implements IOperation<TriageTreeIterator>
{
	private ChildHandleAllocator<?> handleAllocator;
	private boolean initialForceTriage;
	private AllocationInstance<?> allocation;

	private boolean triage;

	public void setup(final ChildHandleAllocator<?> handleAllocator, final boolean forceTriage)
	{
		this.handleAllocator = handleAllocator;
		this.initialForceTriage = forceTriage;
		this.allocation = handleAllocator.getMainAllocation();
	}

	public void setup(AllocationInstance<?> allocation)
	{
		this.handleAllocator = null;
		this.initialForceTriage = false;
		this.allocation = allocation;
	}

	@Override
	public void loadPreChildrenIterator(final TriageTreeIterator iterator)
	{
		triage = initialForceTriage || (handleAllocator != null && handleAllocator.needReallocation());
		if (triage || allocation.isDirty())
		{
			iterator.load(allocation.getPreChildrenManager(), triage);
		}
		else
		{
			iterator.loadEmpty();
		}
	}

	@Override
	public void operate(final IAllocationContext context)
	{
		triage = triage || initialForceTriage || (handleAllocator != null && handleAllocator.needReallocation());
		if (triage && handleAllocator != null)
		{
			handleAllocator.triage(!initialForceTriage);
		}
	}

	@Override
	public void loadPostChildrenIterator(TriageTreeIterator iterator)
	{
		if (triage || allocation.isDirty())
		{
			iterator.load(allocation.getPostChildrenManager(), triage);
		}
		else
		{
			iterator.loadEmpty();
		}
	}

	@Override
	public Optional<IAllocationContext> providedContext()
	{
		return allocation.getPostChildrenManager().getProvidedContext();
	}
}
