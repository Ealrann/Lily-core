package org.sheepy.lily.core.api.adapter;

import org.sheepy.lily.core.api.notification.Notifier;

public abstract class NotifierAdapter extends Notifier implements INotifierAdapter
{
	public NotifierAdapter(int featureCount)
	{
		super(featureCount);
	}
}
