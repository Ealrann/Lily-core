package org.sheepy.lily.core.allocation.operation;

import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.allocation.spliterator.TriageTreeIterator;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.util.Optional;
import java.util.function.BooleanSupplier;

public class TriageOperation implements IOperation<TriageTreeIterator>
{
	private final AllocationInstance<?> allocation;
	private final BooleanConsumer triageOperation;
	private final BooleanSupplier needReallocation;
	private final boolean initialForceTriage;

	private boolean triage;

	public TriageOperation(final AllocationInstance<?> allocation,
						   final BooleanConsumer triageOperation,
						   final boolean triage,
						   final BooleanSupplier needReallocation)
	{
		this.allocation = allocation;
		this.triageOperation = triageOperation;
		this.initialForceTriage = triage;
		this.needReallocation = needReallocation;
	}

	@Override
	public void loadPreChildrenIterator(final TriageTreeIterator iterator)
	{
		triage = initialForceTriage || needReallocation.getAsBoolean();
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
		triage = triage || initialForceTriage || needReallocation.getAsBoolean();
		if (triage)
		{
			triageOperation.accept(!initialForceTriage);
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

	@FunctionalInterface
	public interface BooleanConsumer
	{
		void accept(boolean input);
	}
}
