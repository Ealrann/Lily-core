package org.sheepy.lily.core.api.notification.util;

import java.util.List;
import java.util.function.Consumer;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.ILilyEObject;

public final class NotificationUnifier
{
	public static void unify(	Notification notification,
								Consumer<ILilyEObject> onAdd,
								Consumer<ILilyEObject> onRemove)
	{
		switch (notification.getEventType())
		{
		case Notification.SET:
		case Notification.UNSET:
			final var setted = notification.getNewValue();
			final var unsetted = notification.getOldValue();

			if (setted != unsetted)
			{
				if (setted instanceof ILilyEObject)
				{
					onAdd.accept((ILilyEObject) setted);
				}
				if (unsetted instanceof ILilyEObject)
				{
					onRemove.accept((ILilyEObject) unsetted);
				}
			}
			break;
		case Notification.ADD:
			final var added = (ILilyEObject) notification.getNewValue();
			onAdd.accept(added);
			break;
		case Notification.ADD_MANY:
			final var newList = (List<ILilyEObject>) notification.getNewValue();
			for (int i = 0; i < newList.size(); i++)
			{
				onAdd.accept(newList.get(i));
			}
			break;
		case Notification.REMOVE:
			final var removed = (ILilyEObject) notification.getOldValue();
			onRemove.accept(removed);
			break;
		case Notification.REMOVE_MANY:
			final var oldList = (List<ILilyEObject>) notification.getOldValue();
			for (int i = 0; i < oldList.size(); i++)
			{
				onRemove.accept(oldList.get(i));
			}
			break;
		default:
			break;
		}
	}

	public static void unifyList(	Notification notification,
									Consumer<List<? extends ILilyEObject>> onAdd,
									Consumer<List<? extends ILilyEObject>> onRemove)
	{
		switch (notification.getEventType())
		{
		case Notification.SET:
		case Notification.UNSET:
			final var setted = (ILilyEObject) notification.getNewValue();
			final var unsetted = (ILilyEObject) notification.getOldValue();

			if (setted != unsetted)
			{
				if (setted != null)
				{
					onAdd.accept(List.of(setted));
				}
				if (unsetted != null)
				{
					onRemove.accept(List.of(unsetted));
				}
			}
			break;
		case Notification.ADD:
			final var added = (ILilyEObject) notification.getNewValue();
			onAdd.accept(List.of(added));
			break;
		case Notification.ADD_MANY:
			final var newList = (List<ILilyEObject>) notification.getNewValue();
			onAdd.accept(newList);
			break;
		case Notification.REMOVE:
			final var removed = (ILilyEObject) notification.getOldValue();
			onRemove.accept(List.of(removed));
			break;
		case Notification.REMOVE_MANY:
			final var oldList = (List<ILilyEObject>) notification.getOldValue();
			onRemove.accept(oldList);
			break;
		default:
			break;
		}
	}
}
