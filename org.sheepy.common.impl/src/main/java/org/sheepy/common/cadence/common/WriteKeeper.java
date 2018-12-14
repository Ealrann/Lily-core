package org.sheepy.common.cadence.common;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;

public class WriteKeeper extends EContentAdapter
{
	private final CommandStack commandStack;
	private boolean enabled = true;

	public WriteKeeper(CommandStack commandStack)
	{
		this.commandStack = commandStack;
	}

	@Override
	public void notifyChanged(Notification notification)
	{
		super.notifyChanged(notification);

		// On ne releve rien pour les Resources ni ResourceSet.
		if (enabled && notification.getNotifier() instanceof Resource == false
				&& notification.getNotifier() instanceof ResourceSet == false)
		{
			// On ne releve rien pour les Transients.
			if (notification.getFeature() instanceof EStructuralFeature
					&& ((EStructuralFeature) notification.getFeature()).isTransient())
				return;

			ILilyTransaction tx = commandStack.getCurrentTransaction();
			if ((tx == null) || (tx.getOwner() != Thread.currentThread()))
			{
				throw new IllegalStateException(
						"Cannot modify resource set without a write transaction");
			}
		}
	}

	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}
}