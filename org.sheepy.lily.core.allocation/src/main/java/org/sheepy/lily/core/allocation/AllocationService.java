package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.allocation.operation.IOperationNode;
import org.sheepy.lily.core.allocation.operator.OperationContext;
import org.sheepy.lily.core.allocation.operator.Operator;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.Optional;

public final class AllocationService implements IAllocationService
{
	@Override
	public void updateAllocation(final ILilyEObject target,
								 final IAllocationContext context,
								 final Class<? extends IExtender> type)
	{
		final var operationContext = new OperationContext(target, context, type);
		final var operator = new Operator(operationContext, false);
		final var reverseOperator = new Operator(operationContext, true);

		triage(operator);
		cleanup(reverseOperator);
		update(operator);
	}

	private static void update(final Operator operator)
	{
		operator.operate(AllocationService::buildAllocationNode);
	}

	private static void cleanup(final Operator reverseOperator)
	{
		reverseOperator.operate(AllocationService::buildCleanupNode);
	}

	private static void triage(final Operator operator)
	{
		operator.operate(AllocationService::buildTriageNode);
	}

	@Override
	public void free(final ILilyEObject target, final IAllocationContext context, final Class<? extends IExtender> type)
	{
		final var operationContext = new OperationContext(target, context, type);
		final var freeOperator = new Operator(operationContext, true);

		freeOperator.operate(AllocationService::buildFreeNode);
	}

	private static <T extends IExtender> Optional<IOperationNode> buildTriageNode(AllocationHandle<T> handle)
	{
		final var mainAllocation = handle.getMainAllocation();
		if (mainAllocation != null && mainAllocation.isDirty())
		{
			return Optional.of(mainAllocation.prepareTriage(false));
		}
		else
		{
			return Optional.empty();
		}
	}

	private static Optional<IOperationNode> buildCleanupNode(AllocationHandle<?> handle)
	{
		final var mainAllocation = handle.getMainAllocation();
		if (mainAllocation != null && mainAllocation.isDirty())
		{
			return Optional.of(mainAllocation.prepareCleanup());
		}
		else
		{
			return Optional.empty();
		}
	}

	private static <T extends IExtender> Optional<IOperationNode> buildAllocationNode(AllocationHandle<T> handle)
	{
		final var mainAllocation = handle.getMainAllocation();
		if (mainAllocation == null)
		{
			return Optional.of(handle.newNodeBuilder());
		}
		else if (mainAllocation.isDirty())
		{
			return Optional.of(handle.prepareUpdate(mainAllocation));
		}
		else
		{
			return Optional.empty();
		}
	}

	private static <T extends IExtender> Optional<IOperationNode> buildFreeNode(AllocationHandle<T> handle)
	{
		final var mainAllocation = handle.getMainAllocation();
		if (mainAllocation != null)
		{
			return Optional.of(handle.prepareFree(mainAllocation));
		}
		else
		{
			return Optional.empty();
		}
	}
}
