package org.sheepy.lily.core.api;

import org.sheepy.lily.core.api.application.IApplicationAdapter;
import org.sheepy.lily.core.api.cadence.IMainLoop;
import org.sheepy.lily.core.model.application.Application;

public class LilyLauncher
{
	public static final void launch(Application application)
	{
		IApplicationAdapter.adapt(application).launch(application);
	}

	public static final void launch(Application application, IMainLoop mainLoop)
	{
		IApplicationAdapter.adapt(application).launch(application, mainLoop);
	}

	public static final void stop(Application application)
	{
		IApplicationAdapter.adapt(application).stop(application);
	}
}
