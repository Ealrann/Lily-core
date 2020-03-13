package org.sheepy.lily.core.api.adapter;

import org.sheepy.lily.core.api.notification.IFeature;
import org.sheepy.lily.core.api.notification.Notifier;

public abstract class NotifierAdapter<Type extends IFeature<?, ?>> extends Notifier<Type> implements INotifierAdapter<Type>
{
	public NotifierAdapter(int featureCount)
	{
		super(featureCount);
	}
}
