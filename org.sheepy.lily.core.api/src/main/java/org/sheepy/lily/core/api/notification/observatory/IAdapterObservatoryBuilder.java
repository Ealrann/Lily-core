package org.sheepy.lily.core.api.notification.observatory;

import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.IAdapterHandle;

import java.util.function.Consumer;

public interface IAdapterObservatoryBuilder<Adapter extends IAdapter>
{
	IAdapterObservatoryBuilder<Adapter> gatherAdaptation(Consumer<Adapter> discoveredAdapter,
														 Consumer<Adapter> removedAdapter);

	IAdapterObservatoryBuilder<Adapter> listenAdaptation(IAdapterHandle.ExtenderListener<Adapter> onAdapterUpdate);
	IAdapterObservatoryBuilder<Adapter> listenAdaptationNoParam(Runnable onAdapterUpdate);
}
