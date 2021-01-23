package org.sheepy.lily.core.adapter;

import org.logoce.extender.api.*;
import org.logoce.extender.api.parameter.IParameterResolver;
import org.logoce.extender.api.reflect.ConsumerHandle;
import org.sheepy.lily.core.api.adapter.Dispose;
import org.sheepy.lily.core.api.adapter.Load;

import java.lang.annotation.Annotation;
import java.util.Optional;

public final class LoadDisposeAdapterExtension implements IAdapterExtension
{
	private final AnnotationHandles annotationHandles;

	private LoadDisposeAdapterExtension(final AnnotationHandles annotationHandles)
	{
		this.annotationHandles = annotationHandles;
	}

	@Override
	public void load(final IAdaptable target)
	{
		handles(Load.class, target);
	}

	@Override
	public void dispose(final IAdaptable target)
	{
		handles(Dispose.class, target);
	}

	private <A extends Annotation> void handles(final Class<A> annotationClass, Object... parameters)
	{
		annotationHandles.stream(annotationClass)
						 .map(IAdapterHandle.AnnotatedHandle::executionHandle)
						 .map(ConsumerHandle.class::cast)
						 .iterator()
						 .forEachRemaining(handle -> handle.invoke(parameters));
	}

	@Override
	public boolean isEmpty()
	{
		return false;
	}

	public static final class Builder implements IAdapterExtension.Builder
	{
		@Override
		public LoadDisposeAdapterExtension build(final IAdapterDescriptor.ExtenderContext<?> context)
		{
			return new LoadDisposeAdapterExtension(context.annotationHandles());
		}

		@Override
		public Optional<IParameterResolver> parameterResolver()
		{
			return Optional.empty();
		}
	}

	public static final class Descriptor implements IAdapterExtension.Descriptor
	{
		@Override
		public IAdapterExtension.Builder newBuilder()
		{
			return new Builder();
		}
	}
}
