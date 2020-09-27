package org.sheepy.lily.core.extender;

import org.sheepy.lily.core.api.extender.*;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public final class ExtenderManager implements IExtenderManager.Internal
{
	private static final ExtenderDescriptorRegistry REGISTRY = (ExtenderDescriptorRegistry) IExtenderDescriptorRegistry.INSTANCE;

	private final List<IExtenderHandle<? extends IExtender>> handles = new ArrayList<>(2);
	private final ILilyEObject target;

	private boolean loaded = false;

	public ExtenderManager(ILilyEObject target)
	{
		this.target = target;
	}

	@Override
	public void deploy()
	{
		buildAutoAdapters();
	}

	@Override
	public void load()
	{
		if (!loaded)
		{
			loaded = true;
			streamHandles().forEach(this::loadHandle);
		}
	}

	@Override
	public void dispose()
	{
		if (loaded)
		{
			streamHandles().forEach(this::disposeHandle);
			loaded = false;
		}
	}

	@Override
	public <T extends IExtender> Stream<T> adapt(Class<T> type)
	{
		return getOrCreateHandlesOfExtenderType(type).map(IExtenderHandle::getExtender).filter(Objects::nonNull);
	}

	@Override
	public <T extends IExtender> Stream<? extends IExtenderHandle<T>> adaptHandles(Class<T> type)
	{
		return getOrCreateHandlesOfExtenderType(type);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IExtenderHandle<?>> Stream<T> adaptHandlesOfType(final Class<T> handleType)
	{
		return REGISTRY.descriptors(target)
					   .filter(descriptor -> descriptor.handleBuilder().getHandleClass() == handleType)
					   .map(builder -> (DescriptorContext<?>) builder)
					   .map(this::getOrCreateHandle)
					   .map(res -> (T) res);
	}

	@Override
	public <T extends IExtender> IExtenderHandle<T> adaptHandleFromDescriptor(final IExtenderDescription<T> descriptor)
	{
		return REGISTRY.getDescriptorContext(descriptor).map(this::getOrCreateHandle).orElse(null);
	}

	private void buildAutoAdapters()
	{
		REGISTRY.descriptors(target)
				.filter(DescriptorContext::isAuto)
				.iterator()
				.forEachRemaining(this::getOrCreateHandle);
	}

	private <T extends IExtender> IExtenderHandle<T> getOrCreateHandle(final DescriptorContext<T> descriptor)
	{
		final Class<T> type = descriptor.descriptor().extenderClass();
		if (containsType(type))
		{
			return getHandles(type).findFirst().orElse(null);
		}
		else
		{
			return createHandle(descriptor);
		}
	}

	private <T extends IExtender> Stream<? extends IExtenderHandle<T>> getOrCreateHandlesOfExtenderType(Class<T> type)
	{
		if (containsType(type))
		{
			return getHandles(type);
		}
		else
		{
			return createHandles(type);
		}
	}

	private <T extends IExtender> Stream<IExtenderHandle<T>> createHandles(final Class<T> type)
	{
		return REGISTRY.descriptors(target, type).map(this::createHandle);
	}

	private <T extends IExtender> IExtenderHandle<T> createHandle(DescriptorContext<T> descriptor)
	{
		final var handle = descriptor.newHandle(target);
		handles.add(handle);
		loadHandle(handle);
		return handle;
	}

	private void loadHandle(IExtenderHandle<?> handle)
	{
		if (loaded)
		{
			handle.load(target);
		}
	}

	private boolean containsType(final Class<? extends IExtender> type)
	{
		return handles.stream().anyMatch(handle -> type.isAssignableFrom(handle.getExtenderClass()));
	}

	@SuppressWarnings("unchecked")
	public <T extends IExtender> Stream<IExtenderHandle<T>> getHandles(final Class<T> type)
	{
		return handles.stream()
					  .filter(handle -> handle.match(type))
					  .map(handle -> (IExtenderHandle<T>) handle);
	}

	private Stream<IExtenderHandle<? extends IExtender>> streamHandles()
	{
		return handles.stream();
	}

	private <T extends IExtender> void disposeHandle(IExtenderHandle<T> handle)
	{
		handle.dispose(target);
	}
}
