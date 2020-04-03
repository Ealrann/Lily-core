package org.sheepy.lily.core.api.notification.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.ILilyEObject;

import java.util.List;
import java.util.function.Consumer;

public final class ModelStructureBulkObserver
{
	private final ModelObserver observer;
	private final Consumer<List<? extends ILilyEObject>> onAddedObjects;
	private final Consumer<List<? extends ILilyEObject>> onRemovedObjects;

	public ModelStructureBulkObserver(EStructuralFeature feature,
									  Consumer<List<? extends ILilyEObject>> onAddedObjects,
									  Consumer<List<? extends ILilyEObject>> onRemovedObjects)
	{
		this(List.of(feature), onAddedObjects, onRemovedObjects);
	}

	public ModelStructureBulkObserver(List<EStructuralFeature> features,
									  Consumer<List<? extends ILilyEObject>> onAddedObjects,
									  Consumer<List<? extends ILilyEObject>> onRemovedObjects)
	{
		this.observer = new ModelObserver(this::notifyChanged, features);
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
