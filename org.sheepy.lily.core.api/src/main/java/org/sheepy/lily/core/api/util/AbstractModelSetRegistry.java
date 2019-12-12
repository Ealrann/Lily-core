package org.sheepy.lily.core.api.util;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.notification.INotificationListener;

public abstract class AbstractModelSetRegistry
{
	private final ModelSetObserver observer;
	private final INotificationListener listener = this::notifyChanged;

	public AbstractModelSetRegistry(List<EStructuralFeature> features)
	{
		observer = new ModelSetObserver(listener, features);
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
		switch (notification.getEventType())
		{
		case Notification.ADD:
			add((ILilyEObject) notification.getNewValue());
			break;
		case Notification.ADD_MANY:
			@SuppressWarnings("unchecked")
			final var newList = (List<ILilyEObject>) notification.getNewValue();
			for (int i = 0; i < newList.size(); i++)
			{
				final var newVal = newList.get(i);
				add(newVal);
			}
			break;
		case Notification.SET:
			if (notification.getOldValue() != null)
				remove((ILilyEObject) notification.getOldValue());
			if (notification.getNewValue() != null) add((ILilyEObject) notification.getNewValue());
			break;
		case Notification.REMOVE:
			remove((ILilyEObject) notification.getOldValue());
			break;
		case Notification.REMOVE_MANY:
			@SuppressWarnings("unchecked")
			final var oldList = (List<ILilyEObject>) notification.getOldValue();
			for (int i = 0; i < oldList.size(); i++)
			{
				final var oldVal = oldList.get(i);
				remove(oldVal);
			}
			break;
		}
	}

	protected abstract void add(ILilyEObject newValue);
	protected abstract void remove(ILilyEObject oldValue);
}
