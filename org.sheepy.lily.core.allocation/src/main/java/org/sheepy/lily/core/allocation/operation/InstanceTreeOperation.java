package org.sheepy.lily.core.allocation.operation;

import org.sheepy.lily.core.allocation.children.manager.AllocationChildrenManager;
import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class InstanceTreeOperation implements IOperationNode
{
	private final Function<AllocationChildrenManager, Stream<IOperationNode>> childExctractor;
	protected final AllocationInstance<?> allocationInstance;

	public InstanceTreeOperation(final Function<AllocationChildrenManager, Stream<IOperationNode>> childExctractor,
								 final AllocationInstance<?> allocationInstance)
	{
		this.childExctractor = childExctractor;
		this.allocationInstance = allocationInstance;
	}

	@Override
	public final Optional<IAllocationContext> providedContext()
	{
		return allocationInstance.getPostChildrenManager().getProvidedContext();
	}

	@Override
	public void operate(final IAllocationContext context)
	{
	}

	@Override
	public final Stream<IOperationNode> preChildren()
	{
		return childExctractor.apply(allocationInstance.getPreChildrenManager());
	}

	@Override
	public final Stream<IOperationNode> postChildren()
	{
		return childExctractor.apply(allocationInstance.getPostChildrenManager());
	}
}
