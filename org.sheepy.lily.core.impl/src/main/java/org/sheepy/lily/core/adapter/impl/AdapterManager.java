package org.sheepy.lily.core.adapter.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.sheepy.lily.core.adapter.ITickDescriptor;
import org.sheepy.lily.core.api.adapter.IAdapter;

class AdapterManager extends EContentAdapter
{
	public final List<ITickDescriptor> tickers = new ArrayList<>();

	private final ServiceAdapterRegistry registry;
	private final List<Container<?>> adapters = new ArrayList<>();

	private EObject target;

	public AdapterManager(ServiceAdapterRegistry registry)
	{
		this.registry = registry;
	}

	@Override
	public void notifyChanged(Notification notification)
	{
		super.notifyChanged(notification);
		for (int i = 0; i < adapters.size(); i++)
		{
			final var container = adapters.get(i);
			container.notifyChanged(notification);
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
		for (int i = 0; i < adapters.size(); i++)
		{
			final var container = adapters.get(i);
			if (container.domain.isAdapterForType(type))
			{
				res = type.cast(container.adapter);
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
			res = descriptor.executor.create(target);
			final var container = new Container<>(descriptor, res);
			adapters.add(container);
			container.executor.load(target, res);

			if (container.executor.isTicker())
			{
				tickers.add(new TickDescriptor(container, target));
			}
		}

		return res;
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
		final Iterator<Adapter> it = notifier.eAdapters().iterator();
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
				if (descriptor.executor.isAutoAdapter())
				{
					adapt(descriptor.domain.type);
				}
			}
		}
	}

	private void disposeAutoAdapters()
	{
		final var autoAdapters = registry.getDefinitionsFor(target);
		if (autoAdapters != null)
		{
			for (int i = 0; i < autoAdapters.size(); i++)
			{
				final var descriptor = autoAdapters.get(i);
				final var adapter = findAdapter(descriptor.domain.type);
				if (adapter != null)
				{
					descriptor.executor.destroy(target, adapter);
				}
			}
		}
	}

	private static class Container<T extends IAdapter> extends AdapterDescriptor<T>
	{
		public final IAdapter adapter;

		Container(AdapterDescriptor<T> descriptor, IAdapter adapter)
		{
			super(descriptor.domain, descriptor.executor);
			this.adapter = adapter;
		}

		public void notifyChanged(Notification notification)
		{
			executor.notifyChanged(adapter, notification);
		}
	}

	private static class TickDescriptor implements ITickDescriptor
	{
		private final Container<?> container;
		private final EObject target;

		TickDescriptor(Container<?> container, EObject target)
		{
			this.container = container;
			this.target = target;
		}

		@Override
		public int getFrequency()
		{
			return container.executor.getTickFrequency();
		}

		@Override
		public void tick(long stepNs)
		{
			container.executor.tick(target, container.adapter, stepNs);
		}

		@Override
		public String getName()
		{
			return container.adapter.getClass().getSimpleName();
		}

		@Override
		public int getPriority()
		{
			return container.executor.getTickPriority();
		}

	}
}