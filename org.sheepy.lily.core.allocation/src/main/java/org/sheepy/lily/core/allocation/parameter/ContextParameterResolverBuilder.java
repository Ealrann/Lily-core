package org.sheepy.lily.core.allocation.parameter;

import org.logoce.extender.api.IAdaptable;
import org.logoce.extender.api.parameter.IParameterResolver;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

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
