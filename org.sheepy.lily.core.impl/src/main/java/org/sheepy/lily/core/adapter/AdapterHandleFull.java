package org.sheepy.lily.core.adapter;

import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.extender.*;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;

public final class AdapterHandleFull<Extender extends IExtender> implements IExtenderHandle<Extender>
{
	private final Extender extender;
	private final AnnotationHandles annotationHandles;
	private final List<IAdapterExtension> extensions;

	public AdapterHandleFull(final Extender extender,
							 final AnnotationHandles annotationHandles,
							 final List<IAdapterExtension> extensions)
	{
		this.extender = extender;
		this.annotationHandles = annotationHandles;
		this.extensions = List.copyOf(extensions);
	}

	@Override
	public void load(final IAdaptable target)
	{
		for (final var extension : extensions)
		{
			try
			{
				extension.load(target);
			}
			catch (Throwable e)
			{
				throwObserveError(e, extension);
			}
		}
		handles(Load.class, target);
	}

	@Override
	public void dispose(final IAdaptable target)
	{
		extensions.forEach(e -> e.dispose(target));
		handles(Dispose.class, target);
	}

	private <A extends Annotation> void handles(final Class<A> annotationClass, Object... parameters)
	{
		annotationHandles.stream(annotationClass)
						 .map(IExtenderHandle.AnnotatedHandle::executionHandle)
						 .map(ConsumerHandle.class::cast)
						 .iterator()
						 .forEachRemaining(handle -> handle.invoke(parameters));
	}

	@Override
	public <A extends Annotation> Stream<IExtenderHandle.AnnotatedHandle<A>> annotatedHandles(Class<A> annotationClass)
	{
		return annotationHandles.stream(annotationClass);
	}

	private void throwObserveError(final Throwable e, final IAdapterExtension extension)
	{
		final var extenderName = extender.getClass()
										 .getSimpleName();
		final var error = new AssertionError("Failed to start " + extension.getClass()
																		   .getSimpleName() + " for " + extenderName,
											 e);
		error.printStackTrace();
	}

	@Override
	public Extender getExtender()
	{
		return extender;
	}

	@Override
	public void listen(final ExtenderListener<Extender> listener)
	{
		// Not changeable, nothing to listen
	}

	@Override
	public void listenNoParam(final Runnable listener)
	{
		// Not changeable, nothing to listen
	}

	@Override
	public void sulk(final ExtenderListener<Extender> listener)
	{
		// Not changeable, nothing to listen
	}

	@Override
	public void sulkNoParam(final Runnable listener)
	{
		// Not changeable, nothing to listen
	}
}
