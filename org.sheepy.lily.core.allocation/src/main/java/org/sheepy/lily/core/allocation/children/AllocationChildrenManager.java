package org.sheepy.lily.core.allocation.children;

import org.sheepy.lily.core.allocation.util.StructureObserver;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.IModelExplorer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class AllocationChildrenManager
{
	private final List<ChildEntryManager> childEntryManagers;
	private final Runnable whenDirty;
	private boolean dirty = true;

	public AllocationChildrenManager(final List<ChildEntryManager.Builder> childEntryManagers,
									 final IObservatoryBuilder observatoryBuilder,
									 final Runnable whenDirty)
	{
		this.childEntryManagers = childEntryManagers.stream()
													.map(builder -> builder.build(observatoryBuilder, this::setDirty))
													.collect(Collectors.toUnmodifiableList());
		this.whenDirty = whenDirty;
	}

	public void cleanup(final IAllocationContext context, boolean freeEverything)
	{
		final int size = childEntryManagers.size();
		for (int i = size - 1; i >= 0; i--)
		{
			final var childManager = childEntryManagers.get(i);
			childManager.cleanup(context, freeEverything);
		}
		if (freeEverything) dirty = true;
	}

	public void update(ILilyEObject source, final IAllocationContext context)
	{
		for (final var childManager : childEntryManagers)
		{
			childManager.update(source, context);
		}
		dirty = false;
	}

	private void setDirty()
	{
		if (dirty == false)
		{
			whenDirty.run();
			dirty = true;
		}
	}

	public boolean isDirty()
	{
		return dirty;
	}

	public static final class Builder
	{
		private final ILilyEObject target;
		private final List<ChildEntryManager.Builder> preChildEntryBuilders;
		private final List<ChildEntryManager.Builder> postChildEntryBuilders;

		public Builder(final List<AllocationChild> childAnnotations, final ILilyEObject target)
		{
			this.target = target;

			final List<ChildEntryManager.Builder> preList = new ArrayList<>();
			final List<ChildEntryManager.Builder> postList = new ArrayList<>();
			for (int i = 0; i < childAnnotations.size(); i++)
			{
				final var annotation = childAnnotations.get(i);
				final var entry = buildEntry(annotation, i);
				final var trgList = annotation.allocateBeforeParent() ? preList : postList;
				trgList.add(entry);
			}

			preChildEntryBuilders = List.copyOf(preList);
			postChildEntryBuilders = List.copyOf(postList);
		}

		private ChildEntryManager.Builder buildEntry(final AllocationChild childAnnotation, int index)
		{
			return new ChildEntryManager.Builder(target, childAnnotation, index);
		}

		public AllocationChildrenManager build(final Runnable whenDirty,
											   final boolean preallocation,
											   final IObservatoryBuilder observatoryBuilder)
		{
			final var entryBuilders = preallocation ? preChildEntryBuilders : postChildEntryBuilders;

			return new AllocationChildrenManager(entryBuilders, observatoryBuilder, whenDirty);
		}

		public IModelExplorer getChildrenExplorer(final int index)
		{
			return postChildEntryBuilders.stream()
										 .filter(b -> b.index() == index)
										 .findAny()
										 .map(ChildEntryManager.Builder::structureObservatoryBuilder)
										 .map(StructureObserver.Builder::buildExplorer)
										 .orElse(null);
		}
	}
}
