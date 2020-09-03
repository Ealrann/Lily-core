package org.sheepy.lily.core.allocation.operation;

import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.util.Optional;
import java.util.function.BooleanSupplier;
import java.util.stream.Stream;

public class TriageOperation implements IOperationNode
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
	public Stream<IOperationNode> preChildren()
	{
		triage = initialForceTriage || needReallocation.getAsBoolean();
		if (triage || allocation.isDirty())
		{
			return allocation.getPreChildrenManager().prepareTriage(triage);
		}
		else
		{
			return Stream.empty();
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
	public Stream<IOperationNode> postChildren()
	{
		if (triage || allocation.isDirty())
		{
			return allocation.getPostChildrenManager().prepareTriage(triage);
		}
		else
		{
			return Stream.empty();
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
