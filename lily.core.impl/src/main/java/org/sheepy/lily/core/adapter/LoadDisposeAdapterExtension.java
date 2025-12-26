package org.sheepy.lily.core.adapter;

import org.logoce.lmf.core.api.extender.parameter.IParameterResolver;
import org.logoce.lmf.core.api.extender.reflect.ConsumerHandle;
import org.sheepy.lily.core.api.adapter.Dispose;
import org.sheepy.lily.core.api.adapter.Load;

import java.lang.annotation.Annotation;
import java.util.Optional;

public final class LoadDisposeAdapterExtension implements org.logoce.lmf.core.api.extender.IAdapterExtension
{
	private final org.logoce.lmf.core.api.extender.AnnotationHandles annotationHandles;

	private LoadDisposeAdapterExtension(final org.logoce.lmf.core.api.extender.AnnotationHandles annotationHandles)
	{
		this.annotationHandles = annotationHandles;
	}

	@Override
	public void load(final org.logoce.lmf.core.api.extender.IAdaptable target)
	{
		handles(Load.class, target);
	}

	@Override
	public void dispose(final org.logoce.lmf.core.api.extender.IAdaptable target)
	{
		handles(Dispose.class, target);
	}

	private <A extends Annotation> void handles(final Class<A> annotationClass, Object... parameters)
	{
		annotationHandles.stream(annotationClass)
						 .map(org.logoce.lmf.core.api.extender.IAdapterHandle.AnnotatedHandle::executionHandle)
						 .map(ConsumerHandle.class::cast)
						 .iterator()
						 .forEachRemaining(handle -> handle.invoke(parameters));
	}

	@Override
	public boolean isEmpty()
	{
		return false;
	}

	public static final class Builder implements org.logoce.lmf.core.api.extender.IAdapterExtension.Builder
	{
		@Override
		public LoadDisposeAdapterExtension build(final org.logoce.lmf.core.api.extender.IAdapterDescriptor.ExtenderContext<?> context)
		{
			return new LoadDisposeAdapterExtension(context.annotationHandles());
		}

		@Override
		public Optional<IParameterResolver> parameterResolver()
		{
			return Optional.empty();
		}
	}

	public static final class Descriptor implements org.logoce.lmf.core.api.extender.IAdapterExtension.Descriptor
	{
		@Override
		public org.logoce.lmf.core.api.extender.IAdapterExtension.Builder newBuilder()
		{
			return new Builder();
		}
	}
}
