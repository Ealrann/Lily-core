package org.sheepy.lily.core.reflect.util;

import org.sheepy.lily.core.api.extender.AnnotationHandles;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.reflect.IExecutionHandleBuilder;
import org.sheepy.lily.core.api.util.ReflectUtils;
import org.sheepy.lily.core.reflect.ExecutionHandleBuilder;

import java.lang.annotation.Annotation;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class AnnotationHandlesBuilder<T extends Annotation>
{
	private final Class<T> annotationClass;
	private final List<ExecutionMethod<T>> methods;

	public AnnotationHandlesBuilder(final Class<T> annotationClass, final List<ExecutionMethod<T>> methods)
	{
		this.annotationClass = annotationClass;
		this.methods = List.copyOf(methods);
	}

	public Class<T> annotationClass()
	{
		return annotationClass;
	}

	public Stream<T> streamAnnotations()
	{
		return methods.stream().map(m -> m.method.annotation());
	}

	public AnnotationHandles<T> build(Object adapter)
	{
		final var handles = methods.stream()
								   .map(m -> buildAnnotationHandle(adapter, m))
								   .collect(Collectors.toUnmodifiableList());

		return new AnnotationHandles<>(annotationClass, handles);
	}

	private IExtenderHandle.AnnotatedHandle<T> buildAnnotationHandle(final Object adapter,
																	 final ExecutionMethod<T> method)
	{
		final var consumerHandleBuilder = method.executionHandleBuilder;
		final var annotation = method.method.annotation();
		final var annotationHandle = new IExtenderHandle.AnnotatedHandle<>(annotation,
																		   method.method.method(),
																		   consumerHandleBuilder.build(adapter));
		return annotationHandle;
	}

	public static record ExecutionMethod<T extends Annotation>(ReflectUtils.AnnotatedMethod<T> method,
															   IExecutionHandleBuilder executionHandleBuilder)
	{
	}
}
