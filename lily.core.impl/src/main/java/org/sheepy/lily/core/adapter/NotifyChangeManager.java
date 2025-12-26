package org.sheepy.lily.core.adapter;

import org.logoce.lmf.core.api.extender.IAdaptable;
import org.logoce.lmf.core.api.extender.IAdapterDescriptor;
import org.logoce.lmf.core.api.extender.IAdapterExtension;
import org.logoce.lmf.core.api.extender.IAdapterHandle;
import org.logoce.lmf.core.api.extender.parameter.IParameterResolver;
import org.logoce.lmf.core.api.extender.reflect.ConsumerHandle;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.notification.Notification;
import org.sheepy.lily.core.api.adapter.NotifyChanged;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public final class NotifyChangeManager implements IAdapterExtension
{
	private final List<IAdapterHandle.AnnotatedHandle<NotifyChanged>> notifyHandles;

	public NotifyChangeManager(final List<IAdapterHandle.AnnotatedHandle<NotifyChanged>> notifyHandles)
	{
		this.notifyHandles = notifyHandles;
	}

	@Override
	public void load(final IAdaptable target)
	{
		final var notifier = ((IFeaturedObject) target).notifier();
		notifyHandles.forEach(notifyHandle -> {
			final var featureIds = notifyHandle.annotation()
											   .featureIds();
			final var executionHandle = (ConsumerHandle) notifyHandle.executionHandle();
			final var lambda = executionHandle.getLambdaFunction();
			if (lambda instanceof Runnable)
			{
				notifier.listenNoParam((Runnable) lambda, featureIds);
			}
			else if (lambda instanceof Consumer)
			{
				@SuppressWarnings("unchecked") final var consumer = (Consumer<Notification>) lambda;
				notifier.listen(consumer, featureIds);
			}
		});
	}

	@Override
	public void dispose(final IAdaptable target)
	{
		final var notifier = ((IFeaturedObject) target).notifier();
		notifyHandles.forEach(notifyHandle -> {
			final var featureIds = notifyHandle.annotation()
											   .featureIds();
			final var executionHandle = (ConsumerHandle) notifyHandle.executionHandle();
			final var lambda = executionHandle.getLambdaFunction();
			if (lambda instanceof Runnable)
			{
				notifier.sulkNoParam((Runnable) lambda, featureIds);
			}
			else if (lambda instanceof Consumer)
			{
				@SuppressWarnings("unchecked") final var consumer = (Consumer<Notification>) lambda;
				notifier.sulk(consumer, featureIds);
			}
		});
	}

	@Override
	public boolean isEmpty()
	{
		return notifyHandles.isEmpty();
	}

	public static final class Builder implements IAdapterExtension.Builder
	{
		@Override
		public IAdapterExtension build(final IAdapterDescriptor.ExtenderContext<?> context)
		{
			final var notifyHandles = context.annotationHandles()
											 .stream(NotifyChanged.class)
											 .toList();
			return new NotifyChangeManager(notifyHandles);
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
