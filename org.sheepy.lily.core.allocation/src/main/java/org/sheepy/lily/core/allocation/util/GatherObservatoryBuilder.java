package org.sheepy.lily.core.allocation.util;

import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IEObjectObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class GatherObservatoryBuilder
{
	private final List<Explorer> explorers = new ArrayList<>();

	public GatherObservatoryBuilder()
	{
	}

	public void explore(int parentHeight, int[] features)
	{
		assert features.length > 0;
		explorers.add(new Explorer(parentHeight, features));
	}

	public boolean isEmpty()
	{
		return explorers.isEmpty();
	}

	public IObservatory build(Consumer<ILilyEObject> onAdd, Consumer<ILilyEObject> onRemove)
	{
		final var observatoryBuilder = IObservatoryBuilder.newObservatoryBuilder();
		for (final var explorer : explorers)
		{
			final var leafObservatory = explorer.explore(observatoryBuilder);
			leafObservatory.gather(onAdd, onRemove);
		}
		return observatoryBuilder.build();
	}

	private static record Explorer(int parentHeight, int[]features)
	{
		public IEObjectObservatoryBuilder<ILilyEObject> explore(IObservatoryBuilder observatoryBuilder)
		{
			IEObjectObservatoryBuilder<ILilyEObject> gatherableBuilder = null;

			for (int i = 0; i < parentHeight; i++)
			{
				final var currentObservatoryBuilder = gatherableBuilder == null ? observatoryBuilder : gatherableBuilder;
				gatherableBuilder = currentObservatoryBuilder.exploreParent();
			}

			for (int featureId : features)
			{
				final var currentObservatoryBuilder = gatherableBuilder == null ? observatoryBuilder : gatherableBuilder;
				gatherableBuilder = currentObservatoryBuilder.explore(featureId);
			}

			return gatherableBuilder;
		}
	}
}
