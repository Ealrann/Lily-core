package org.sheepy.lily.core.api.adapter;

import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.Notifier;

import java.util.List;

public abstract class NotifierAdapter<Type extends IFeatures<Type>> extends Notifier<Type> implements INotifierAdapter<Type>
{
	public NotifierAdapter(List<Feature<?, ? super Type>> features)
	{
		super(features);
	}
}
