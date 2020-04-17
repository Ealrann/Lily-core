package org.sheepy.lily.core.allocation.dependency;

import org.sheepy.lily.core.allocation.parameter.DependencyParameterResolver;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolverBuilder;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;

public final class DependencyResolverBuilder implements IParameterResolverBuilder
{
	private final List<DependencyResolver> resolvers;

	public DependencyResolverBuilder(List<DependencyResolver> resolvers)
	{
		this.resolvers = List.copyOf(resolvers);
	}

	@Override
	public Optional<DependencyParameterResolver> tryBuild(ILilyEObject target,
														  final Class<?> parameterClass,
														  final Annotation parameterAnnotation)
	{
		if (parameterAnnotation instanceof InjectDependency)
		{
			try
			{
				final var annotation = (InjectDependency) parameterAnnotation;
				final var index = annotation.index();
				final var resolver = resolvers.get(index);
				final var res = new DependencyParameterResolver(parameterClass, resolver);
				return Optional.of(res);
			}
			catch (Throwable throwable)
			{
				new IllegalArgumentException("Cannot Inject " + "dependency, " + "AllocationDependency is " + "missing?",
											 throwable).printStackTrace();
			}
		}

		return Optional.empty();
	}
}
