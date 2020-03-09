package org.sheepy.lily.core.api.notification.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.ILilyEObject;

import java.util.List;
import java.util.function.Consumer;

public final class ModelStructureObserver
{
	private final ModelObserver observer;
	private final Consumer<ILilyEObject> onAddedObject;
	private final Consumer<ILilyEObject> onRemovedObject;

	public ModelStructureObserver(EStructuralFeature feature,
								  Consumer<ILilyEObject> onAddedObject,
								  Consumer<ILilyEObject> onRemovedObject)
	{
		this(List.of(feature), onAddedObject, onRemovedObject);
	}

	public ModelStructureObserver(List<EStructuralFeature> features,
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
