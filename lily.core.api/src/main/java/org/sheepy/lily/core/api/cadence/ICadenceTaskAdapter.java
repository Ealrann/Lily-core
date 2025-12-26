package org.sheepy.lily.core.api.cadence;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.sheepy.lily.core.model.cadence.ICadenceTask;

public interface ICadenceTaskAdapter extends IAdapter
{
	void execute(ICadenceTask task, ICadenceContext context);
}
