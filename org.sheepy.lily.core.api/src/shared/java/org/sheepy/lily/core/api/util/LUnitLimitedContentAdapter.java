package org.sheepy.common.api.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.model.root.LObject;

/**
 * 
 * LUnitContentAdapter qui ne se répands que sur une partie limitée du modèle.
 * 
 * @author ealrann
 *
 */
public abstract class LUnitLimitedContentAdapter extends LContentAdapter
{
	@Override
	protected void setTarget(EObject target)
	{
		if (needSpreadOn((LObject) target))
			super.setTarget(target);
		else
			super.basicSetTarget(target);
	}

	@Override
	protected void addAdapter(Notifier notifier)
	{
		if (notifier instanceof LObject && isApplicableOn((LObject) notifier))
		{
			super.addAdapter(notifier);
		}
	}

	@Override
	public void notifyChanged(Notification notification)
	{
		super.notifyChanged(notification);

		if (shouldUpdate(notification))
		{
			updateAdapter((LObject) notification.getNotifier());
		}
	}

	/**
	 * Update the adapter based on methods "isApplicableOn" and "canSpreadOn".
	 * We suppose here that the adapter is already placed.
	 * 
	 * @param unit
	 */
	private void updateAdapter(LObject unit)
	{
		if (isApplicableOn(unit) == false)
		{
			removeAdapter(unit);
		}

		if (needSpreadOn(unit))
		{
			for (LObject child : unit.lContents())
			{
				if (child.eAdapters().contains(this) == false)
				{
					addAdapter(child);
				}
			}
		}
		else
		{
			for (LObject child : unit.lContents())
			{
				if (child.eAdapters().contains(this))
				{
					removeAdapter(child);
				}
			}
		}
	}

	/**
	 * Should return true when the notification could have impacted the need to
	 * spread or remove the adapter.
	 * 
	 * @param notification
	 * @return
	 */
	protected abstract boolean shouldUpdate(Notification notification);

	/**
	 * Should return true if the adapter should be spreaded on children
	 * 
	 * @param unit
	 * @return
	 */
	protected abstract boolean needSpreadOn(LObject unit);

	/**
	 * If the adapter is applicable on this unit
	 * 
	 * @param unit
	 * @return
	 */
	protected abstract boolean isApplicableOn(LObject unit);
}
