package org.sheepy.lily.core.allocation.util;

import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IEObjectObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.IModelExplorer;
import org.sheepy.lily.core.api.util.IntModelExplorer;

import java.util.List;
import java.util.function.Consumer;

public final class StructureObserverBuilder
{
	private final IObservatoryBuilder observatoryBuilder;
	private final int parentHeight;
	private final int[] features;

	public StructureObserverBuilder(IObservatoryBuilder observatoryBuilder, int parentHeight, int[] features)
	{
		this.observatoryBuilder = observatoryBuilder;
		this.parentHeight = parentHeight;
		this.features = features;
	}

	public IModelExplorer buildExplorer()
	{
		return new IntModelExplorer(parentHeight, features);
	}

	public void installListeners(Consumer<List<ILilyEObject>> onAdd, Consumer<List<ILilyEObject>> onRemove)
	{
		final var leafObservatory = explore(observatoryBuilder);
		leafObservatory.gatherBulk(onAdd, onRemove);
	}

	private IEObjectObservatoryBuilder<ILilyEObject> explore(IObservatoryBuilder observatoryBuilder)
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
