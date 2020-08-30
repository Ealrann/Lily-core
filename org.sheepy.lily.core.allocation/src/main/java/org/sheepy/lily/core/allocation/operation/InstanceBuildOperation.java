package org.sheepy.lily.core.allocation.operation;

import org.sheepy.lily.core.allocation.children.manager.AllocationChildrenManager;
import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.allocation.instance.AllocationInstanceBuilder;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.extender.IExtender;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public final class InstanceBuildOperation<Allocation extends IExtender> implements IOperationNode
{
	private final AllocationInstanceBuilder<Allocation> allocationInstanceBuilder;
	private final Consumer<AllocationInstance<Allocation>> postBuildOperation;
	private AllocationChildrenManager postChildrenManager;

	public InstanceBuildOperation(AllocationInstanceBuilder<Allocation> allocationInstanceBuilder,
								  Consumer<AllocationInstance<Allocation>> postBuildOperation)
	{
		this.allocationInstanceBuilder = allocationInstanceBuilder;
		this.postBuildOperation = postBuildOperation;
	}

	@Override
	public Optional<IAllocationContext> providedContext()
	{
		return postChildrenManager.getProvidedContext();
	}

	@Override
	public void operate(IAllocationContext context)
	{
		try
		{
			final var allocationInstance = allocationInstanceBuilder.build(context);
			postBuildOperation.accept(allocationInstance);
			postChildrenManager = allocationInstanceBuilder.postChildrenManager();
		}
		catch (ReflectiveOperationException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public Stream<IOperationNode> preChildren()
	{
		final var target = allocationInstanceBuilder.getTarget();
		final var childrenManager = allocationInstanceBuilder.preChildrenManager();
		return childrenManager.prepareUpdate(target);
	}

	@Override
	public Stream<IOperationNode> postChildren()
	{
		final var target = allocationInstanceBuilder.getTarget();
		return postChildrenManager.prepareUpdate(target);
	}
}
