package org.sheepy.lily.core.api.application;

import org.sheepy.lily.core.api.cadence.IMainLoop;
import org.sheepy.lily.core.model.application.Application;

public class ApplicationLauncher
{
	public static final void launch(Application application, IMainLoop mainLoop)
	{
		IApplicationAdapter.adapt(application).launch(application, mainLoop);
	}

	public static final void stop(Application application)
	{
		IApplicationAdapter.adapt(application).stop(application);
	}
}
