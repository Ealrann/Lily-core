package org.sheepy.lily.core.api.notification.observatory;

import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.core.api.notification.IFeature;

public interface INotifierAdapterObservatoryBuilder<Feature extends IFeature<?, ?>, Type extends INotifierAdapter<Feature>> extends
																															INotifierObservatoryBuilder<Feature>,
																															IAdapterObservatoryBuilder<Type>
{
}
