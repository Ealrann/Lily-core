package org.sheepy.lily.core.application;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.application.IApplicationAdapter;
import org.sheepy.lily.core.api.cadence.ICadenceManager;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.cadence.common.CadenceManager;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationPackage;

@ModelExtender(scope = Application.class, inherited = true)
@Adapter
public class ApplicationAdapter implements IApplicationAdapter
{
	private CadenceManager cadenceManager = null;
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
		cadenceManager = new CadenceManager(application, step);

		cadenceManager.load();
		launched = true;

		if(DebugUtil.DEBUG_ENABLED)
		{
			final Runtime runtime = Runtime.getRuntime();
			final long total = runtime.totalMemory();
			final long free = runtime.freeMemory();
			final double used = (total - free) / 1e6;
			System.out.format("Used memory after load = %f Mb\n", used);
		}

		cadenceManager.run();
	}

	@Override
	public void stop(Application application)
	{
		if (launched == true)
		{
			cadenceManager.stop();
			cadenceManager = null;
			launched = false;
		}
	}

	@Override
	public ICadenceManager getCadenceManager()
	{
		return cadenceManager;
	}
}
