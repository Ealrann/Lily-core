package org.sheepy.lily.core.allocation.parameter;

import org.sheepy.lily.core.allocation.dependency.DependencyResolver;
import org.sheepy.lily.core.allocation.instance.AllocationState;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.extender.IAdaptable;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;

public final class AllocationParametersBuilder
{
	private final List<DependencyResolver> resolvers;

	public AllocationParametersBuilder(final List<DependencyResolver> resolvers)
	{
		this.resolvers = resolvers;
	}

	public Stream<IParameterResolver> build(final AllocationState state,
											final IAllocationContext context,
											final IObservatoryBuilder observatoryBuilder)
	{
		final var contextParameterResolver = new ContextParameterResolverBuilder(context);
		final var stateParameter = new StateParameterBuilder(state);
		final IParameterResolver observatoryResolver = new ObservatoryParameterResolver(observatoryBuilder);

		return Stream.concat(resolvers.stream(),
							 Stream.of(contextParameterResolver, stateParameter, observatoryResolver));
	}

	private static final class ObservatoryParameterResolver implements IParameterResolver
	{
		private final IObservatoryBuilder observatoryBuilder;

		public ObservatoryParameterResolver(final IObservatoryBuilder observatoryBuilder)
		{
			this.observatoryBuilder = observatoryBuilder;
		}

		@Override
		public boolean isApplicable(final Class<?> parameterClass, final Annotation parameterAnnotation)
		{
			return parameterClass == IObservatoryBuilder.class;
		}

		@Override
		public Object resolve(final IAdaptable target, final Class<?> parameterClass)
		{
			return observatoryBuilder;
		}
	}
}
