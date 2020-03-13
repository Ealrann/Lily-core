package org.sheepy.lily.core.api.notification;

public interface IFeature<Callback, Type extends IFeature<?, ?>>
{
	int ordinal();
}
