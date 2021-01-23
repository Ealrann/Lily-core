package org.sheepy.lily.core.api.adapter;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.core.api.notification.util.ModelObserver;
import org.sheepy.lily.core.api.notification.util.NotificationUnifier;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class AdapterObserver<Adapter extends IAdapter>
{
	private final ModelObserver observer;
	private final Class<Adapter> adapterType;
	private final Consumer<Adapter> newAdapter;
	private final Consumer<Adapter> oldAapter;
	private final Map<ILilyEObject, Adapter> adaptedMap = new HashMap<>();

	public AdapterObserver(Class<Adapter> adapterType,
						   int[] referenceIds,
						   Consumer<Adapter> newAdapter,
						   Consumer<Adapter> oldAapter)
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

	private void notifyChanged(Notification notification)
	{
		if (notification.getNewValue() != notification.getOldValue())
		{
			NotificationUnifier.unify(notification, this::add, this::remove);
		}
	}

	public void startObserve(ILilyEObject root)
	{
		observer.startObserve(root);
	}

	public void stopObserve(ILilyEObject root)
	{
		observer.stopObserve(root);
	}

	private void add(ILilyEObject newValue)
	{
		final var adapter = newValue.adapt(adapterType);
		if (adapter != null)
		{
			adaptedMap.put(newValue, adapter);
			newAdapter.accept(adapter);
		}
	}

	private void remove(ILilyEObject oldValue)
	{
		final var oldAdapter = adaptedMap.get(oldValue);
		if (oldAdapter != null)
		{
			oldAapter.accept(oldAdapter);
		}
	}
}
