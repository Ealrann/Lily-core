package org.sheepy.lily.core.api.inference;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.Dispose;
import org.sheepy.lily.core.api.adapter.Load;
import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.core.model.inference.Inferer;

public interface IInfererAdapter extends IAdapter
{
	@Load
	default void load(EObject unit)
	{
		load((Inferer) unit);
	}

	@Dispose
	default void dispose(EObject unit)
	{
		dispose((Inferer) unit);
	}

	void load(Inferer unit);

	void dispose(Inferer unit);
}
