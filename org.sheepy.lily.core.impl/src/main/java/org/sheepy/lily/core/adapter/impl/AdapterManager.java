package org.sheepy.lily.core.adapter.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.sheepy.lily.core.adapter.ITickDescriptor;
import org.sheepy.lily.core.api.adapter.IAdapter;

class AdapterManager extends EContentAdapter implements ITickDescriptor
{
	private final ServiceAdapterRegistry registry;
	private EObject target;
	private final List<Container> adapters = new ArrayList<>();
	private final Map<Integer, List<AdapterDefinition>> tickers = new HashMap<>();

	private boolean isTicker = false;

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
		final var definition = registry.getAdapterFor(target, type);
		if (definition != null)
		{
			res = (T) definition.create(target);
			adapters.add(new Container(definition, res));
			definition.load(target, res);

			if (definition.isTicker())
			{
				isTicker = true;

				final int frequency = definition.getTickFrequency();
				List<AdapterDefinition> list = tickers.get(frequency);
				if (list == null)
				{
					list = new ArrayList<>(1);
					tickers.put(frequency, list);
				}
				list.add(definition);
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
		final List<AdapterDefinition> autoAdapters = registry.getAdaptersFor(target);
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
		final List<AdapterDefinition> autoAdapters = registry.getAdaptersFor(target);
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

	@Override
	public boolean isTicker()
	{
		return isTicker;
	}

	@Override
	public Collection<Integer> getTickFrequencies()
	{
		return tickers.keySet();
	}

	@Override
	public void tick(int frequencyToTick)
	{
		for (final AdapterDefinition definition : tickers.get(frequencyToTick))
		{
			final var adapter = adapt(definition.domain.type);
			definition.tick(target, adapter);
		}
	}

	@Override
	public String getName()
	{
		return target.eClass().getName();
	}
}