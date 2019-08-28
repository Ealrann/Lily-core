package org.sheepy.lily.core.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.sheepy.lily.core.adapter.ITickDescriptor;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterManager;
import org.sheepy.lily.core.api.adapter.ILilyEObject;

final class AdapterManager extends EContentAdapter implements IAdapterManager
{
	private static final String ADAPTER_CREATION_LOOP = "Adapter creation loop.";
	private static final ServiceAdapterRegistry registry = ServiceAdapterRegistry.INSTANCE;

	public final List<ITickDescriptor> tickers = new ArrayList<>();

	private final List<AdapterExecutor<?>> executors = new ArrayList<>();
	private final List<Class<?>> constructingAdapters = new ArrayList<>();

	private boolean constructing = false;
	private EObject target;

	@Override
	public void notifyChanged(Notification notification)
	{
		super.notifyChanged(notification);
		for (int i = 0; i < executors.size(); i++)
		{
			final var executor = executors.get(i);
			executor.notifyChanged(notification);
		}
	}

	@Override
	protected void setTarget(EObject target)
	{
		this.target = target;
		loadAutoAdapters();

		final EList<EObject> eContents = target.eContents();
		for (int i = 0; i < eContents.size(); i++)
		{
			final var child = eContents.get(i);
			addAdapter(child);
		}
	}

	@Override
	protected void unsetTarget(EObject target)
	{
		final EList<EObject> eContents = target.eContents();
		for (int i = 0; i < eContents.size(); i++)
		{
			final var child = eContents.get(i);
			unsetTarget(child);
		}

		disposeAutoAdapters();
	}

	@Override
	protected boolean resolve()
	{
		return false;
	}

	@Override
	public <T extends IAdapter> T adapt(Class<T> type)
	{
		if (constructing && constructingAdapters.contains(type))
		{
			throw new AssertionError(ADAPTER_CREATION_LOOP);
		}

		T res = findAdapter(type);

		if (res == null)
		{
			res = createAdapter(type);
		}

		return res;
	}

	private <T extends IAdapter> T findAdapter(Class<T> type)
	{
		T res = null;
		for (int i = 0; i < executors.size(); i++)
		{
			final var executor = executors.get(i);
			if (executor.domain.isAdapterForType(type))
			{
				res = type.cast(executor.adapter);
				break;
			}
		}
		return res;
	}

	private <T extends IAdapter> T createAdapter(Class<T> type)
	{
		T res = null;

		final var descriptor = registry.getDescriptorFor(target, type);
		if (descriptor != null)
		{
			constructingAdapters.add(type);
			res = descriptor.info.create(target);
			final var executor = new AdapterExecutor<>(descriptor, target, res);
			executors.add(executor);
			constructingAdapters.remove(type);

			constructing = !constructingAdapters.isEmpty();

			executor.load();

			if (executor.info.isTicker())
			{
				tickers.add(executor);
			}
		}

		return res;
	}

	@Override
	protected void handleContainment(Notification notification)
	{
		switch (notification.getEventType())
		{
		case Notification.SET:
		{
			final Notifier oldValue = (Notifier) notification.getOldValue();
			final Notifier newValue = (Notifier) notification.getNewValue();

			// Allow to re-set a reference to trigger the listeners,
			// without destroying the AdapterManager
			if (oldValue != newValue)
			{
				if (oldValue != null)
				{
					removeAdapter(oldValue);
				}
				if (newValue != null)
				{
					addAdapter(newValue);
				}
			}
			break;
		}
		default:
			super.handleContainment(notification);
		}
	}

	@Override
	protected void addAdapter(Notifier notifier)
	{
		final var lilyObject = (ILilyEObject) notifier;

		if (lilyObject.getAdapterManager() == null)
		{
			lilyObject.setAdapterManager(new AdapterManager());
		}
	}

	@Override
	protected void removeAdapter(Notifier notifier)
	{
		final var lilyObject = (ILilyEObject) notifier;
		lilyObject.setAdapterManager(null);
	}

	private void loadAutoAdapters()
	{
		final var autoAdapters = registry.getDefinitionsFor(target);
		if (autoAdapters != null)
		{
			for (int i = 0; i < autoAdapters.size(); i++)
			{
				final var descriptor = autoAdapters.get(i);
				if (descriptor.info.isAutoAdapter())
				{
					adapt(descriptor.domain.type);
				}
			}
		}
	}

	private void disposeAutoAdapters()
	{
		for (int i = 0; i < executors.size(); i++)
		{
			final var executor = executors.get(i);
			executor.dispose();
		}
	}
}