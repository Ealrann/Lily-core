package org.sheepy.lily.core.api.application;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.cadence.ICadencer;
import org.sheepy.lily.core.model.application.Application;

public interface IApplicationAdapter extends IAdapter
{
	ICadencer getCadencer();

	void launch(Application application, Runnable step);
	void stop(Application application);
}
