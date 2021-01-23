package org.sheepy.lily.core.api.application;

import org.sheepy.lily.core.api.cadence.ICadenceManager;
import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.core.model.application.Application;

public interface IApplicationAdapter extends IAdapter
{
	ICadenceManager getCadenceManager();

	void launch(Application application, Runnable step);
	void stop(Application application);
}
