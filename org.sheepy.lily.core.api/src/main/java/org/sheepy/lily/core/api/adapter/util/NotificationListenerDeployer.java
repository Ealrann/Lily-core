package org.sheepy.lily.core.api.adapter.util;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.core.api.notification.util.AbstractModelSetRegistry;

public class NotificationListenerDeployer extends AbstractModelSetRegistry
{
	private final INotificationListener listener;
	private final int[] featuresToListen;

	public NotificationListenerDeployer(List<EStructuralFeature> structure,
										INotificationListener listener,
										int... featuresToListen)
	{
		super(structure);
		this.listener = listener;
		this.featuresToListen = featuresToListen;
	}

	@Override
	protected void add(ILilyEObject newValue)
	{
		newValue.addListener(listener, featuresToListen);
	}

	@Override
	protected void remove(ILilyEObject oldValue)
	{
		oldValue.removeListener(listener, featuresToListen);
	}
}
