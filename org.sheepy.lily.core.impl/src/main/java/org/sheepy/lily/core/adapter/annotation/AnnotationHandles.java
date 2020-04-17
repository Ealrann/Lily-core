package org.sheepy.lily.core.adapter.annotation;

import org.sheepy.lily.core.adapter.reflect.ExecutionHandleBuilder;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterAnnotationHandle;
import org.sheepy.lily.core.api.adapter.IAdapterAnnotationService;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.util.ReflectUtils;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class AnnotationHandles<T extends IAdapterAnnotationHandle>
{
	public final Class<T> type;
	public final List<T> handles;

	public AnnotationHandles(Class<T> type, final List<T> handles)
	{
		this.type = type;
		this.handles = List.copyOf(handles);
	}

	public AnnotationHandles<T> merge(final AnnotationHandles<T> newHandleContainer)
	{
		final var joinedHandles = Stream.concat(handles.stream(), newHandleContainer.handles.stream())
										.collect(Collectors.toUnmodifiableList());

		return new AnnotationHandles<>(type, joinedHandles);
	}

	public void call(Consumer<T> action)
	{
		handles.forEach(action);
	}

	public static final class Builder<T extends Annotation, R extends IAdapterAnnotationHandle>
	{
		public final IAdapterAnnotationService<T, R> service;
		public final List<AnnotationExecutionHandle<T>> executionHandleBuilders;

		public Builder(IAdapterAnnotationService<T, R> service, List<ReflectUtils.AnnotatedMethod<T>> annotatedMethods)
		{
			this.service = service;
			this.executionHandleBuilders = List.copyOf(executionHandles(annotatedMethods));
		}

		public AnnotationHandles<R> build(ILilyEObject target, IAdapter adapter)
		{
			final var type = service.handleClass();
			final List<R> handles = new ArrayList<>();

			for (var executionHandleBuilder : executionHandleBuilders)
			{
				final var annotation = executionHandleBuilder.annotation;
				final var executionHandle = executionHandleBuilder.executionHandleBuilder.build(adapter);
				final var annotationHandle = service.buildHandle(target, adapter, annotation, executionHandle);
				handles.add(annotationHandle);
			}

			return new AnnotationHandles<>(type, handles);
		}

		private static <T extends Annotation> List<AnnotationExecutionHandle<T>> executionHandles(final List<ReflectUtils.AnnotatedMethod<T>> annotatedMethods)
		{
			final List<AnnotationExecutionHandle<T>> handleBuilders = new ArrayList<>();
			for (var annotatedMethod : annotatedMethods)
			{
				handleBuilders.add(new AnnotationExecutionHandle<>(annotatedMethod));
			}
			return handleBuilders;
		}

		public final static class AnnotationExecutionHandle<T extends Annotation>
		{
			public final T annotation;
			public final ExecutionHandleBuilder executionHandleBuilder;

			public AnnotationExecutionHandle(ReflectUtils.AnnotatedMethod<T> annotatedMethod)
			{
				this.annotation = annotatedMethod.annotation;
				this.executionHandleBuilder = ExecutionHandleBuilder.fromMethod(annotatedMethod.method);
			}
		}
	}
}
