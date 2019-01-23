package org.sheepy.lily.core.api.util;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Va appeller automatiquement les methods {@link #onAdd(EObject)} et {@link #onRemove(EObject)}.
 * 
 */
public abstract class FeatureAutoAdapter extends AdapterImpl
{
	private final EStructuralFeature adaptedFeature;
	private Notifier target;

	public FeatureAutoAdapter(EStructuralFeature adaptedFeature)
	{
		if (adaptedFeature.isMany() == false)
		{
			throw new UnsupportedOperationException(
					"For now, support only EStructuralFeature list");
		}

		this.adaptedFeature = adaptedFeature;
	}

	@Override
	public void setTarget(Notifier newTarget)
	{
		super.setTarget(newTarget);

		if (target != null)
		{
			if (target instanceof EObject)
			{
				@SuppressWarnings("unchecked")
				List<EObject> list = (List<EObject>) ((EObject) target).eGet(adaptedFeature);
				for (EObject eo : list)
				{
					onRemove(eo);
				}
			}
			
			target = null;
		}

		if (newTarget != null)
		{
			target = newTarget;

			if (newTarget instanceof EObject)
			{
				@SuppressWarnings("unchecked")
				List<EObject> list = (List<EObject>) ((EObject) newTarget).eGet(adaptedFeature);
				for (EObject eo : list)
				{
					onAdd(eo);
				}
			}
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public void notifyChanged(Notification msg)
	{
		super.notifyChanged(msg);

		if (msg.getFeature() == adaptedFeature)
		{
			switch (msg.getEventType())
			{
			case Notification.ADD:
				EObject eo = (EObject) msg.getNewValue();
				onAdd(eo);
				break;
			case Notification.REMOVE:
				eo = (EObject) msg.getOldValue();
				onRemove(eo);
				break;
			case Notification.ADD_MANY:
				List<EObject> list = (List<EObject>) msg.getNewValue();
				for (EObject _eo : list)
				{
					onAdd(_eo);
				}
				break;
			case Notification.REMOVE_MANY:
				list = (List<EObject>) msg.getOldValue();
				for (EObject _eo : list)
				{
					onRemove(_eo);
				}
				break;
			}
		}
	}

	protected abstract void onAdd(EObject object);
	protected abstract void onRemove(EObject object);
}
