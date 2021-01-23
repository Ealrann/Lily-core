package org.sheepy.lily.core.cadence.adapter;

import org.logoce.adapter.api.Adapter;
import org.sheepy.lily.core.api.cadence.ICadenceContext;
import org.sheepy.lily.core.api.cadence.ICadenceTaskAdapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.cadence.CloseApplication;
import org.sheepy.lily.core.model.cadence.ICadenceTask;

@ModelExtender(scope = CloseApplication.class)
@Adapter(singleton = true)
public final class CloseApplicationAdapter implements ICadenceTaskAdapter
{
	@Override
	public void execute(ICadenceTask task, ICadenceContext context)
	{
		final var app = ModelUtil.findParent(task, Application.class);
		app.setRun(false);
	}
}
