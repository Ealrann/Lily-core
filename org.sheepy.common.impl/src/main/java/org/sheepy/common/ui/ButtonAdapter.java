package org.sheepy.common.ui;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.action.IActionDispatcher;
import org.sheepy.common.api.action.context.ExecutionContext;
import org.sheepy.common.api.adapter.IAutoAdapter;
import org.sheepy.common.api.adapter.impl.AbstractSingletonAdapter;
import org.sheepy.common.model.action.Action;
import org.sheepy.common.model.ui.Button;
import org.sheepy.common.model.ui.UiPackage;

public class ButtonAdapter extends AbstractSingletonAdapter implements IAutoAdapter
{
	@Override
	public void notifyChanged(Notification notification)
	{
		super.notifyChanged(notification);

		if (notification.getFeature() == UiPackage.Literals.ABSTRACT_BUTTON__PRESSED)
		{
			Button button = (Button) notification.getNotifier();

			if (button.isPressed() == true)
			{
				if (button.getActions().isEmpty() == false)
				{
					var actionDispatcher = IActionDispatcher.getService();
					for (Action action : button.getActions())
					{
						var context = new ExecutionContext(button.getExecutor(), action, null);
						actionDispatcher.postAction(context);
					}
				}
				button.setPressed(false);
			}
		}
	}

	@Override
	public void load(EObject target)
	{}

	@Override
	public void dispose(EObject target)
	{}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return UiPackage.Literals.BUTTON == eClass;
	}
}
