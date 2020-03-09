package org.sheepy.lily.core.api.adapter.util;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.core.api.notification.util.ModelStructureObserver;

import java.util.List;

public final class NotificationListenerDeployer
{
	private final INotificationListener listener;
	private final int[] featuresToListen;
	private final ModelStructureObserver structureObserver;

	public NotificationListenerDeployer(List<EStructuralFeature> structure,
										INotificationListener listener,
										int... featuresToListen)
	{
		structureObserver = new ModelStructureObserver(structure, this::add, this::remove);
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
		newValue.addListener(listener, featuresToListen);
	}

	private void remove(ILilyEObject oldValue)
	{
		oldValue.removeListener(listener, featuresToListen);
	}
}
