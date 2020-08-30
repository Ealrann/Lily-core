package org.sheepy.lily.core.allocation.operation;

import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.util.Optional;
import java.util.stream.Stream;

public interface IOperationNode
{
	default Optional<IAllocationContext> providedContext()
	{
		return Optional.empty();
	}

	void operate(IAllocationContext context);

	default Stream<IOperationNode> preChildren()
	{
		return Stream.empty();
	}
	default Stream<IOperationNode> postChildren()
	{
		return Stream.empty();
	}
}
