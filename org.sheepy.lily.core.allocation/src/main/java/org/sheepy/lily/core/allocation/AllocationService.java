package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.allocation.operation.*;
import org.sheepy.lily.core.allocation.operator.OperationContext;
import org.sheepy.lily.core.allocation.operator.TreeOperator;
import org.sheepy.lily.core.allocation.spliterator.CleanupTreeIterator;
import org.sheepy.lily.core.allocation.spliterator.TriageTreeIterator;
import org.sheepy.lily.core.allocation.spliterator.UpdateTreeIterator;
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
		final var triageOperator = new TreeOperator<>(operationContext,
													  AllocationService::buildTriageOperation,
													  TriageTreeIterator::new,
													  false);
		final var cleanupOperator = new TreeOperator<>(operationContext,
													   AllocationService::buildCleanupOperation,
													   CleanupTreeIterator::new,
													   true);
		final var updateOperator = new TreeOperator<>(operationContext,
													  AllocationService::buildUpdateOperation,
													  UpdateTreeIterator::new,
													  false);

		triageOperator.operate();
		cleanupOperator.operate();
		updateOperator.operate();
	}

	@Override
	public void free(final ILilyEObject target, final IAllocationContext context, final Class<? extends IExtender> type)
	{
		final var operationContext = new OperationContext(target, context, type);
		final var cleanupOperator = new TreeOperator<>(operationContext,
													   AllocationService::buildFreeOperation,
													   CleanupTreeIterator::new,
													   true);

		cleanupOperator.operate();
	}

	private static <T extends IExtender> Optional<IOperation<TriageTreeIterator>> buildTriageOperation(AllocationHandle<T> handle)
	{
		final var mainAllocation = handle.getMainAllocation();
		if (mainAllocation != null && mainAllocation.isDirty())
		{
			final var triageOperation = new TriageOperation();
			triageOperation.setup(mainAllocation);
			return Optional.of(triageOperation);
		}
		else
		{
			return Optional.empty();
		}
	}

	private static Optional<IOperation<CleanupTreeIterator>> buildCleanupOperation(AllocationHandle<?> handle)
	{
		final var mainAllocation = handle.getMainAllocation();
		if (mainAllocation != null && mainAllocation.isDirty())
		{
			return Optional.of(new CleanupOperation(mainAllocation));
		}
		else
		{
			return Optional.empty();
		}
	}

	private static <T extends IExtender> Optional<IOperation<UpdateTreeIterator>> buildUpdateOperation(AllocationHandle<T> handle)
	{
		final var mainAllocation = handle.getMainAllocation();
		if (mainAllocation == null)
		{
			final var operation = new BuildOperation();
			handle.setupBuildOperation(operation);
			return Optional.of(operation);
		}
		else if (mainAllocation.isDirty())
		{
			final var operation = new UpdateOperation();
			operation.setup(mainAllocation, handle.getTarget());
			return Optional.of(operation);
		}
		else
		{
			return Optional.empty();
		}
	}

	private static <T extends IExtender> Optional<IOperation<CleanupTreeIterator>> buildFreeOperation(AllocationHandle<T> handle)
	{
		final var mainAllocation = handle.getMainAllocation();
		if (mainAllocation != null)
		{
			return Optional.of(handle.prepareFreeOperation(mainAllocation));
		}
		else
		{
			return Optional.empty();
		}
	}
}
