package org.sheepy.lily.core.api.adapter;

import org.logoce.notification.api.Feature;
import org.logoce.notification.api.IFeatures;
import org.logoce.notification.api.Notifier;

import java.util.List;

public abstract class NotifierAdapter<Type extends IFeatures<Type>> extends Notifier<Type> implements INotifierAdapter<Type>
{
	public NotifierAdapter(List<Feature<?, ? super Type>> features)
	{
		super(features);
	}
}
