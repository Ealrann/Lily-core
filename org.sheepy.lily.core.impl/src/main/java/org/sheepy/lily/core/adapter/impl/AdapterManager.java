package org.sheepy.lily.core.adapter.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.sheepy.lily.core.adapter.ITickDescriptor;
import org.sheepy.lily.core.api.adapter.IAdapter;

class AdapterManager extends EContentAdapter
{
	private final ServiceAdapterRegistry registry;
	private EObject target;
	private final List<Container> adapters = new ArrayList<>();
	public final List<ITickDescriptor> tickers = new ArrayList<>();

	public AdapterManager(ServiceAdapterRegistry registry)
	{
		this.registry = registry;
	}

	@Override
	public void notifyChanged(Notification notification)
	{
		for (final Container container : adapters)
		{
			container.definition.notifyChanged(container.adapter, notification);
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
			res = createAdapter(type, res);
		}

		return res;
	}

	@SuppressWarnings("unchecked")
	private <T extends IAdapter> T findAdapter(Class<T> type)
	{
		T res = null;
		for (int i = 0; i < adapters.size(); i++)
		{
			final var container = adapters.get(i);
			if (container.definition.isAdapterForType(type))
			{
				res = (T) container.adapter;
				break;
			}
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	private <T extends IAdapter> T createAdapter(Class<T> type, T res)
	{
		final var definition = registry.getDefinitionFor(target, type);
		if (definition != null)
		{
			res = (T) definition.create(target);
			final var container = new Container(definition, res);
			adapters.add(container);
			definition.load(target, res);

			if (definition.isTicker())
			{
				tickers.add(new TickDescriptor(container, target));
			}
		}
		return res;
	}

	@Override
	protected void addAdapter(Notifier notifier)
	{
		final EList<Adapter> eAdapters = notifier.eAdapters();
		for (final Adapter adapter : eAdapters)
		{
			if (adapter instanceof AdapterManager)
			{
				return;
			}
		}
		eAdapters.add(new AdapterManager(registry));
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
		final List<AdapterDefinition> autoAdapters = registry.getDefinitionsFor(target);
		if (autoAdapters != null)
		{
			for (final AdapterDefinition definition : autoAdapters)
			{
				if (definition.isAutoAdapter())
				{
					adapt(definition.domain.type);
				}
			}
		}
	}

	private void disposeAutoAdapters()
	{
		final List<AdapterDefinition> autoAdapters = registry.getDefinitionsFor(target);
		if (autoAdapters != null)
		{
			for (final AdapterDefinition definition : autoAdapters)
			{
				final var adapter = findAdapter(definition.domain.type);
				if (adapter != null)
				{
					definition.destroy(target, adapter);
				}
			}
		}
	}

	class Container
	{
		public final AdapterDefinition definition;
		public final IAdapter adapter;

		Container(AdapterDefinition definition, IAdapter adapter)
		{
			this.definition = definition;
			this.adapter = adapter;
		}
	}

	class TickDescriptor implements ITickDescriptor
	{
		private final Container container;
		private final EObject target;

		TickDescriptor(Container container, EObject target)
		{
			this.container = container;
			this.target = target;
		}

		@Override
		public int getFrequency()
		{
			return container.definition.getTickFrequency();
		}

		@Override
		public void tick(int frequencyToTick)
		{
			container.definition.tick(target, container.adapter);
		}

		@Override
		public String getName()
		{
			return container.adapter.getClass().getSimpleName();
		}

	}
}