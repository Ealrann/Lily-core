package org.sheepy.lily.core.allocation.operator;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.operation.IOperationNode;
import org.sheepy.lily.core.allocation.operator.internal.AllocationLayer;
import org.sheepy.lily.core.allocation.operator.internal.OperationBuilder;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public final class Operator
{
	private final OperationBuilder operationBuilder;
	private final Deque<AllocationLayer> course = new ArrayDeque<>();

	public Operator(final OperationContext context, final boolean reverse)
	{
		this.operationBuilder = new OperationBuilder(context, reverse);
	}

	public void operate(final Function<AllocationHandle<?>, Optional<IOperationNode>> nodeBuilder)
	{
		course.clear();
		operationBuilder.rootLayers(nodeBuilder).forEach(course::add);

		while (course.isEmpty() == false)
		{
			final var layer = course.getLast();
			if (layer.done())
			{
				layer.close();
				course.removeLast();
			}
			else
			{
				final var operation = layer.get();
				final var context = layer.context();
				final var node = operation.node();
				switch (operation.phase())
				{
					case PreChildren -> buildLayer(node.preChildren(), context, false);
					case Main -> node.operate(context);
					case PostChildren -> buildLayer(node.postChildren(), context, node.providedContext());
				}

				if (operation.hasNextPhase()) operation.nextPhase();
				else layer.next();
			}
		}
	}

	private void buildLayer(final Stream<IOperationNode> children,
							final IAllocationContext parentContext,
							final Optional<IAllocationContext> providedContext)
	{
		final var prepareContext = providedContext.isPresent();
		final var childContext = providedContext.orElse(parentContext);
		buildLayer(children, childContext, prepareContext);
	}

	private void buildLayer(final Stream<IOperationNode> children,
							final IAllocationContext context,
							final boolean prepareContext)
	{
		final var operationStream = children.map(operationBuilder::newWrapper);
		final var iterator = operationStream.iterator();
		if (iterator.hasNext())
		{
			final var layer = new AllocationLayer(iterator, context, prepareContext);
			course.add(layer);
		}
	}
}
