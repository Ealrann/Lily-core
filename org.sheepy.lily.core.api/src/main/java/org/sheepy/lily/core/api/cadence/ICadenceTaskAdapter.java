package org.sheepy.lily.core.api.cadence;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.model.cadence.ICadenceTask;

public interface ICadenceTaskAdapter extends IExtender
{
	void execute(ICadenceTask task, ICadenceContext context);
}
