package org.sheepy.lily.core.api.application;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.cadence.ICadencer;
import org.sheepy.lily.core.model.application.Application;

public interface IApplicationAdapter extends IAdapter
{
	ICadencer getCadencer();

	void launch(Application application);
	void stop(Application application);

	static IApplicationAdapter adapt(Application application)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(application, IApplicationAdapter.class);
	}
}
