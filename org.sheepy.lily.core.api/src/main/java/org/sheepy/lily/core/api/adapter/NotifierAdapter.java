package org.sheepy.lily.core.api.adapter;

import org.sheepy.lily.core.api.notification.IFeature;
import org.sheepy.lily.core.api.notification.Notifier;

public abstract class NotifierAdapter<F extends IFeature<?>> extends Notifier<F> implements INotifierAdapter<F>
{
	public NotifierAdapter(int featureCount)
	{
		super(featureCount);
	}
}
