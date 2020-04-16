package org.sheepy.lily.core.adapter;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.adapter.annotation.AnnotationHandles;
import org.sheepy.lily.core.api.adapter.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class AdapterManager implements IAdapterManager
{
	private final List<AnnotationHandles<?>> annotationHandleMap = new ArrayList<>();
	private final AdapterManagerDeployer deployer;
	private final AdapterHandleManager handleManager;
	private final List<AdapterHandle<?>> adapterHandles = new ArrayList<>();

	private boolean loaded = false;

	public AdapterManager(ILilyEObject target)
	{
		handleManager = new AdapterHandleManager();
		deployer = new AdapterManagerDeployer(target);
		adapterHandles.addAll(handleManager.buildAutoAdapters(target));
		for (var autoAdapter : adapterHandles)
		{
			addAnnotationHandles(autoAdapter.annotationHandles);
			addHandleListener(autoAdapter);
		}
		deployer.foreachChild(LilyEObject::setupAdapterManager);
	}

	private void addAnnotationHandles(final List<AnnotationHandles<?>> annotationHandles)
	{
		for (var newHandleContainer : annotationHandles)
		{
			addAnnotationHandleContainer(newHandleContainer);
		}
	}

	private <T extends IAdapterAnnotationHandle> void addAnnotationHandleContainer(final AnnotationHandles<T> newHandleContainer)
	{
		final var type = newHandleContainer.type;
		final var found = getAnnotationHandles(type);
		if (found != null)
		{
			annotationHandleMap.remove(found);
			annotationHandleMap.add(found.merge(newHandleContainer));
		}
		else
		{
			annotationHandleMap.add(newHandleContainer);
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends IAdapterAnnotationHandle> AnnotationHandles<T> getAnnotationHandles(Class<T> type)
	{
		for (var handleContainer : annotationHandleMap)
		{
			if (handleContainer.type == type)
			{
				return (AnnotationHandles<T>) handleContainer;
			}
		}
		return null;
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

	@Override
	public <T extends IAdapter> T adapt(Class<T> type)
	{
		final T res = findAdapter(type);

		if (res != null)
		{
			return res;
		}
		else
		{
			return createAdapter(type);
		}
	}

	private <T extends IAdapter> T createAdapter(final Class<T> type)
	{
		final var target = getTarget();
		final var newHandle = handleManager.createHandle(target, type, loaded);
		if (newHandle != null)
		{
			adapterHandles.add(newHandle);
			addAnnotationHandles(newHandle.annotationHandles);
			addHandleListener(newHandle);
			if (loaded) newHandle.load(target);
			return newHandle.adapter;
		}
		else
		{
			return null;
		}
	}

	public ILilyEObject getTarget()
	{
		return (ILilyEObject) deployer.getTarget();
	}

	private <T extends IAdapter> T findAdapter(Class<T> type)
	{
		for (int i = 0; i < adapterHandles.size(); i++)
		{
			final var adapterHandle = adapterHandles.get(i);
			if (adapterHandle.isAdapterForType(type))
			{
				return type.cast(adapterHandle.adapter);
			}
		}
		return null;
	}

	@Override
	public void load()
	{
		if (!loaded)
		{
			loaded = true;
			deployer.setAutoLoad(true);

			final var target = getTarget();
			for (int i = 0; i < adapterHandles.size(); i++)
			{
				final var adapterHandle = adapterHandles.get(i);
				adapterHandle.load(target);
			}
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

			final var target = getTarget();
			for (int i = 0; i < adapterHandles.size(); i++)
			{
				final var adapterHandle = adapterHandles.get(i);
				adapterHandle.dispose(target);
			}
		}
	}

	@Override
	public <T extends IAdapterAnnotationHandle> List<T> annotationHandles(final Class<T> type)
	{
		final var annotationHandles = getAnnotationHandles(type);
		if (annotationHandles != null)
		{
			return annotationHandles.handles;
		}
		else
		{
			return List.of();
		}
	}

	private void addHandleListener(AdapterHandle<?> adapterHandle)
	{
		final var notifyHandles = adapterHandle.notifyHandles;
		for (int i = 0; i < notifyHandles.size(); i++)
		{
			final var notifyHandle = notifyHandles.get(i);
			final var featureIds = notifyHandle.featureIds;

			listen(notifyHandle, featureIds);
		}
	}
}
