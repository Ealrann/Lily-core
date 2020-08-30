package org.sheepy.lily.core.allocation.operation;

import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.util.Optional;
import java.util.function.BooleanSupplier;
import java.util.stream.Stream;

public class TriageOperation implements IOperationNode
{
	private final AllocationInstance<?> allocation;
	private final BooleanSupplier triageOperation;

	private boolean forceTriage;

	public TriageOperation(final AllocationInstance<?> allocation,
						   final BooleanSupplier triageOperation,
						   final boolean forceTriage)
	{
		this.allocation = allocation;
		this.triageOperation = triageOperation;
		this.forceTriage = forceTriage;
	}

	@Override
	public Stream<IOperationNode> preChildren()
	{
		if (forceTriage || allocation.isDirty())
		{
			return allocation.getPreChildrenManager().prepareTriage(forceTriage);
		}
		else
		{
			return Stream.empty();
		}
	}

	@Override
	public void operate(final IAllocationContext context)
	{
		if (forceTriage || allocation.isDirty())
		{
			forceTriage |= triageOperation.getAsBoolean();
		}
	}

	@Override
	public Stream<IOperationNode> postChildren()
	{
		if (forceTriage || allocation.isDirty())
		{
			return allocation.getPostChildrenManager().prepareTriage(forceTriage);
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
}
