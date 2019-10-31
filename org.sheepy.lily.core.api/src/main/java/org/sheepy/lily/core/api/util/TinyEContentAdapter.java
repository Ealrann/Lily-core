package org.sheepy.lily.core.api.util;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EReference;

public abstract class TinyEContentAdapter extends AdapterImpl
{
	@Override
	public void notifyChanged(Notification notification)
	{
		final var feature = notification.getFeature();
		if (feature instanceof EReference && ((EReference) feature).isContainment() == true)
		{
			handleContainment(notification);
		}
	}

	private void handleContainment(Notification notification)
	{
		switch (notification.getEventType())
		{
		case Notification.UNSET:
		case Notification.SET:
		{
			final Notifier oldValue = (Notifier) notification.getOldValue();
			final Notifier newValue = (Notifier) notification.getNewValue();

			// Allow to re-set a reference to trigger the listeners,
			// without destroying the AdapterManager
			if (oldValue != newValue)
			{
				if (oldValue != null)
				{
					disposeChild(oldValue);
				}
				if (newValue != null)
				{
					setupChild(newValue);
				}
			}
			break;
		}
		case Notification.ADD:
		{
			final Notifier newValue = (Notifier) notification.getNewValue();
			if (newValue != null)
			{
				setupChild(newValue);
			}
			break;
		}
		case Notification.ADD_MANY:
		{
			@SuppressWarnings("unchecked")
			final var newValues = (List<Notifier>) notification.getNewValue();
			for (final Notifier newValue : newValues)
			{
				setupChild(newValue);
			}
			break;
		}
		case Notification.REMOVE:
		{
			final Notifier oldValue = (Notifier) notification.getOldValue();
			if (oldValue != null)
			{
				disposeChild(oldValue);
			}
			break;
		}
		case Notification.REMOVE_MANY:
		{
			@SuppressWarnings("unchecked")
			final var oldValues = (List<Notifier>) notification.getOldValue();
			for (final Notifier oldContentValue : oldValues)
			{
				disposeChild(oldContentValue);
			}
			break;
		}
		}
	}

	protected abstract void setupChild(Notifier notifier);
	protected abstract void disposeChild(Notifier notifier);
}
