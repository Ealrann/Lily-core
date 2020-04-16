package org.sheepy.lily.core.adapter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.core.api.notification.util.EMFListenerMap;
import org.sheepy.lily.core.api.notification.util.NotificationUnifier;
import org.sheepy.lily.core.api.util.ModelUtil;

import java.util.function.Consumer;
import java.util.stream.Collectors;

public final class AdapterManagerDeployer extends AdapterImpl
{
	private final EMFListenerMap listenerMap;

	private boolean autoLoad = false;

	public AdapterManagerDeployer(EObject target)
	{
		setTarget(target);

		final int featureCount = target.eClass().getEAllStructuralFeatures().size();
		listenerMap = new EMFListenerMap(featureCount);

		target.eAdapters().add(this);
	}

	public void listen(Consumer<Notification> listener, int... features)
	{
		listenerMap.listen(listener, features);
	}

	public void sulk(Consumer<Notification> listener, int... features)
	{
		listenerMap.sulk(listener, features);
	}

	public void listenNoParam(Runnable listener, int... features)
	{
		listenerMap.listenNoParam(listener, features);
	}

	public void sulkNoParam(Runnable listener, int... features)
	{
		listenerMap.sulkNoParam(listener, features);
	}

	@Override
	public void notifyChanged(Notification notification)
	{
		final var feature = notification.getFeature();
		if (feature instanceof EReference && ((EReference) feature).isContainment() == true)
		{
			NotificationUnifier.unify(notification, this::setupChild, this::disposeChild);
		}

		listenerMap.notify(notification);
	}

	private void setupChild(ILilyEObject notifier)
	{
		final var child = (LilyEObject) notifier;
		child.setupAdapterManager();

		if (autoLoad)
		{
			child.loadAdapterManager();
		}
	}

	private void disposeChild(ILilyEObject notifier)
	{
		if (autoLoad)
		{
			final var child = (LilyEObject) notifier;
			child.disposeAdapterManager();
		}
	}

	public void foreachChild(Consumer<LilyEObject> consumer)
	{
		ModelUtil.streamChildren((EObject) target)
				 .map(LilyEObject.class::cast)
				 .collect(Collectors.toList())
				 .forEach(consumer);
	}

	public void setAutoLoad(boolean autoLoad)
	{
		this.autoLoad = autoLoad;
	}
}
