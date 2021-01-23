package org.sheepy.lily.core.api.cadence;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.core.model.cadence.ICadenceTask;

public interface ICadenceTaskAdapter extends IAdapter
{
	void execute(ICadenceTask task, ICadenceContext context);
}
