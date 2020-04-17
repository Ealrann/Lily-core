package org.sheepy.lily.core.api.notification.util;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.function.Consumer;

public final class ModelStructureObserver
{
	private final ModelObserver observer;
	private final Consumer<ILilyEObject> onAddedObject;
	private final Consumer<ILilyEObject> onRemovedObject;

	public ModelStructureObserver(int feature,
								  Consumer<ILilyEObject> onAddedObject,
								  Consumer<ILilyEObject> onRemovedObject)
	{
		this(new int[]{feature}, onAddedObject, onRemovedObject);
	}

	public ModelStructureObserver(int[] features,
								  Consumer<ILilyEObject> onAddedObject,
								  Consumer<ILilyEObject> onRemovedObject)
	{
		this.observer = new ModelObserver(this::notifyChanged, features);
		this.onAddedObject = onAddedObject;
		this.onRemovedObject = onRemovedObject;
	}

	public void startObserve(ILilyEObject root)
	{
		observer.startObserve(root);
	}

	public void stopObserve(ILilyEObject root)
	{
		observer.stopObserve(root);
	}

	private void notifyChanged(Notification notification)
	{
		NotificationUnifier.unify(notification, onAddedObject, onRemovedObject);
	}
}
