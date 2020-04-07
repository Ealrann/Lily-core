package org.sheepy.lily.core.api.notification.observatory;

import org.sheepy.lily.core.api.adapter.ILilyEObject;

public interface IObservatory
{
	void observe(ILilyEObject parent);
	void shut(ILilyEObject parent);

	interface IBuilder
	{
		IObservatory build();
	}
}
