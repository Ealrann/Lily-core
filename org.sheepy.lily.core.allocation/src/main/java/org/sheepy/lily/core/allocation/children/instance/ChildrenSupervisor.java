package org.sheepy.lily.core.allocation.children.instance;

import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.allocation.children.manager.IAllocationChildrenManager;
import org.sheepy.lily.core.allocation.children.util.AllocationChildrenListUpdater;
import org.sheepy.lily.core.allocation.children.util.ChildAllocationContainer;
import org.sheepy.lily.core.allocation.instance.FreeContext;
import org.sheepy.lily.core.allocation.util.StructureObserver;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.util.IModelExplorer;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.api.util.StreamUtil;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ChildrenSupervisor
{
	private final Deque<ChildAllocationContainer> removedElements = new ArrayDeque<>();
	private final LinkedList<ChildAllocationContainer> allocatedElements = new LinkedList<>();
	private final Runnable whenBranchDirty;
	private final int index;

	private boolean addedElements = true;
	private final AllocationChildrenListUpdater childrenUpdater;

	private ChildrenSupervisor(final StructureObserver observatoryBuilder,
							   final IModelExplorer modelExplorer,
							   final Runnable whenBranchDirty,
							   final Optional<Consumer<EAllocationStatus>> listener,
							   final int index)
	{
		this.index = index;
		observatoryBuilder.installListeners(this::add, this::remove);
		this.whenBranchDirty = whenBranchDirty;
		childrenUpdater = new AllocationChildrenListUpdater(whenBranchDirty, listener, modelExplorer);
	}

	public void cleanup(final FreeContext context)
	{
		freeRemovedElements(context);
		reverseStream().flatMap(ChildAllocationContainer::reverseStreamContainers)
					   .forEach(child -> child.cleanup(context));
		if (context.freeEverything()) allocatedElements.clear();
	}

	private Stream<ChildAllocationContainer> reverseStream()
	{
		return StreamUtil.reverseStreamFromDeque(allocatedElements);
	}

	private void freeRemovedElements(final FreeContext context)
	{
		if (removedElements.isEmpty() == false)
		{
			final var subContext = context.encapsulate(true);
			while (removedElements.isEmpty() == false)
			{
				final var removed = removedElements.pop();
				removed.containers().forEach(c -> c.cleanup(subContext));
				allocatedElements.remove(removed);
			}
		}
	}

	public void update(ILilyEObject source, IAllocationContext context)
	{
		if (addedElements)
		{
			childrenUpdater.updateAllocationList(allocatedElements, source);
			addedElements = false;
		}

		allocatedElements.stream().flatMap(ChildAllocationContainer::streamContainers).forEach(c -> c.update(context));
	}

	public void add(List<ILilyEObject> children)
	{
		if (addedElements == false)
		{
			whenBranchDirty.run();
			addedElements = true;
		}
	}

	public void remove(List<ILilyEObject> removedChildren)
	{
		final boolean wasEmpty = removedElements.isEmpty();
		allocatedElements.stream()
						 .filter(a -> removedChildren.contains(a.target()))
						 .collect(Collectors.toCollection(() -> removedElements));
		if (wasEmpty && removedElements.isEmpty() == false)
		{
			whenBranchDirty.run();
		}
	}

	public int getIndex()
	{
		return index;
	}

	public void markChildrenObsolete()
	{
		for (final var allocatedElement : allocatedElements)
		{
			for (final var container : allocatedElement.containers())
			{
				container.markChildrenObsolete();
			}
		}
	}

	public static record Builder(int index,
								 StructureObserver.Builder structureObservatoryBuilder,
								 boolean buildStatusListener)
	{
		public Builder(final ILilyEObject source, final AllocationChild childAnnotation, int index)
		{
			this(index, buildStructureObserverBuilder(source, childAnnotation), childAnnotation.reportStateToParent());
		}

		private static StructureObserver.Builder buildStructureObserverBuilder(final ILilyEObject source,
																			   final AllocationChild childAnnotation)
		{
			final var parentClass = childAnnotation.parent();
			final var parentDistance = ModelUtil.parentDistance(source, parentClass);
			return new StructureObserver.Builder(parentDistance, childAnnotation.features());
		}

		public ChildrenSupervisor build(final IAllocationChildrenManager.Configuration config)
		{
			final var structureObserver = structureObservatoryBuilder.build(config.observatoryBuilder());
			final var modelExplorer = structureObservatoryBuilder.buildExplorer();
			final var statusListener = getStatusListener(config);

			return new ChildrenSupervisor(structureObserver,
										  modelExplorer,
										  config.whenBranchDirty(),
										  statusListener,
										  index);
		}

		private Optional<Consumer<EAllocationStatus>> getStatusListener(final IAllocationChildrenManager.Configuration config)
		{
			return buildStatusListener ? Optional.of(config::reactOnStatusChange) : Optional.empty();
		}
	}
}
