package org.sheepy.lily.core.api.cadence;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.model.cadence.ICadenceTask;

public interface ICadenceTaskAdapter extends IAdapter
{
	void execute(ICadenceTask task, ICadenceContext context);
}
