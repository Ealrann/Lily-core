package org.sheepy.lily.core.api.notification;

public final class Feature<Callback, Type extends IFeatures<?>>
{
	public static <Callback, Type extends IFeatures<?>> Feature<Callback, Type> newFeature()
	{
		//noinspection InstantiationOfUtilityClass
		return new Feature<>();
	}
}
