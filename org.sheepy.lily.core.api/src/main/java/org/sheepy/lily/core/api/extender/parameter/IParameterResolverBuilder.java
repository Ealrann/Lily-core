package org.sheepy.lily.core.api.extender.parameter;

import org.sheepy.lily.core.api.model.ILilyEObject;

import java.lang.annotation.Annotation;
import java.util.Optional;

public interface IParameterResolverBuilder
{
	Optional<? extends IParameterResolver> tryBuild(ILilyEObject target,
													final Class<?> parameterClass,
													final Annotation parameterAnnotation);
}
