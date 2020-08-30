package org.sheepy.lily.core.allocation.util;

import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IEObjectObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.IModelExplorer;
import org.sheepy.lily.core.api.util.IntModelExplorer;
import org.sheepy.lily.core.api.util.ModelUtil;

import java.util.List;
import java.util.function.Consumer;

public final class StructureObserver
{
	private final Class<? extends ILilyEObject> parentType;
	private final int[] features;
	private final IntModelExplorer modelExplorer;

	public StructureObserver(final Class<? extends ILilyEObject> parentType, final int[] features)
	{
		this.parentType = parentType;
		this.features = features;
		this.modelExplorer = new IntModelExplorer(parentType, features);
	}

	public IModelExplorer getExplorer()
	{
		return modelExplorer;
	}

	public void installGatherer(final ILilyEObject source,
								final IObservatoryBuilder observatoryBuilder,
								final Consumer<List<ILilyEObject>> onAdd,
								final Consumer<List<ILilyEObject>> onRemove)
	{
		final var parentHeight = ModelUtil.parentDistance(source, parentType);
		final var leafObservatory = explore(observatoryBuilder, parentHeight, true);
		leafObservatory.gatherBulk(onAdd, onRemove);
	}

	public void installListener(final ILilyEObject source,
								final IObservatoryBuilder observatoryBuilder,
								final Runnable structureChanged)
	{
		if (features.length > 0)
		{
			final var parentHeight = ModelUtil.parentDistance(source, parentType);
			final var leafObservatory = explore(observatoryBuilder, parentHeight, false);
			leafObservatory.listenNoParam(structureChanged, features[features.length - 1]);
		}
	}

	private IEObjectObservatoryBuilder<ILilyEObject> explore(final IObservatoryBuilder observatoryBuilder,
															 final int parentHeight,
															 final boolean exploreLastFeature)
	{
		IEObjectObservatoryBuilder<ILilyEObject> gatherableBuilder = observatoryBuilder;

		for (int i = 0; i < parentHeight; i++)
		{
			gatherableBuilder = gatherableBuilder.exploreParent();
		}

		final int size = exploreLastFeature ? features.length : features.length - 1;
		for (int i = 0; i < size; i++)
		{
			final var featureId = features[i];
			gatherableBuilder = gatherableBuilder.explore(featureId);
		}

		return gatherableBuilder;
	}
}
