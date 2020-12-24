package org.sheepy.lily.core.allocation.parameter;

import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.extender.IAdaptable;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;

import java.lang.annotation.Annotation;

public record ContextParameterResolverBuilder(IAllocationContext context) implements IParameterResolver
{
	@Override
	public boolean isApplicable(final Class<?> parameterClass, final Annotation parameterAnnotation)
	{
		return parameterClass.isInstance(context);
	}

	@Override
	public Object resolve(IAdaptable target, Class<?> parameterClass)
	{
		return context;
	}
}
