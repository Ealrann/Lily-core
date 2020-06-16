package org.sheepy.lily.core.extender;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.core.api.notification.IEMFNotifier;
import org.sheepy.lily.core.api.notification.util.EMFListenerMap;
import org.sheepy.lily.core.api.notification.util.NotificationUnifier;
import org.sheepy.lily.core.api.util.ModelUtil;

import java.util.function.Consumer;

public final class ExtenderManagerDeployer extends AdapterImpl implements IEMFNotifier
{
	private final EMFListenerMap listenerMap;

	private boolean autoLoad = false;

	public ExtenderManagerDeployer(EObject target)
	{
		setTarget(target);

		final int featureCount = target.eClass().getEAllStructuralFeatures().size();
		listenerMap = new EMFListenerMap(featureCount);

		target.eAdapters().add(this);
	}

	@Override
	public ILilyEObject getTarget()
	{
		return (ILilyEObject) super.getTarget();
	}

	@Override
	public void listen(Consumer<Notification> listener, int... features)
	{
		listenerMap.listen(listener, features);
	}

	@Override
	public void sulk(Consumer<Notification> listener, int... features)
	{
		listenerMap.sulk(listener, features);
	}

	@Override
	public void listenNoParam(Runnable listener, int... features)
	{
		listenerMap.listenNoParam(listener, features);
	}

	@Override
	public void sulkNoParam(Runnable listener, int... features)
	{
		listenerMap.sulkNoParam(listener, features);
	}

	@Override
	public void notifyChanged(Notification notification)
	{
		final var feature = notification.getFeature();
		final boolean isContainment = feature instanceof EReference && ((EReference) feature).isContainment() == true;
		if (isContainment)
		{
			NotificationUnifier.unifyAdded(notification, this::setupChild);
		}

		listenerMap.notify(notification);

		if (isContainment)
		{
			NotificationUnifier.unifyRemoved(notification, this::disposeChild);
		}
	}

	private void setupChild(ILilyEObject notifier)
	{
		final var child = (LilyEObject) notifier;
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
		ModelUtil.streamChildren(getTarget()).map(LilyEObject.class::cast).forEach(consumer);
	}

	public void setAutoLoad(boolean autoLoad)
	{
		this.autoLoad = autoLoad;
	}
}
