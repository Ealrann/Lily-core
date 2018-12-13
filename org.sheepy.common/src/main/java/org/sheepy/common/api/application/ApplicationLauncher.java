package org.sheepy.common.api.application;

import org.sheepy.common.api.adapter.internal.ServiceAdapterFactory;
import org.sheepy.common.model.application.Application;

public class ApplicationLauncher
{
	public final static void launch(Application application)
	{
		ServiceAdapterFactory.INSTANCE.setupRootForAutoAdapters(application);
	}

	public final static void close(Application application)
	{
		//TODO
	}
}
