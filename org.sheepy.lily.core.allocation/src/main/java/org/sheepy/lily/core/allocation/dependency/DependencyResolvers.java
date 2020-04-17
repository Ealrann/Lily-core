package org.sheepy.lily.core.allocation.dependency;

import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.List;
import java.util.stream.Stream;

public final class DependencyResolvers
{
	private final List<DependencyResolver> resolvers;
	private final DependencyResolverBuilder builder;

	private boolean started = false;

	public DependencyResolvers(List<DependencyResolver> resolvers)
	{
		this.resolvers = List.copyOf(resolvers);
		builder = new DependencyResolverBuilder(resolvers);
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

	public Stream<DependencyResolver> streamNotCriticalDirty()
	{
		return resolvers.stream()
						.filter(DependencyResolver::isNotCritical)
						.filter(DependencyResolver::isLastResolveDirty);
	}

	public DependencyResolverBuilder getBuilder()
	{
		return builder;
	}

	public Stream<DependencyResolver> streamCriticalDirty()
	{
		return resolvers.stream().filter(DependencyResolver::isCritical).filter(DependencyResolver::isLastResolveDirty);
	}

	public boolean isStarted()
	{
		return started;
	}
}
