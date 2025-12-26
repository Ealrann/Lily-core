package org.sheepy.lily.core.allocation.util;

import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.api.notification.observatory.IObservatoryBuilder;
import org.logoce.lmf.core.api.notification.observatory.IEObjectObservatoryBuilder;
import org.logoce.lmf.core.api.util.IntModelExplorer;
import org.logoce.lmf.core.api.util.IModelExplorer;

import java.util.List;
import java.util.function.Consumer;

public final class StructureObserver
{
	private final Class<? extends IFeaturedObject> parentType;
	private final int[] featureIds;
	private final IntModelExplorer modelExplorer;

	public StructureObserver(final Class<? extends IFeaturedObject> parentType, final int[] featureIds)
	{
		this.parentType = parentType;
		this.featureIds = featureIds;
		this.modelExplorer = new IntModelExplorer(resolveParentClass(parentType), featureIds);
	}

	public Class<? extends IFeaturedObject> parentType()
	{
		return parentType;
	}

	public int[] featureIds()
	{
		return featureIds;
	}

	public IModelExplorer getExplorer()
	{
		return modelExplorer;
	}

	public void installGatherer(final IFeaturedObject source,
								final IObservatoryBuilder observatoryBuilder,
								final Consumer<List<LMObject>> onAdd,
								final Consumer<List<LMObject>> onRemove)
	{
		final var focus = findParent(source);
		IEObjectObservatoryBuilder<LMObject> explorerBuilder = observatoryBuilder.focus(focus);
		for (final var featureId : featureIds)
		{
			explorerBuilder = explorerBuilder.explore(featureId);
		}
		explorerBuilder.gatherBulk(onAdd, onRemove);
	}

	public void installListener(final IFeaturedObject source,
								final IObservatoryBuilder observatoryBuilder,
								final Runnable structureChanged)
	{
		if (featureIds.length == 0) return;

		final var focus = findParent(source);
		IEObjectObservatoryBuilder<LMObject> explorerBuilder = observatoryBuilder.focus(focus);

		for (int i = 0; i < featureIds.length - 1; i++)
		{
			explorerBuilder = explorerBuilder.explore(featureIds[i]);
		}

		explorerBuilder.listenNoParam(structureChanged, featureIds[featureIds.length - 1]);
	}

	private LMObject findParent(final IFeaturedObject source)
	{
		if (!(source instanceof LMObject current))
		{
			throw new IllegalArgumentException("StructureObserver requires an LMObject source");
		}

		while (parentType.isInstance(current) == false)
		{
			final var container = current.lmContainer();
			if (container == null)
			{
				throw new IllegalStateException(
						"Cannot find parent of type '%s' from '%s'".formatted(parentType.getSimpleName(),
																			 current.lmGroup().name()));
			}
			current = container;
		}
		return current;
	}

	@SuppressWarnings("unchecked")
	private static Class<? extends LMObject> resolveParentClass(final Class<? extends IFeaturedObject> parentType)
	{
		if (LMObject.class.isAssignableFrom(parentType))
		{
			return (Class<? extends LMObject>) parentType;
		}
		return LMObject.class;
	}
}
