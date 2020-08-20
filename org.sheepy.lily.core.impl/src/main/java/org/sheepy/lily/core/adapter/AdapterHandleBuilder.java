package org.sheepy.lily.core.adapter;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.extender.IExtenderHandleBuilder;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;

import java.util.List;

public final class AdapterHandleBuilder<T extends IExtender> implements IExtenderHandleBuilder<T>
{
	private final IExtenderDescriptor<T> extenderDescriptor;
	private final IExtenderHandle<T> singleton;
	private final boolean lazy;

	public AdapterHandleBuilder(IExtenderDescriptor<T> extenderDescriptor)
	{
		this.extenderDescriptor = extenderDescriptor;
		final var adapterAnnotation = extenderDescriptor.extenderClass().getAnnotation(Adapter.class);
		final var isSingleton = adapterAnnotation.singleton();
		this.lazy = adapterAnnotation.lazy();
		this.singleton = isSingleton ? newHandle(null) : null;
	}

	@Override
	public IExtenderHandle<T> build(final ILilyEObject target)
	{
		return singleton != null ? singleton : newHandle(target);
	}

	private IExtenderHandle<T> newHandle(final ILilyEObject target)
	{
		try
		{
			final var observatoryBuilder = IObservatoryBuilder.newObservatoryBuilder();
			final var extenderContext = extenderDescriptor.newExtender(target, observatoryBuilder, List.of());
			final var observatory = observatoryBuilder.isEmpty() ? null : observatoryBuilder.build();
			return buildNewHandle(extenderContext, observatory);
		}
		catch (ReflectiveOperationException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	private IExtenderHandle<T> buildNewHandle(final IExtenderDescriptor.ExtenderContext<T> extenderContext,
											  final org.sheepy.lily.core.api.notification.observatory.IObservatory observatory)
	{
		if (observatory != null || extenderContext.annotationHandles().isEmpty() == false)
		{
			return new AdapterHandleFull<>(extenderContext.extender(),
										   extenderContext.annotationHandles(),
										   observatory);
		}
		else
		{
			return new AdapterHandleWrapper<>(extenderContext.extender());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<AdapterHandleFull<T>> getHandleClass()
	{
		return (Class<AdapterHandleFull<T>>) (Class<?>) AdapterHandleFull.class;
	}

	@Override
	public boolean isAuto()
	{
		return !lazy;
	}
}
