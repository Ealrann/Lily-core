package org.sheepy.lily.core.allocation.parameter;

import org.sheepy.lily.core.allocation.dependency.DependencyResolver;
import org.sheepy.lily.core.allocation.instance.AllocationState;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class AllocationParametersBuilder
{
	private final List<DependencyResolver> resolvers;

	public AllocationParametersBuilder(final List<DependencyResolver> resolvers)
	{
		this.resolvers = resolvers;
	}

	public List<IParameterResolver> build(AllocationState state, IAllocationContext context)
	{
		final var contextParameterResolver = new ContextParameterResolverBuilder(context);
		final var stateParameter = new StateParameterBuilder(state);
		return Stream.concat(resolvers.stream(), Stream.of(contextParameterResolver, stateParameter))
					 .collect(Collectors.toUnmodifiableList());
	}
}
