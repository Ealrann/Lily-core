package org.sheepy.lily.core.allocation.dependency;

import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.List;
import java.util.stream.Stream;

public final class DependencyResolvers
{
	private final List<DependencyResolver> resolvers;
	private final DependencyParameterResolverBuilder parameterResolverBuilder;

	private boolean started = false;

	public DependencyResolvers(List<DependencyResolver> resolvers)
	{
		this.resolvers = List.copyOf(resolvers);
		parameterResolverBuilder = new DependencyParameterResolverBuilder(resolvers);
	}

	public void start(final ILilyEObject source)
	{
		assert started == false;
		for (var resolver : resolvers)
		{
			resolver.start(source);
		}
		started = true;
	}

	public void stop(final ILilyEObject source)
	{
		assert started;
		for (var resolver : resolvers)
		{
			resolver.stop(source);
		}
		started = false;
	}

	public void resolve()
	{
		for (final var resolver : resolvers)
		{
			resolver.resolve();
		}
	}

	public DependencyResolver get(final int index)
	{
		return resolvers.get(index);
	}

	public DependencyParameterResolverBuilder getParameterResolverBuilder()
	{
		return parameterResolverBuilder;
	}

	public boolean isStarted()
	{
		return started;
	}

	public Stream<DependencyResolver> stream()
	{
		return resolvers.stream();
	}
}
