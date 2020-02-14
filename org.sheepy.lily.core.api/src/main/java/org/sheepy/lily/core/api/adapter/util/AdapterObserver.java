package org.sheepy.lily.core.api.adapter.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.notification.util.ModelObserver;
import org.sheepy.lily.core.api.notification.util.NotificationUnifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class AdapterObserver<T extends IAdapter>
{
	private final ModelObserver observer;
	private final Class<? extends IAdapter> adapterType;
	private final Consumer<T> newAdapter;
	private final Consumer<T> oldAapter;
	private final Map<ILilyEObject, T> adaptedMap = new HashMap<>();

	public AdapterObserver(Class<? extends IAdapter> adapterType,
						   List<EReference> features,
						   Consumer<T> newAdapter,
						   Consumer<T> oldAapter)
	{
		this.observer = new ModelObserver(this::notifyChanged, features);
		this.adapterType = adapterType;
		this.newAdapter = newAdapter;
		this.oldAapter = oldAapter;
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
		final var adapter = newValue.<T>adaptGeneric(adapterType);
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
