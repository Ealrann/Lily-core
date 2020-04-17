package org.sheepy.lily.core.api.extender.parameter;

import org.sheepy.lily.core.api.model.ILilyEObject;

import java.lang.annotation.Annotation;

public interface IParameterResolver
{
	boolean isApplicable(final Class<?> parameterClass, final Annotation parameterAnnotation);
	Object resolve(ILilyEObject target, final Class<?> parameterClass);
}
