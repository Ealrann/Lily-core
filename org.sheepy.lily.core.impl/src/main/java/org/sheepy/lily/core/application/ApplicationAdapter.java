package org.sheepy.lily.core.application;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.application.IApplicationAdapter;
import org.sheepy.lily.core.api.cadence.ICadencer;
import org.sheepy.lily.core.cadence.common.Cadencer;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationPackage;

@Statefull
@Adapter(scope = Application.class, scopeInheritance = true)
public class ApplicationAdapter implements IApplicationAdapter
{
	private Cadencer cadencer = null;

	private boolean launched = false;

	@NotifyChanged
	public void notifyChanged(Notification notification)
	{
		ApplicationAdapter that = this;
		if (notification.getFeature() == ApplicationPackage.Literals.APPLICATION__RUN)
		{
			if (launched == true && notification.getNewBooleanValue() == false)
			{
				new Thread()
				{
					@Override
					public void run()
					{
						that.stop((Application) notification.getNotifier());
					}
				}.start();
			}
		}
	}

	@Override
	public void launch(Application application)
	{
		cadencer = new Cadencer(application);

		cadencer.load();
		launched = true;

		try
		{
			cadencer.start();
		} catch (Throwable e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void stop(Application application)
	{
		cadencer.stop();
		cadencer = null;
	}

	@Override
	public ICadencer getCadencer()
	{
		return cadencer;
	}
}
