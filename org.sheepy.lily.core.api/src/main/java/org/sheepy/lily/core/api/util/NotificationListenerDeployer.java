package org.sheepy.lily.core.api.util;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.INotificationListener;
import org.sheepy.lily.core.api.adapter.LilyEObject;

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
	protected void add(LilyEObject newValue)
	{
		newValue.addListener(listener, featuresToListen);
	}

	@Override
	protected void remove(LilyEObject oldValue)
	{
		oldValue.removeListener(listener, featuresToListen);
	}
}
