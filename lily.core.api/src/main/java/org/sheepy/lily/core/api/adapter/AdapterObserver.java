package org.sheepy.lily.core.api.adapter;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.api.notification.util.ModelObserver;
import org.logoce.lmf.core.api.notification.util.NotificationUnifier;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class AdapterObserver<Adapter extends IAdapter>
{
	private final ModelObserver observer;
	private final Class<Adapter> adapterType;
	private final Consumer<Adapter> newAdapter;
	private final Consumer<Adapter> oldAapter;
	private final Map<LMObject, Adapter> adaptedMap = new HashMap<>();

	public AdapterObserver(final Class<Adapter> adapterType,
						   final int[] referenceIds,
						   final Consumer<Adapter> newAdapter,
						   final Consumer<Adapter> oldAapter)
	{
		this.observer = new ModelObserver(this::notifyChanged, referenceIds);
		this.adapterType = adapterType;
		this.newAdapter = newAdapter;
		this.oldAapter = oldAapter;
	}

	/**
	 * @param deliver Enable or disable the notifications.
	 */
	public void setDeliver(boolean deliver)
	{
		observer.setDeliver(deliver);
	}

	private void notifyChanged(final Notification notification)
	{
		if (notification.newValue() != notification.oldValue())
		{
			NotificationUnifier.unify(notification, this::add, this::remove);
		}
	}

	public void startObserve(final LMObject root)
	{
		observer.startObserve(root);
	}

	public void stopObserve(final LMObject root)
	{
		observer.stopObserve(root);
	}

	private void add(final LMObject newValue)
	{
		final var adapter = newValue.adapt(adapterType);
		if (adapter != null)
		{
			adaptedMap.put(newValue, adapter);
			newAdapter.accept(adapter);
		}
	}

	private void remove(final LMObject oldValue)
	{
		final var oldAdapter = adaptedMap.get(oldValue);
		if (oldAdapter != null)
		{
			oldAapter.accept(oldAdapter);
		}
	}
}

