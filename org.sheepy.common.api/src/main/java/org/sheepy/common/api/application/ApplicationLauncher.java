package org.sheepy.common.api.application;

import org.sheepy.common.model.application.Application;

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
