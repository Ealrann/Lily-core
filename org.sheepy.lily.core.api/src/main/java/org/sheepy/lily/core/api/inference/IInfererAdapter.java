package org.sheepy.lily.core.api.inference;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.model.inference.Inferer;

public interface IInfererAdapter extends IExtender
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
