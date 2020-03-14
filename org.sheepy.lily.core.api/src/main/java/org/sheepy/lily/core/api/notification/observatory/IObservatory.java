package org.sheepy.lily.core.api.notification.observatory;

import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.notification.IFeature;

public interface IObservatory
{
	void observe(ILilyEObject parent);
	void shut(ILilyEObject parent);

	interface IBuilder
	{
		IObservatory build();
	}
}
