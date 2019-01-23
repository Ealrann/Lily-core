package org.sheepy.lily.core.api.cadence;

import java.util.ServiceLoader;

import org.sheepy.lily.core.api.service.IService;
import org.sheepy.lily.core.model.application.Application;

public interface IMainLoop extends IService
{
	
	void load(Application application);
	void step(Application application);

	static IMainLoop INSTANCE = ServiceLoader.load(IMainLoop.class).findFirst()
			.orElseGet(() -> null);
}
