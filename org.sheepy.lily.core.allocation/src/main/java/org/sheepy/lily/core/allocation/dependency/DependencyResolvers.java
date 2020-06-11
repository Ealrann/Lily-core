package org.sheepy.lily.core.allocation.dependency;

import java.util.List;
import java.util.stream.Stream;

public final class DependencyResolvers
{
	private final List<DependencyResolver> resolvers;
	private final DependencyParameterResolverBuilder parameterResolverBuilder;

	public DependencyResolvers(List<DependencyResolver> resolvers)
	{
		this.resolvers = List.copyOf(resolvers);
		parameterResolverBuilder = new DependencyParameterResolverBuilder(resolvers);
	}

	public DependencyResolver get(final int index)
	{
		return resolvers.get(index);
	}

	public DependencyParameterResolverBuilder getParameterResolverBuilder()
	{
		return parameterResolverBuilder;
	}

	public Stream<DependencyResolver> stream()
	{
		return resolvers.stream();
	}
}
