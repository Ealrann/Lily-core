package org.sheepy.common.api.util;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * Va ajouter automatiquement un adapter sous un EObject
 * 
 */
public class ClassAdapterDeployer extends AdapterImpl
{

	private final EClass adaptedClass;
	private final Adapter adapter;

	public ClassAdapterDeployer(EClass adaptedClass, Adapter adapter)
	{
		this.adaptedClass = adaptedClass;
		this.adapter = adapter;
	}

	@Override
	public void setTarget(Notifier newTarget)
	{
		super.setTarget(newTarget);

		if (newTarget instanceof EObject)
		{
			for (EObject sub : ((EObject) newTarget).eContents())
			{
				if (adaptedClass.isSuperTypeOf(sub.eClass()))
				{
					sub.eAdapters().add(adapter);
				}
			}
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public void notifyChanged(Notification msg)
	{
		super.notifyChanged(msg);

		if (msg.getFeature() instanceof EReference
				&& ((EReference) msg.getFeature()).isContainment())
		{
			switch (msg.getEventType())
			{
			case Notification.ADD:
				EObject eo = (EObject) msg.getNewValue();
				if (adaptedClass.isSuperTypeOf(eo.eClass()))
				{
					eo.eAdapters().add(adapter);
				}
				break;
			case Notification.REMOVE:
				eo = (EObject) msg.getOldValue();
				if (adaptedClass.isSuperTypeOf(eo.eClass()))
				{
					eo.eAdapters().remove(adapter);
				}
				break;
			case Notification.ADD_MANY:
				List<EObject> list = (List<EObject>) msg.getNewValue();
				for (EObject _eo : list)
				{
					if (adaptedClass.isSuperTypeOf(_eo.eClass()))
					{
						_eo.eAdapters().add(adapter);
					}
				}
				break;
			case Notification.REMOVE_MANY:
				list = (List<EObject>) msg.getOldValue();
				for (EObject _eo : list)
				{
					if (adaptedClass.isSuperTypeOf(_eo.eClass()))
					{
						_eo.eAdapters().remove(adapter);
					}
				}
				break;
			}
		}
	}
}
