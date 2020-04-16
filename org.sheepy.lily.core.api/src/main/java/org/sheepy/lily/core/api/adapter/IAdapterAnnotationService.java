package org.sheepy.lily.core.api.adapter;

import org.sheepy.lily.core.api.util.ExecutionHandle;

import java.lang.annotation.Annotation;

public interface IAdapterAnnotationService<T extends Annotation, R extends IAdapterAnnotationHandle>
{
	Class<R> handleClass();
	Class<T> annotationClass();
	boolean forceLoadIfAnnotated();
	R buildHandle(ILilyEObject target, IAdapter adapter, T annotation, ExecutionHandle handle);
}
