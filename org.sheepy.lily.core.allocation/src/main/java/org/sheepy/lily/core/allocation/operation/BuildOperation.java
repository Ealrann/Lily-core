package org.sheepy.lily.core.allocation.operation;

import org.sheepy.lily.core.allocation.children.manager.AllocationChildrenManager;
import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.allocation.instance.AllocationInstanceBuilder;
import org.sheepy.lily.core.allocation.spliterator.UpdateTreeIterator;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.extender.IExtender;

import java.util.Optional;
import java.util.function.Consumer;

public final class BuildOperation<Allocation extends IExtender> implements IOperation<UpdateTreeIterator>
{
	private final AllocationInstanceBuilder<Allocation> allocationInstanceBuilder;
	private final Consumer<AllocationInstance<Allocation>> postBuildOperation;
	private AllocationChildrenManager postChildrenManager;

	public BuildOperation(AllocationInstanceBuilder<Allocation> allocationInstanceBuilder,
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
	public void loadPreChildrenIterator(UpdateTreeIterator iterator)
	{
		final var target = allocationInstanceBuilder.getTarget();
		final var childrenManager = allocationInstanceBuilder.preChildrenManager();
		iterator.load(target, childrenManager);
	}

	@Override
	public void loadPostChildrenIterator(UpdateTreeIterator iterator)
	{
		final var target = allocationInstanceBuilder.getTarget();
		iterator.load(target, postChildrenManager);
	}
}
