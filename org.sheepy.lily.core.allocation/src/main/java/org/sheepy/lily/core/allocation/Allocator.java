package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.allocation.operation.*;
import org.sheepy.lily.core.allocation.operator.OperationContext;
import org.sheepy.lily.core.allocation.operator.TreeOperator;
import org.sheepy.lily.core.allocation.treeiterator.CleanupTreeIterator;
import org.sheepy.lily.core.allocation.treeiterator.TriageTreeIterator;
import org.sheepy.lily.core.allocation.treeiterator.UpdateTreeIterator;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocator;
import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.Optional;

public class Allocator implements IAllocator
{
	private final TreeOperator<TriageTreeIterator> triageOperator;
	private final TreeOperator<CleanupTreeIterator> cleanupOperator;
	private final TreeOperator<UpdateTreeIterator> updateOperator;
	private final TreeOperator<CleanupTreeIterator> freeOperator;

	public Allocator(final ILilyEObject target, final IAllocationContext context, final Class<? extends IAdapter> type)
	{
		final var operationContext = new OperationContext(target, context, type);
		triageOperator = new TreeOperator<>(operationContext,
											Allocator::buildTriageOperation,
											TriageTreeIterator::new,
											false);
		cleanupOperator = new TreeOperator<>(operationContext,
											 Allocator::buildCleanupOperation,
											 CleanupTreeIterator::new,
											 true);
		updateOperator = new TreeOperator<>(operationContext,
											Allocator::buildUpdateOperation,
											UpdateTreeIterator::new,
											false);
		freeOperator = new TreeOperator<>(operationContext,
										  Allocator::buildFreeOperation,
										  CleanupTreeIterator::new,
										  true);
	}

	@Override
	public void updateAllocation()
	{
		triageOperator.operate();
		cleanupOperator.operate();
		updateOperator.operate();
	}

	@Override
	public void free()
	{
		freeOperator.operate();
	}

	private static <T extends IAdapter> Optional<IOperation<TriageTreeIterator>> buildTriageOperation(AllocationHandle<T> handle)
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
			final var cleanupOperation = new CleanupOperation();
			cleanupOperation.setup(mainAllocation);
			return Optional.of(cleanupOperation);
		}
		else
		{
			return Optional.empty();
		}
	}

	private static <T extends IAdapter> Optional<IOperation<UpdateTreeIterator>> buildUpdateOperation(AllocationHandle<T> handle)
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

	private static <T extends IAdapter> Optional<IOperation<CleanupTreeIterator>> buildFreeOperation(AllocationHandle<T> handle)
	{
		final var mainAllocation = handle.getMainAllocation();
		if (mainAllocation != null)
		{
			final var freeOperation = new FreeOperation();
			freeOperation.setup(handle.getTarget(), mainAllocation);
			return Optional.of(freeOperation);
		}
		else
		{
			return Optional.empty();
		}
	}
}
