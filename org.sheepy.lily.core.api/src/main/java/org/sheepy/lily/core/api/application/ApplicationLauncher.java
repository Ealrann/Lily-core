package org.sheepy.lily.core.api.application;

import org.sheepy.lily.core.model.application.Application;

public class ApplicationLauncher
{
	public static final void launch(Application application)
	{
		IApplicationAdapter.adapt(application).launch(application);
	}

	public static final void stop(Application application)
	{
		IApplicationAdapter.adapt(application).stop(application);
	}
}
