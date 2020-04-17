package org.sheepy.lily.core.api.cadence;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.model.cadence.ICadenceCondition;

public interface ICadenceConditionAdapter extends IExtender
{
	boolean check(ICadenceCondition condition, ICadenceContext context);
}
