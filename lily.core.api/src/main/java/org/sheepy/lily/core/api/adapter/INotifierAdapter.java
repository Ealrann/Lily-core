package org.sheepy.lily.core.api.adapter;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.notification.IFeatures;
import org.logoce.lmf.core.api.notification.INotifier;

public interface INotifierAdapter<Type extends IFeatures<Type>> extends INotifier<Type>, IAdapter
{}
