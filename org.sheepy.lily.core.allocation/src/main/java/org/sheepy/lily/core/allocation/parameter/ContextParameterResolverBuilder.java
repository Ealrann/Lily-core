package org.sheepy.lily.core.allocation.parameter;

import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.lang.annotation.Annotation;

public record ContextParameterResolverBuilder(IAllocationContext context) implements IParameterResolver
{
	@Override
	public boolean isApplicable(final Class<?> parameterClass, final Annotation parameterAnnotation)
	{
		return parameterClass.isInstance(context);
	}

	@Override
	public Object resolve(ILilyEObject target, Class<?> parameterClass)
	{
		return context;
	}
}
