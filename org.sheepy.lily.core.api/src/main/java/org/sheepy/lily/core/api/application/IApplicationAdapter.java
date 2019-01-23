package org.sheepy.common.api.application;

import org.sheepy.common.api.adapter.IAdapter;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.cadence.ICadencer;
import org.sheepy.common.model.application.Application;

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
