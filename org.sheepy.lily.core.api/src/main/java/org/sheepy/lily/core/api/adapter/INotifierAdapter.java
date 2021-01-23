package org.sheepy.lily.core.api.adapter;

import org.logoce.extender.api.IAdapter;
import org.logoce.notification.api.IFeatures;
import org.logoce.notification.api.INotifier;

public interface INotifierAdapter<Type extends IFeatures<Type>> extends INotifier<Type>, IAdapter
{}
