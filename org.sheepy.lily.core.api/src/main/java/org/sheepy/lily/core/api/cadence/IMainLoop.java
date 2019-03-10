package org.sheepy.lily.core.api.cadence;

import org.sheepy.lily.core.model.application.Application;

public interface IMainLoop
{
	void load(Application application);
	void step(Application application);
	void free(Application application);
}
