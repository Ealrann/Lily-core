package org.sheepy.lily.core.api;

import org.sheepy.lily.core.api.application.IApplicationAdapter;
import org.sheepy.lily.core.model.application.Application;

public final class LilyLauncher
{
	public static void launch(Application application)
	{
		application.adaptNotNull(IApplicationAdapter.class).launch(application, null);
	}

	public static void launch(Application application, Runnable step)
	{
		application.adaptNotNull(IApplicationAdapter.class).launch(application, step);
	}

	public static void stop(Application application)
	{
		application.adaptNotNull(IApplicationAdapter.class).stop(application);
	}
}
