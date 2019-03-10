package org.sheepy.lily.core.application;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.application.IApplicationAdapter;
import org.sheepy.lily.core.api.cadence.ICadencer;
import org.sheepy.lily.core.api.cadence.IMainLoop;
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
		if (notification.getFeature() == ApplicationPackage.Literals.APPLICATION__RUN)
		{
			if (launched == true && notification.getNewBooleanValue() == false)
			{
				stop((Application) notification.getNotifier());
			}
		}
	}

	@Override
	public void launch(Application application, IMainLoop mainLoop)
	{
		cadencer = new Cadencer(application, mainLoop);

		cadencer.load();
		launched = true;

		try
		{
			cadencer.run();
		} catch (Throwable e)
		{
			e.printStackTrace();
		}
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
