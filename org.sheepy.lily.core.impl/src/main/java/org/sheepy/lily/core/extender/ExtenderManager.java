package org.sheepy.lily.core.extender;

import org.sheepy.lily.core.api.extender.*;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ExtenderManager implements IExtenderManager.Internal
{
	private static final ExtenderDescriptorRegistry REGISTRY = (ExtenderDescriptorRegistry) IExtenderDescriptorRegistry.INSTANCE;

	private final List<HandleWrapper<? extends IExtender>> handles;
	private final IAdaptable target;

	private boolean disposed = false;

	public ExtenderManager(IAdaptable target)
	{
		this.target = target;
		handles = REGISTRY.descriptors(target)
						  .map(HandleWrapper::new)
						  .collect(Collectors.toUnmodifiableList());
	}

	@Override
	public void load()
	{
		if (disposed)
		{
			disposed = false;
			handles.forEach(w -> w.load(target));
		}
	}

	@Override
	public void dispose()
	{
		if (!disposed)
		{
			handles.forEach(w -> w.dispose(target));
			disposed = true;
		}
	}

	@Override
	public <T extends IExtender> T adapt(final Class<T> type)
	{
		return this.<T>handles(filter(type)).map(IExtenderHandle::getExtender)
											.filter(Objects::nonNull)
											.findAny()
											.orElse(null);
	}

	@Override
	public <T extends IExtender> T adapt(final Class<T> type, final String identifier)
	{
		return this.<T>handles(filter(type, identifier)).map(IExtenderHandle::getExtender)
														.filter(Objects::nonNull)
														.findAny()
														.orElse(null);
	}

	@Override
	public Stream<IExtenderDescriptor<?>> availableDescriptors()
	{
		return handles.stream()
					  .map(HandleWrapper::descriptor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IExtender> IExtenderHandle<T> adaptHandle(final IExtenderDescriptor<T> descriptor)
	{
		return handles.stream()
					  .filter(wrapper -> wrapper.descriptorContext.descriptor() == descriptor)
					  .map(handleWrapper -> handleWrapper.handle(target))
					  .map(handle -> (IExtenderHandle<T>) handle)
					  .findAny()
					  .orElse(null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IExtenderHandle<?>> Stream<T> adaptHandlesOfType(final Class<T> handleType)
	{
		return handles.stream()
					  .filter(w -> handleType.isAssignableFrom(w.descriptorContext.handleBuilder()
																				  .getHandleClass()))
					  .map(handleWrapper -> handleWrapper.handle(target))
					  .map(handle -> (T) handle);
	}

	private static Predicate<HandleWrapper<?>> filter(final Class<? extends IExtender> type, final String identifier)
	{
		return wrapper -> wrapper.descriptorContext.descriptor()
												   .match(type, identifier);
	}

	private static Predicate<HandleWrapper<?>> filter(final Class<? extends IExtender> type)
	{
		return wrapper -> wrapper.descriptorContext.descriptor()
												   .match(type);
	}

	@SuppressWarnings("unchecked")
	private <T extends IExtender> Stream<? extends IExtenderHandle<T>> handles(Predicate<HandleWrapper<?>> match)
	{
		return handles.stream()
					  .filter(match)
					  .map(handleWrapper -> handleWrapper.handle(target))
					  .map(handle -> (IExtenderHandle<T>) handle);
	}

	private static final class HandleWrapper<T extends IExtender>
	{
		private final DescriptorContext<T> descriptorContext;
		private IExtenderHandle<T> handle = null;

		public HandleWrapper(final DescriptorContext<T> descriptorContext)
		{
			this.descriptorContext = descriptorContext;
		}

		public IExtenderHandle<T> handle(final IAdaptable target)
		{
			if (handle == null)
			{
				handle = descriptorContext.handleBuilder()
										  .build(target);
				handle.load(target);
			}
			return handle;
		}

		public IExtenderDescriptor<T> descriptor()
		{
			return descriptorContext.descriptor();
		}

		public void load(final IAdaptable target)
		{
			if (handle != null) handle.load(target);
		}

		public void dispose(final IAdaptable target)
		{
			if (handle != null) handle.dispose(target);
		}
	}
}
