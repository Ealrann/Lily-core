package org.sheepy.lily.core.api.application;

import org.sheepy.lily.core.api.cadence.ICadenceManager;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.model.application.Application;

public interface IApplicationAdapter extends IExtender
{
	ICadenceManager getCadenceManager();

	void launch(Application application, Runnable step);
	void stop(Application application);
}
