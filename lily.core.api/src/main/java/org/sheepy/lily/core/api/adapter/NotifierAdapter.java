package org.sheepy.lily.core.api.adapter;

import org.logoce.lmf.core.api.notification.IFeature;
import org.logoce.lmf.core.api.notification.IFeatures;
import org.logoce.lmf.core.api.notification.Notifier;

import java.util.List;

public abstract class NotifierAdapter<Type extends IFeatures<Type>> extends Notifier<Type>
	implements INotifierAdapter<Type>
{
	public NotifierAdapter(final List<IFeature<?, ? super Type>> features)
	{
		super(features);
	}
}
