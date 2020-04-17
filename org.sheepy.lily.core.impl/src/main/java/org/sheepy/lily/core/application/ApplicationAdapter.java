package org.sheepy.lily.core.application;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.application.IApplicationAdapter;
import org.sheepy.lily.core.api.cadence.ICadencer;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.cadence.common.Cadencer;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationPackage;

@ModelExtender(scope = Application.class, inherited = true)
@Adapter
public class ApplicationAdapter implements IApplicationAdapter
{
	private Cadencer cadencer = null;
	private boolean launched = false;

	@NotifyChanged(featureIds = ApplicationPackage.APPLICATION__RUN)
	private void notifyChanged(Notification notification)
	{
		if (launched == true && notification.getNewBooleanValue() == false)
		{
			stop((Application) notification.getNotifier());
		}
	}

	@Override
	public void launch(Application application, Runnable step)
	{
		cadencer = new Cadencer(application, step);

		cadencer.load();
		launched = true;

		cadencer.run();
	}

	@Override
	public void stop(Application application)
	{
		if (launched == true)
		{
			cadencer.stop();
			cadencer = null;
			launched = false;
		}
	}

	@Override
	public ICadencer getCadencer()
	{
		return cadencer;
	}
}
