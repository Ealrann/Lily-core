package org.sheepy.lily.core.reflect.util;

import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.reflect.IExecutionHandleBuilder;
import org.sheepy.lily.core.api.util.AnnotationHandles;
import org.sheepy.lily.core.api.util.ReflectUtils;
import org.sheepy.lily.core.reflect.ExecutionHandleBuilder;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class AnnotationHandlesBuilder<T extends Annotation>
{
	private final List<ExecutionMethod<T>> methods = new ArrayList<>();
	private final Class<T> annotationClass;

	public AnnotationHandlesBuilder(ReflectUtils.AnnotatedMethod<T> annotatedMethod)
	{
		@SuppressWarnings("unchecked") final var classifier = (Class<T>) annotatedMethod.annotation().annotationType();
		this.annotationClass = classifier;
		registerMethod(annotatedMethod);
	}

	public Class<T> annotationClass()
	{
		return annotationClass;
	}

	public Stream<T> streamAnnotations()
	{
		return methods.stream().map(m -> m.method.annotation());
	}

	public boolean matchAddMethod(final ReflectUtils.AnnotatedMethod<?> annotatedMethod)
	{
		if (annotatedMethod.annotation().annotationType() == annotationClass)
		{
			@SuppressWarnings("unchecked") final var cast = (ReflectUtils.AnnotatedMethod<T>) annotatedMethod;
			registerMethod(cast);
			return true;
		}
		else
		{
			return false;
		}
	}

	private void registerMethod(final ReflectUtils.AnnotatedMethod<T> cast)
	{
		try
		{
			final var executionMethod = new ExecutionMethod<>(cast);
			methods.add(executionMethod);
		}
		catch (ReflectiveOperationException e)
		{
			e.printStackTrace();
		}
	}

	public AnnotationHandles<T> build(Object adapter)
	{
		final List<IExtenderHandle.AnnotatedHandle<T>> handles = new ArrayList<>();

		for (var method : methods)
		{
			final var consumerHandleBuilder = method.executionHandleBuilder;
			final var annotation = method.method.annotation();
			final var annotationHandle = new IExtenderHandle.AnnotatedHandle<>(annotation,
																			   method.method.method(),
																			   consumerHandleBuilder.build(adapter));
			handles.add(annotationHandle);
		}

		return new AnnotationHandles<>(annotationClass, List.copyOf(handles));
	}

	public static record ExecutionMethod<T extends Annotation>(ReflectUtils.AnnotatedMethod<T>method,
															   IExecutionHandleBuilder executionHandleBuilder)
	{
		private ExecutionMethod(ReflectUtils.AnnotatedMethod<T> method) throws ReflectiveOperationException
		{
			this(method, ExecutionHandleBuilder.fromMethod(method.method()));
		}
	}
}