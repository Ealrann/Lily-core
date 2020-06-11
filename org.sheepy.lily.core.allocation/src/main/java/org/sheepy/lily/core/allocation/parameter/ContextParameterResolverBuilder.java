package org.sheepy.lily.core.allocation.parameter;

import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolverBuilder;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.lang.annotation.Annotation;
import java.util.Optional;

public record ContextParameterResolverBuilder(IAllocationContext context) implements IParameterResolverBuilder,
																					 IParameterResolver
{
	@Override
	public Object resolve()
	{
		return context;
	}

	@Override
	public Optional<ContextParameterResolverBuilder> tryBuild(final ILilyEObject target,
															  final Class<?> parameterClass,
															  final Annotation parameterAnnotation)
	{
		if (parameterClass.isInstance(context))
		{
			return Optional.of(this);
		}
		else
		{
			return Optional.empty();
		}
	}
}
