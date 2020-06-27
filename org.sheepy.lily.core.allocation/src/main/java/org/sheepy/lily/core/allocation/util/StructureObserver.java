package org.sheepy.lily.core.allocation.util;

import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IEObjectObservatoryBuilder;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.IModelExplorer;
import org.sheepy.lily.core.api.util.IntModelExplorer;

import java.util.List;
import java.util.function.Consumer;

public final class StructureObserver
{
	private final IObservatoryBuilder observatoryBuilder;
	private final int parentHeight;
	private final int[] features;

	public StructureObserver(IObservatoryBuilder observatoryBuilder, int parentHeight, int[] features)
	{
		this.observatoryBuilder = observatoryBuilder;
		this.parentHeight = parentHeight;
		this.features = features;
	}

	public void installListeners(Consumer<List<ILilyEObject>> onAdd, Consumer<List<ILilyEObject>> onRemove)
	{
		final var leafObservatory = explore();
		leafObservatory.gatherBulk(onAdd, onRemove);
	}

	private IEObjectObservatoryBuilder<ILilyEObject> explore()
	{
		IEObjectObservatoryBuilder<ILilyEObject> gatherableBuilder = observatoryBuilder;

		for (int i = 0; i < parentHeight; i++)
		{
			gatherableBuilder = gatherableBuilder.exploreParent();
		}

		for (int featureId : features)
		{
			gatherableBuilder = gatherableBuilder.explore(featureId);
		}

		return gatherableBuilder;
	}

	public static final class Builder
	{
		private final int parentHeight;
		private final int[] features;

		public Builder(int parentHeight, int[] features)
		{
			this.parentHeight = parentHeight;
			this.features = features;
		}

		public StructureObserver build(IObservatoryBuilder observatoryBuilder)
		{
			return new StructureObserver(observatoryBuilder, parentHeight, features);
		}

		public IModelExplorer buildExplorer()
		{
			return new IntModelExplorer(parentHeight, features);
		}
	}
}
