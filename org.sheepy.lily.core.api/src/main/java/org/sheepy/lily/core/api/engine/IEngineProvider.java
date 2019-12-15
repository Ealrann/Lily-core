package org.sheepy.lily.core.api.engine;

import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.application.IView;

public interface IEngineProvider
{
	IEngine provide(Application application, IView view);
}
