package org.sheepy.lily.core.allocation.children;

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

	public AllocationChildrenManager(List<ChildEntryManager.Builder> childEntryManagers, Runnable whenDirty)
	{
		this.childEntryManagers = childEntryManagers.stream()
													.map(builder -> builder.build(this::setDirty))
													.collect(Collectors.toUnmodifiableList());
		this.whenDirty = whenDirty;
	}

	public void cleanup(final ILilyEObject source, final IAllocationContext context, boolean freeEverything)
	{
		final int size = childEntryManagers.size();
		for (int i = size - 1; i >= 0; i--)
		{
			final var childManager = childEntryManagers.get(i);
			childManager.cleanup(source, context, freeEverything);
		}
		if (freeEverything) dirty = true;
	}

	public void update(ILilyEObject source, final IAllocationContext context)
	{
		for (final var childManager : childEntryManagers)
		{
			childManager.ensureAllocation(source, context);
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

	public IModelExplorer getChildrenExplorer(final int index)
	{
		final var res = childEntryManagers.stream()
										  .filter(entry -> entry.getIndex() == index)
										  .findAny()
										  .map(ChildEntryManager::getModelExplorer);
		assert res.isPresent();
		return res.get();
	}

	public static final class Builder
	{
		private final List<AllocationChild> childAnnotations;
		private final ILilyEObject target;

		public Builder(List<AllocationChild> childAnnotations, final ILilyEObject target)
		{
			this.childAnnotations = List.copyOf(childAnnotations);
			this.target = target;
		}

		public AllocationChildrenManager build(final IObservatoryBuilder observatoryBuilder,
											   final Runnable whenDirty,
											   final boolean preallocation)
		{
			final List<ChildEntryManager.Builder> builders = new ArrayList<>();
			for (int i = 0; i < childAnnotations.size(); i++)
			{
				final var annotation = childAnnotations.get(i);
				if (annotation.allocateBeforeParent() == preallocation)
				{
					builders.add(buildEntry(observatoryBuilder, annotation, i));
				}
			}
			return new AllocationChildrenManager(builders, whenDirty);

		}

		private ChildEntryManager.Builder buildEntry(final IObservatoryBuilder observatoryBuilder,
													 final AllocationChild childAnnotation,
													 int index)
		{
			return new ChildEntryManager.Builder(target, observatoryBuilder, childAnnotation, index);
		}
	}
}
