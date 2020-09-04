package org.sheepy.lily.core.allocation.operator;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.operation.IOperation;
import org.sheepy.lily.core.allocation.operator.internal.AllocationTreeLayer;
import org.sheepy.lily.core.allocation.operator.internal.ILayer;
import org.sheepy.lily.core.allocation.operator.internal.TreeLayerBuilder;
import org.sheepy.lily.core.allocation.spliterator.AllocationTreeIterator;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public final class TreeOperator<T extends AllocationTreeIterator<T>>
{
	private final TreeLayerBuilder treeLayerBuilder;
	private final List<ILayer<T>> course = new ArrayList<>();
	private final Function<AllocationHandle<?>, Optional<? extends IOperation<T>>> operationBuilder;
	private final Supplier<T> treeIteratorBuilder;
	private final boolean reverse;
	private int cursor;
	private int limit = 1;

	public TreeOperator(final OperationContext context,
						final Function<AllocationHandle<?>, Optional<? extends IOperation<T>>> operationBuilder,
						final Supplier<T> treeIteratorBuilder,
						final boolean reverse)
	{
		this.operationBuilder = operationBuilder;
		this.treeIteratorBuilder = treeIteratorBuilder;
		this.reverse = reverse;
		this.treeLayerBuilder = new TreeLayerBuilder(context, reverse);
	}

	public void operate()
	{
		cursor = 0;
		final var rootLayer = treeLayerBuilder.rootLayer(operationBuilder);
		if (course.size() > 0) course.set(0, rootLayer);
		else course.add(rootLayer);

		while (cursor >= 0)
		{
			final var layer = course.get(cursor);
			layer.next();
			if (layer.done())
			{
				layer.close();
				cursor--;
			}
			else
			{
				final var operationWrapper = layer.get();
				final var context = layer.context();
				final var operation = operationWrapper.operation();
				switch (operationWrapper.phase())
				{
					case PreChildren -> buildPreLayer(operation, context);
					case Main -> operation.operate(context);
					case PostChildren -> buildPostLayer(operation, context, operation.providedContext());
				}
			}
		}
	}

	private void buildPreLayer(final IOperation<T> operation, final IAllocationContext context)
	{
		cursor++;
		final var layer = getOrCreateLayer();
		layer.load(context, false);
		operation.loadPreChildrenIterator(layer.iterator());
	}

	private void buildPostLayer(final IOperation<T> operation,
								final IAllocationContext parentContext,
								final Optional<IAllocationContext> providedContext)
	{
		cursor++;
		final var layer = getOrCreateLayer();
		final var prepareContext = providedContext.isPresent();
		final var childContext = providedContext.orElse(parentContext);
		layer.load(childContext, prepareContext);
		operation.loadPostChildrenIterator(layer.iterator());
	}

	private AllocationTreeLayer<T> getOrCreateLayer()
	{
		if (cursor == limit)
		{
			course.add(new AllocationTreeLayer<>(treeIteratorBuilder.get(), reverse));
			limit++;
		}
		return (AllocationTreeLayer<T>) course.get(cursor);
	}
}
