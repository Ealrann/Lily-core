package org.sheepy.common.api.cadence;

import java.util.ServiceLoader;

import org.sheepy.common.api.service.IService;
import org.sheepy.common.model.application.Application;

public interface IMainLoop extends IService
{
	
	void load(Application application);
	void step(Application application);

	static IMainLoop INSTANCE = ServiceLoader.load(IMainLoop.class).findFirst()
			.orElseGet(() -> null);
}
