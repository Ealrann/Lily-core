package org.sheepy.lily.core.allocation.children;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.allocation.util.StructureObserver;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.util.IModelExplorer;
import org.sheepy.lily.core.api.util.ModelUtil;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ChildEntryManager
{
	private final Deque<ChildAllocationContainer> removedElements = new ArrayDeque<>();
	private final LinkedList<ChildAllocationContainer> allocatedElements = new LinkedList<>();
	private final IModelExplorer modelExplorer;
	private final Runnable whenBranchDirty;
	private final Optional<Consumer<EAllocationStatus>> listener;
	private final int index;

	private boolean addedElements = true;

	private ChildEntryManager(final StructureObserver observatoryBuilder,
							  final IModelExplorer modelExplorer,
							  final Runnable whenBranchDirty,
							  final Optional<Consumer<EAllocationStatus>> listener,
							  final int index)
	{
		this.listener = listener;
		this.index = index;
		observatoryBuilder.installListeners(this::add, this::remove);
		this.modelExplorer = modelExplorer;
		this.whenBranchDirty = whenBranchDirty;
	}

	public void cleanup(IAllocationContext context, boolean freeEverything)
	{
		while (removedElements.isEmpty() == false)
		{
			final var removed = removedElements.pop();
			removed.containers.forEach(c -> c.cleanup(context, true));
			allocatedElements.remove(removed);
		}

		for (int i = allocatedElements.size() - 1; i >= 0; i--)
		{
			final var allocated = allocatedElements.get(i);
			final var containers = allocated.containers;
			for (int j = containers.size() - 1; j >= 0; j--)
			{
				final var container = containers.get(j);
				container.cleanup(context, freeEverything);
			}
		}

		if (freeEverything) allocatedElements.clear();
	}

	public void update(ILilyEObject source, IAllocationContext context)
	{
		if (addedElements)
		{
			final var children = modelExplorer.explore(source);
			for (int i = 0; i < children.size(); i++)
			{
				final var currentElement = children.get(i);
				if (i >= allocatedElements.size() || currentElement != allocatedElements.get(i).target())
				{
					final var childContainer = buildAllocationContainer(currentElement);
					allocatedElements.add(i, childContainer);
				}
			}
			addedElements = false;
		}

		allocatedElements.stream().flatMap(ChildAllocationContainer::streamContainers).forEach(c -> c.update(context));
	}

	private ChildAllocationContainer buildAllocationContainer(ILilyEObject target)
	{
		final List<ChildContainer<? extends IExtender>> containers = target.adapters()
																		   .adaptHandlesOfType(AllocationHandle.class)
																		   .map(handle -> (AllocationHandle<?>) handle)
																		   .map(this::newChildContainer)
																		   .collect(Collectors.toUnmodifiableList());
		return new ChildAllocationContainer(target, containers);
	}

	private ChildContainer<? extends IExtender> newChildContainer(AllocationHandle<?> handle)
	{
		return new ChildContainer<>(handle, whenBranchDirty, listener);
	}

	public void add(List<ILilyEObject> children)
	{
		whenBranchDirty.run();
		addedElements = true;
	}

	public void remove(List<ILilyEObject> removedChildren)
	{
		allocatedElements.stream()
						 .filter(a -> removedChildren.contains(a.target))
						 .collect(Collectors.toCollection(() -> removedElements));

		whenBranchDirty.run();
	}

	public int getIndex()
	{
		return index;
	}

	private static record ChildAllocationContainer(ILilyEObject target, List<ChildContainer<?>>containers)
	{
		public Stream<ChildContainer<?>> streamContainers()
		{
			return containers.stream();
		}
	}

	public static record Builder(int index, StructureObserver.Builder structureObservatoryBuilder,
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

		public ChildEntryManager build(final IAllocationChildrenManager.Configuration config)
		{
			final var structureObserver = structureObservatoryBuilder.build(config.observatoryBuilder());
			final var modelExplorer = structureObservatoryBuilder.buildExplorer();
			final var statusListener = getStatusListener(config);

			return new ChildEntryManager(structureObserver,
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
