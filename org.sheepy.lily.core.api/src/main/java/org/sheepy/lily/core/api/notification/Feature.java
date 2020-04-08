package org.sheepy.lily.core.api.notification;

public final class Feature<Callback, Type extends IFeatures<Type>>
{
	public static <Callback, Type extends IFeatures<Type>> Feature<Callback, Type> newFeature()
	{
		return new Feature<>();
	}
}
