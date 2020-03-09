package org.sheepy.lily.core.api.variable;

import org.sheepy.lily.core.model.variable.DurationVariable;

public interface IDurationVariableAdapter extends IModelVariableAdapter<DurationVariable>
{
	void resetDuration();

	@Override
	default int bytes()
	{
		return Integer.BYTES;
	}
}
