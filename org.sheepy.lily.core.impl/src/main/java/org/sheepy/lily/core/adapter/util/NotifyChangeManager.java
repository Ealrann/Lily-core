package org.sheepy.lily.core.adapter.util;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.extender.IAdaptable;
import org.sheepy.lily.core.api.extender.IAdapterExtension;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;
import org.sheepy.lily.core.api.notification.IEMFNotifier;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public final class NotifyChangeManager implements IAdapterExtension
{
	private final List<IExtenderHandle.AnnotatedHandle<NotifyChanged>> notifyHandles;

	public NotifyChangeManager(final List<IExtenderHandle.AnnotatedHandle<NotifyChanged>> notifyHandles)
	{
		this.notifyHandles = notifyHandles;
	}

	@Override
	public void load(final IAdaptable target)
	{
		final var notifier = (IEMFNotifier) target;
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
		final var notifier = (IEMFNotifier) target;
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
	public boolean isEmpty()
	{
		return notifyHandles.isEmpty();
	}

	public static final class Builder implements IAdapterExtension.Builder
	{
		@Override
		public IAdapterExtension build(final IExtenderDescriptor.ExtenderContext<?> context)
		{
			final var notifyHandles = context.annotationHandles()
											 .stream(NotifyChanged.class)
											 .collect(Collectors.toUnmodifiableList());
			return new NotifyChangeManager(notifyHandles);
		}

		@Override
		public Optional<IParameterResolver> parameterResolver()
		{
			return Optional.empty();
		}
	}
}
