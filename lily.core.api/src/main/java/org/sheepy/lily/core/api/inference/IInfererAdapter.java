package org.sheepy.lily.core.api.inference;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.lang.LMObject;
import org.sheepy.lily.core.api.adapter.Dispose;
import org.sheepy.lily.core.api.adapter.Load;
import org.sheepy.lily.core.model.inference.Inferer;

public interface IInfererAdapter extends IAdapter
{
	@Load
	default void load(final LMObject unit)
	{
		load((Inferer) unit);
	}

	@Dispose
	default void dispose(final LMObject unit)
	{
		dispose((Inferer) unit);
	}

	void load(Inferer unit);

	void dispose(Inferer unit);
}

