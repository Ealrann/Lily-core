package org.sheepy.lily.core.api.notification.util;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.notification.INotificationListener;

public abstract class AbstractModelSetRegistry
{
	private final ModelObserver observer;
	private final INotificationListener listener = this::notifyChanged;

	public AbstractModelSetRegistry(List<EStructuralFeature> features)
	{
		observer = new ModelObserver(listener, features);
	}

	public void startRegister(ILilyEObject root)
	{
		observer.startObserve(root);
	}

	public void stopRegister(ILilyEObject root)
	{
		observer.stopObserve(root);
	}

	private void notifyChanged(Notification notification)
	{
		NotificationUnifier.unify(notification, this::add, this::remove);
	}

	protected abstract void add(ILilyEObject newValue);
	protected abstract void remove(ILilyEObject oldValue);
}
