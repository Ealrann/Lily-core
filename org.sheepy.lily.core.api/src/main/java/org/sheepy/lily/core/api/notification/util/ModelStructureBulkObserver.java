package org.sheepy.lily.core.api.notification.util;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.List;
import java.util.function.Consumer;

public final class ModelStructureBulkObserver
{
	private final ModelObserver observer;
	private final Consumer<List<? extends ILilyEObject>> onAddedObjects;
	private final Consumer<List<? extends ILilyEObject>> onRemovedObjects;

	public ModelStructureBulkObserver(int referenceId,
									  Consumer<List<? extends ILilyEObject>> onAddedObjects,
									  Consumer<List<? extends ILilyEObject>> onRemovedObjects)
	{
		this(new int [] {referenceId}, onAddedObjects, onRemovedObjects);
	}

	public ModelStructureBulkObserver(int[] referenceIds,
									  Consumer<List<? extends ILilyEObject>> onAddedObjects,
									  Consumer<List<? extends ILilyEObject>> onRemovedObjects)
	{
		this.observer = new ModelObserver(this::notifyChanged, referenceIds);
		this.onAddedObjects = onAddedObjects;
		this.onRemovedObjects = onRemovedObjects;
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
		NotificationUnifier.unifyList(notification, onAddedObjects, onRemovedObjects);
	}
}
