package org.sheepy.lily.core.api.adapter.util;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.util.ModelStructureObserver;

import java.util.function.Consumer;

public final class NotificationListenerDeployer
{
	private final Consumer<Notification> listener;
	private final int[] featuresToListen;
	private final ModelStructureObserver structureObserver;

	public NotificationListenerDeployer(int[] structuralFeatures,
										Consumer<Notification> listener,
										int... featuresToListen)
	{
		structureObserver = new ModelStructureObserver(structuralFeatures, this::add, this::remove);
		this.listener = listener;
		this.featuresToListen = featuresToListen;
	}

	public void startDeploy(ILilyEObject root)
	{
		structureObserver.startObserve(root);
	}

	public void stopDeploy(ILilyEObject root)
	{
		structureObserver.stopObserve(root);
	}

	private void add(ILilyEObject newValue)
	{
		newValue.listen(listener, featuresToListen);
	}

	private void remove(ILilyEObject oldValue)
	{
		oldValue.sulk(listener, featuresToListen);
	}
}
