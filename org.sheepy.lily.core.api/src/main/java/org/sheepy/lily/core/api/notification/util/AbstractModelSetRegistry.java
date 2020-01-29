package org.sheepy.lily.core.api.notification.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.ILilyEObject;

import java.util.List;

public abstract class AbstractModelSetRegistry
{
	private final ModelObserver observer;

	public AbstractModelSetRegistry(List<EStructuralFeature> features)
	{
		observer = new ModelObserver(this::notifyChanged, features);
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
