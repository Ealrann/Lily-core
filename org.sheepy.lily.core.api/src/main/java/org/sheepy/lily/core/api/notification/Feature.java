package org.sheepy.lily.core.api.notification;

public abstract class Feature<Callback, Type extends IFeature<?, ?>> implements IFeature<Callback, Type>
{
	private final int ordinal;

	public Feature(int ordinal)
	{
		this.ordinal = ordinal;
	}

	@Override
	public int ordinal()
	{
		return ordinal;
	}
}
