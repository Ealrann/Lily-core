package org.sheepy.lily.core.allocation.children;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.util.StructureObserver;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.IModelExplorer;
import org.sheepy.lily.core.api.util.ModelUtil;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ChildEntryManager
{
	private final Deque<ILilyEObject> removedElements = new ArrayDeque<>();
	private final LinkedList<ChildAllocationContainer> allocatedElements = new LinkedList<>();
	private final IModelExplorer modelExplorer;
	private final Runnable whenDirty;
	private final int index;

	private boolean addedElements = true;

	private ChildEntryManager(StructureObserver observatoryBuilder,
							  IModelExplorer modelExplorer,
							  Runnable whenDirty,
							  final int index)
	{
		this.index = index;
		observatoryBuilder.installListeners(this::add, this::remove);
		this.modelExplorer = modelExplorer;
		this.whenDirty = whenDirty;
	}

	public void cleanup(IAllocationContext context, boolean freeEverything)
	{
		final var removedAllocatedElements = allocatedElements.stream()
															  .filter(a -> removedElements.contains(a.target))
															  .collect(Collectors.toUnmodifiableList());
		for (final var removed : removedAllocatedElements)
		{
			removed.containers.forEach(c -> c.cleanup(context, true));
			allocatedElements.remove(removed);
		}
		removedElements.clear();

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
			allocatedElements.clear();

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

	private ChildContainer<?> newChildContainer(AllocationHandle<?> handle)
	{
		return new ChildContainer<>(handle, whenDirty);
	}

	public void add(List<ILilyEObject> children)
	{
		whenDirty.run();
		addedElements = true;
	}

	public void remove(List<ILilyEObject> removedChildren)
	{
		removedElements.addAll(removedChildren);
		whenDirty.run();
	}

	public IModelExplorer getModelExplorer()
	{
		return modelExplorer;
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

	public static record Builder(int index, StructureObserver.Builder structureObservatoryBuilder)
	{
		public Builder(final ILilyEObject source, final AllocationChild childAnnotation, int index)
		{
			this(index, buildStructureObserverBuilder(source, childAnnotation));
		}

		private static StructureObserver.Builder buildStructureObserverBuilder(final ILilyEObject source,
																			   final AllocationChild childAnnotation)
		{
			final var parentClass = childAnnotation.parent();
			final var parentDistance = ModelUtil.parentDistance(source, parentClass);
			return new StructureObserver.Builder(parentDistance, childAnnotation.features());
		}

		public ChildEntryManager build(IObservatoryBuilder observatoryBuilder, Runnable whenDirty)
		{
			return new ChildEntryManager(structureObservatoryBuilder.build(observatoryBuilder),
										 structureObservatoryBuilder.buildExplorer(),
										 whenDirty,
										 index);
		}

	}
}