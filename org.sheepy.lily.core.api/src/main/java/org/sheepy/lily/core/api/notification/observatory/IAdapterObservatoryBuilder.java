package org.sheepy.lily.core.api.notification.observatory;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;

import java.util.function.Consumer;

public interface IAdapterObservatoryBuilder<Adapter extends IExtender>
{
	IAdapterObservatoryBuilder<Adapter> gatherAdaptation(Consumer<Adapter> discoveredAdapter,
														 Consumer<Adapter> removedAdapter);

	IAdapterObservatoryBuilder<Adapter> listenAdaptation(IExtenderHandle.ExtenderListener<Adapter> onAdapterUpdate);
	IAdapterObservatoryBuilder<Adapter> listenAdaptationNoParam(Runnable onAdapterUpdate);
}
