package org.sheepy.common.api.inference;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.IAutoAdapter;
import org.sheepy.common.model.inference.Inferer;

public interface IInfererAdapter extends IAutoAdapter
{

	@Override
	default void load(EObject unit)
	{
		load((Inferer) unit);
	}

	@Override
	default void dispose(EObject unit)
	{
		dispose((Inferer) unit);
	}

	void load(Inferer unit);
	void dispose(Inferer unit);
}
