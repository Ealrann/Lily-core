package org.sheepy.lily.core.api.notification.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.List;
import java.util.function.Consumer;

public final class NotificationUnifier
{
	public static void unify(Notification notification, Consumer<ILilyEObject> onAdd, Consumer<ILilyEObject> onRemove)
	{
		unifyAdded(notification, onAdd);
		unifyRemoved(notification, onRemove);
	}

	@SuppressWarnings("unchecked")
	public static void unifyAdded(Notification notification, Consumer<ILilyEObject> onAdd)
	{
		switch (notification.getEventType())
		{
			case Notification.SET, Notification.UNSET -> {
				final var setted = notification.getNewValue();
				final var unsetted = notification.getOldValue();
				if (setted != unsetted)
				{
					if (setted instanceof ILilyEObject)
					{
						onAdd.accept((ILilyEObject) setted);
					}
				}
			}
			case Notification.ADD -> onAdd.accept((ILilyEObject) notification.getNewValue());
			case Notification.ADD_MANY -> {
				final var newList = (List<ILilyEObject>) notification.getNewValue();
				for (int i = 0; i < newList.size(); i++)
				{
					onAdd.accept(newList.get(i));
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void unifyRemoved(Notification notification, Consumer<ILilyEObject> onRemove)
	{
		switch (notification.getEventType())
		{
			case Notification.SET, Notification.UNSET -> {
				final var setted = notification.getNewValue();
				final var unsetted = notification.getOldValue();
				if (setted != unsetted)
				{
					if (unsetted instanceof ILilyEObject)
					{
						onRemove.accept((ILilyEObject) unsetted);
					}
				}
			}
			case Notification.REMOVE -> onRemove.accept((ILilyEObject) notification.getOldValue());
			case Notification.REMOVE_MANY -> {
				final var oldList = (List<ILilyEObject>) notification.getOldValue();
				for (int i = 0; i < oldList.size(); i++)
				{
					onRemove.accept(oldList.get(i));
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void unifyList(Notification notification,
								 Consumer<List<? extends ILilyEObject>> onAdd,
								 Consumer<List<? extends ILilyEObject>> onRemove)
	{
		assert notification.getFeature() instanceof EReference;
		switch (notification.getEventType())
		{
			case Notification.SET, Notification.UNSET -> {
				final var setted = (ILilyEObject) notification.getNewValue();
				final var unsetted = (ILilyEObject) notification.getOldValue();
				if (setted != unsetted)
				{
					if (unsetted != null)
					{
						onRemove.accept(List.of(unsetted));
					}
					if (setted != null)
					{
						onAdd.accept(List.of(setted));
					}
				}
			}
			case Notification.ADD -> onAdd.accept(List.of((ILilyEObject) notification.getNewValue()));
			case Notification.ADD_MANY -> onAdd.accept((List<ILilyEObject>) notification.getNewValue());
			case Notification.REMOVE -> onRemove.accept(List.of((ILilyEObject) notification.getOldValue()));
			case Notification.REMOVE_MANY -> onRemove.accept((List<ILilyEObject>) notification.getOldValue());
		}
	}
}
