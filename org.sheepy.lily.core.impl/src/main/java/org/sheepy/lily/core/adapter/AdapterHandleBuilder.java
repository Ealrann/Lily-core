package org.sheepy.lily.core.adapter;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class AdapterHandleBuilder<T extends IExtender> implements IExtenderHandleBuilder<T>
{
	private final IExtenderDescriptor<T> extenderDescriptor;
	private final List<IAdapterExtension.Descriptor> extensionDescriptors;
	private final IExtenderHandle<T> singleton;

	public AdapterHandleBuilder(final IExtenderDescriptor<T> extenderDescriptor,
								final List<IAdapterExtension.Descriptor> extensionDescriptors)
	{
		this.extenderDescriptor = extenderDescriptor;
		this.extensionDescriptors = List.copyOf(extensionDescriptors);
		final var adapterAnnotation = extenderDescriptor.extenderClass()
														.getAnnotation(Adapter.class);
		final var isSingleton = adapterAnnotation.singleton();
		this.singleton = isSingleton ? newHandle(null) : null;
	}

	@Override
	public IExtenderHandle<T> build(final IAdaptable target)
	{
		return singleton != null ? singleton : newHandle(target);
	}

	private IExtenderHandle<T> newHandle(final IAdaptable target)
	{
		try
		{
			final var extensionBuilders = extensionDescriptors.stream()
															  .map(IAdapterExtension.Descriptor::newBuilder)
															  .collect(Collectors.toUnmodifiableList());
			final var parameterResolvers = extensionBuilders.stream()
															.map(IAdapterExtension.Builder::parameterResolver)
															.filter(Optional::isPresent)
															.map(Optional::get);
			final var extenderContext = extenderDescriptor.newExtender(target, parameterResolvers);
			final var extensions = extensionBuilders.stream()
													.map(builder -> builder.build(extenderContext))
													.collect(Collectors.toUnmodifiableList());
			return buildNewHandle(extenderContext, extensions);
		}
		catch (ReflectiveOperationException e)
		{
			throw new AssertionError(e);
		}
	}

	private IExtenderHandle<T> buildNewHandle(final IExtenderDescriptor.ExtenderContext<T> extenderContext,
											  final List<IAdapterExtension> extensions)
	{
		final var noAnnotations = extenderContext.annotationHandles()
												 .isEmpty();
		final var noExtensions = extensions.stream()
										   .allMatch(IAdapterExtension::isEmpty);
		if (noAnnotations && noExtensions)
		{
			return new AdapterHandleWrapper<>(extenderContext.extender());
		}
		else
		{
			return new AdapterHandleFull<>(extenderContext.extender(), extenderContext.annotationHandles(), extensions);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<AdapterHandleFull<T>> getHandleClass()
	{
		return (Class<AdapterHandleFull<T>>) (Class<?>) AdapterHandleFull.class;
	}
}
