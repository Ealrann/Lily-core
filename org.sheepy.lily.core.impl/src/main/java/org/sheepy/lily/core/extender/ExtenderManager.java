package org.sheepy.lily.core.extender;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.extender.*;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.model.LilyEObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ExtenderManager implements IExtenderManager.Internal
{
	private static final ExtenderDescriptorRegistry REGISTRY = (ExtenderDescriptorRegistry) IExtenderDescriptorRegistry.INSTANCE;
	private final ExtenderManagerDeployer deployer;
	private final List<IExtenderHandle<? extends IExtender>> handles = new ArrayList<>();

	private boolean loaded = false;

	public ExtenderManager(ILilyEObject target)
	{
		deployer = new ExtenderManagerDeployer(target);
	}

	@Override
	public void load()
	{
		if (!loaded)
		{
			deployer.setAutoLoad(true);
			buildAutoAdapters();
			loaded = true;
			streamHandles().forEach(this::loadHandle);
		}
		deployer.foreachChild(LilyEObject::loadAdapterManager);
	}

	@Override
	public void dispose()
	{
		deployer.foreachChild(LilyEObject::disposeAdapterManager);
		if (loaded)
		{
			loaded = false;
			deployer.setAutoLoad(false);
			streamHandles().forEach(this::disposeHandle);
		}
	}

	@Override
	public <T extends IExtender> Stream<T> adapt(Class<T> type)
	{
		return getOrCreateHandlesOfExtenderType(type).map(IExtenderHandle::getExtender);
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
		return REGISTRY.descriptors(deployer.getTarget())
					   .filter(descriptor -> descriptor.builder().getHandleClass() == handleType)
					   .map(builder -> (ExtenderDescriptorRegistry.DescriptorWraper<?>) builder)
					   .map(this::getOrCreateHandle)
					   .map(res -> (T) res);
	}

	@Override
	public <T extends IExtender> IExtenderHandle<T> adaptHandleFromDescriptor(final IExtenderDescriptor<T> descriptor)
	{
		return REGISTRY.getWrapper(descriptor).map(this::getOrCreateHandle).orElse(null);
	}

	private void buildAutoAdapters()
	{
		REGISTRY.descriptors(deployer.getTarget())
				.filter(ExtenderDescriptorRegistry.DescriptorWraper::isAuto)
				.forEach(this::getOrCreateHandle);
	}

	private <T extends IExtender> IExtenderHandle<T> getOrCreateHandle(final ExtenderDescriptorRegistry.DescriptorWraper<T> descriptor)
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
			return createHandles(type).stream();
		}
	}

	private <T extends IExtender> List<IExtenderHandle<T>> createHandles(final Class<T> type)
	{
		return REGISTRY.descriptors(deployer.getTarget(), type)
					   .map(this::createHandle)
					   .collect(Collectors.toUnmodifiableList());
	}

	private <T extends IExtender> IExtenderHandle<T> createHandle(ExtenderDescriptorRegistry.DescriptorWraper<T> descriptor)
	{
		final var target = deployer.getTarget();
		final var handle = descriptor.newHandle(target);
		handles.add(handle);
		return loadHandle(handle);
	}

	private <T extends IExtender, Y extends IExtenderHandle<T>> Y loadHandle(Y handle)
	{
		if (loaded)
		{
			final var target = deployer.getTarget();
			handle.load(target, deployer);
		}
		return handle;
	}

	private boolean containsType(final Class<? extends IExtender> type)
	{
		return handles.stream().anyMatch(handle -> type.isAssignableFrom(handle.getExtenderClass()));
	}

	@SuppressWarnings("unchecked")
	public <T extends IExtender> Stream<IExtenderHandle<T>> getHandles(final Class<T> type)
	{
		return handles.stream()
					  .filter(handle -> type.isAssignableFrom(handle.getExtenderClass()))
					  .map(handle -> (IExtenderHandle<T>) handle);
	}

	private Stream<IExtenderHandle<? extends IExtender>> streamHandles()
	{
		return handles.stream();
	}

	private <T extends IExtender> void disposeHandle(IExtenderHandle<T> handle)
	{
		final var target = deployer.getTarget();
		handle.dispose(target, deployer);
	}

	@Override
	public void listen(Consumer<Notification> listener, int... features)
	{
		deployer.listen(listener, features);
	}

	@Override
	public void sulk(Consumer<Notification> listener, int... features)
	{
		deployer.sulk(listener, features);
	}

	@Override
	public void listenNoParam(Runnable listener, int... features)
	{
		deployer.listenNoParam(listener, features);
	}

	@Override
	public void sulkNoParam(Runnable listener, int... features)
	{
		deployer.sulkNoParam(listener, features);
	}
}
