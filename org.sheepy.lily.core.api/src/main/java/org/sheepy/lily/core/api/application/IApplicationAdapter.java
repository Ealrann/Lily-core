package org.sheepy.lily.core.api.application;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.cadence.ICadencer;
import org.sheepy.lily.core.api.cadence.IMainLoop;
import org.sheepy.lily.core.model.application.Application;

public interface IApplicationAdapter extends IAdapter
{
	ICadencer getCadencer();

	void launch(Application application, IMainLoop mainLoop);
	void stop(Application application);

	static IApplicationAdapter adapt(Application application)
	{
		return IAdapterFactoryService.INSTANCE.adapt(application, IApplicationAdapter.class);
	}
}
