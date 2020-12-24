package org.sheepy.lily.core.api.extender.parameter;

import org.sheepy.lily.core.api.extender.IAdaptable;

import java.lang.annotation.Annotation;

public interface IParameterResolver
{
	boolean isApplicable(final Class<?> parameterClass, final Annotation parameterAnnotation);
	Object resolve(final IAdaptable target, final Class<?> parameterClass);
}
