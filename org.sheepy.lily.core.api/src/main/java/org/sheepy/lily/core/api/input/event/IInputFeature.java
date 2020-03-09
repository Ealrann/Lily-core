package org.sheepy.lily.core.api.input.event;

import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeature;

public abstract class IInputFeature implements IFeature<IInputFeature>
{
	public static final class InputFeature<T> extends IInputFeature implements Feature<T, IInputFeature>
	{
		public final int ordinal;

		public InputFeature(int ordinal)
		{
			this.ordinal = ordinal;
		}

		@Override
		public int ordinal()
		{
			return ordinal;
		}
	}
}
