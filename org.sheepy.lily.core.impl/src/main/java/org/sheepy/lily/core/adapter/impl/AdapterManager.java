package org.sheepy.lily.core.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.sheepy.lily.core.adapter.ITickDescriptor;
import org.sheepy.lily.core.api.adapter.IAdapter;

class AdapterManager extends EContentAdapter
{
	private static final String ADAPTER_CREATION_LOOP = "Adapter creation loop.";

	public final List<ITickDescriptor> tickers = new ArrayList<>();

	private final ServiceAdapterRegistry registry;
	private final List<AdapterExecutor<?>> executors = new ArrayList<>();

	private final List<Class<?>> constructingAdapters = new ArrayList<>();
	private boolean constructing = false;

	private EObject target;

	public AdapterManager(ServiceAdapterRegistry registry)
	{
		this.registry = registry;
	}

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
		super.setTarget(target);
	}

	@Override
	protected void unsetTarget(EObject target)
	{
		disposeAutoAdapters();
		super.unsetTarget(target);
	}

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

			// Optimize here. Allow to re-set a reference to trigger the listeners,
			// without destroying the AdapterManager
			if (oldValue != newValue)
			{
				if (oldValue != null)
				{
					removeAdapter(oldValue, false, true);
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
		final var adapters = notifier.eAdapters();

		for (int i = 0; i < adapters.size(); i++)
		{
			final var adapter = adapters.get(i);
			if (adapter instanceof AdapterManager)
			{
				return;
			}
		}

		adapters.add(new AdapterManager(registry));
	}

	@Override
	protected void removeAdapter(Notifier notifier)
	{
		final var it = notifier.eAdapters().iterator();
		while (it.hasNext())
		{
			if (it.next() instanceof AdapterManager)
			{
				it.remove();
				break;
			}
		}
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