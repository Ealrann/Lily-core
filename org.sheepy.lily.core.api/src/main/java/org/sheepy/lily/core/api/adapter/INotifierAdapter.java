package org.sheepy.lily.core.api.adapter;

import org.logoce.notification.api.IFeatures;
import org.logoce.notification.api.INotifier;
import org.sheepy.lily.core.api.extender.IExtender;

public interface INotifierAdapter<Type extends IFeatures<Type>> extends INotifier<Type>, IExtender
{}
