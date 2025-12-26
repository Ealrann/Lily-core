package org.sheepy.lily.core.api.cadence;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.sheepy.lily.core.model.cadence.ICadenceCondition;

public interface ICadenceConditionAdapter extends IAdapter
{
	boolean check(ICadenceCondition condition, ICadenceContext context);
}
